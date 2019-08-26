package 递归与动态规划;

public class 表达式得到期望结果的组成种数 {
	//检查表达式是否有效
	/*长度必须为奇数
	 * 下标为偶数时为0或1,下标从0开始
	 * 下标为奇数时为‘&’，‘|’或‘^’
	 */
	public static boolean isValid(char[] exp) {
		if((exp.length &1)==0) { //长度二进制最低位不为1时为偶数，故与1交为0
			return false;
		}
		for (int i = 0; i < exp.length; i=i+2) {
			if (exp[i]!='1' &&  exp[i]!='0' ) {
				return false;
			}
		}
		for (int i = 1; i < exp.length; i=i+2) {
			if (exp[i]!='^' &&  exp[i]!='&' &&  exp[i]!='|' ) {
				return false;
			}
		}
		return true;
	}
	//暴力递归,按运算符把表达式分成两部分，然后分情况考虑
//	时间复杂度：O(N!)
	public static int num1(String express,boolean desired) {
		if (express==null || express.length()==0) {
			return 0;
		}
		char[] exp=express.toCharArray();
		if (!isValid(exp)) {
			return 0;
		}
		return p(exp, desired, 0, exp.length-1);
	}
	public static int p(char[] exp,boolean desired,int left,int right) {
		if (left==right) {
			if (exp[left]=='1') {
				return desired?1:0;
			}else {
				return desired?0:1;
			}
		}
		int res=0;
		if (desired) { //期望结果为true
			for (int i = left+1; i < right; i=i+2) {//运算符遍历
				switch (exp[i]) {
				case '&':
					res+=p(exp, true, left, i-1)*p(exp, true, i+1, right);
					break;
				case '|':
					res+=p(exp, true, left, i-1)*p(exp, true, i+1, right);
					res+=p(exp, true, left, i-1)*p(exp, false, i+1, right);
					res+=p(exp, false, left, i-1)*p(exp, true, i+1, right);
					break;
				case '^':
					res+=p(exp, true, left, i-1)*p(exp, false, i+1, right);
					res+=p(exp, false, left, i-1)*p(exp, true, i+1, right);
					break;
				default:
					break;
				}
			}
		}else {//期望结果为false
			for (int i = left+1; i < right; i=i+2) {//运算符遍历
				switch (exp[i]) {
				case '&':
					res+=p(exp, false, left, i-1)*p(exp, true, i+1, right);
					res+=p(exp, true, left, i-1)*p(exp, false, i+1, right);
					res+=p(exp, false, left, i-1)*p(exp, false, i+1, right);
					break;
				case '|':
					res+=p(exp, false, left, i-1)*p(exp, false, i+1, right);
					break;
				case '^':
					res+=p(exp, false, left, i-1)*p(exp, false, i+1, right);
					res+=p(exp, true, left, i-1)*p(exp, true, i+1, right);
					break;
				default:
					break;
				}
			}
		}
		return res;
	}
//动态规划
	public static int num2(String express,boolean desired) {
		if (express==null || express.length()==0) {
			return 0;
		}
		char[] exp=express.toCharArray();
		if (!isValid(exp)) {
			return 0;
		}
		int len=exp.length;
		int[][] tr=new int[len][len];
		int[][] fa=new int[len][len];
		tr[0][0]=exp[0]=='1'?1:0;
		fa[0][0]=exp[0]=='0'?1:0;
		
	    //计算j到i的运算结果
		for (int i = 2; i < len; i=i+2) {
			tr[i][i]=exp[0]=='1'?1:0;
			fa[i][i]=exp[0]=='0'?1:0;
			for (int j = i-2; j >=0 ;j=j-2) {
				for (int k = j; k <i; k=k+2) { //运算符遍历
					if (exp[k+1]=='&') {
						tr[j][i]+=tr[j][k]*tr[k+2][i];
						fa[j][i]=fa[j][k]*fa[k+2][i]+fa[j][k]*tr[k+2][i]+tr[j][k]*fa[k+2][i];
					}else if (exp[k+1]=='|') {
						tr[j][i]=tr[j][k]*tr[k+2][i]+fa[j][k]*tr[k+2][i]+tr[j][k]*fa[k+2][i];
						fa[j][i]+=fa[j][k]*fa[k+2][i];
					}else if (exp[k+1]=='^') {//异或
						tr[j][i]=fa[j][k]*tr[k+2][i]+tr[j][k]*fa[k+2][i];
						fa[j][i]+=tr[j][k]*tr[k+2][i]+fa[j][k]*fa[k+2][i];
					}
				}
			}
		}
		return desired?tr[0][len-1]:fa[0][len-1];
	}
	public static void main(String[] args) {
		String express = "1^0|0|1";
		boolean desired = true;
		System.out.println(num1(express, desired));
		System.out.println(num2(express, desired));

	}
}
