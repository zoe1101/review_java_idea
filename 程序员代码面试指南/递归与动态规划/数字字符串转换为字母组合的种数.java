package 递归与动态规划;

public class 数字字符串转换为字母组合的种数 {
	//暴力d递归
	public static int num1(String str) {
		if (str==null || str.length()==0) {
			return 0;
		}
		char[] chas=str.toCharArray();
		return process(chas, 0);
		
	}
	public static int process(char[] chas,int i) {
		if (i==chas.length) {
			return 1;
		}
		if (chas[i]=='0') {
			return 0;
		}
		//p[i]依赖于p[i+1]与p[i+2]
		int res=process(chas, i+1);
		if (i+1<chas.length &&(chas[i]-'0')*10+chas[i+1]-'0'<=26) {
			res+=process(chas, i+2);
		}
		return res;
	}
	//动态规划法,从后往前推
	public static int num2(String str) {
		if (str==null || str.length()==0) {
			return 0;
		}
		char[] chas=str.toCharArray();
		int cur=chas[chas.length-1]=='0'?0:1;
		int next=1;
		int tmp=0;
		for (int i = chas.length-2; i >=0; i--) {
			if (chas[i]=='0') {
				next=cur;
				cur=0;
			}else {
				tmp=cur;
				if ((chas[i]-'0')*10+chas[i+1]-'0'<=26) {
					cur=next;
				}
				next=tmp;
			}
		}
		return cur;
	}

}
