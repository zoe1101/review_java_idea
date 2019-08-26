package 递归与动态规划;

public class 最长公共子串问题 {
	public static String lcst1(String str1,String str2) {
		if (str1==null || str2==null ||str1.length()==0 || str2.length()==0) {
			return "";
		}
		char[] chs1=str1.toCharArray();
		char[] chs2=str2.toCharArray();
		//dp[i][j]:把str1[i]与str2[j]当成公共子串最后一个字符时，公共子串的长度
		int[][] dp=new int[chs1.length][chs2.length];
		for (int i = 0; i < chs1.length; i++) {
			if (chs1[i]==chs2[0]) {
				dp[i][0]=1;
			}
		}
		for (int i = 1; i < chs2.length; i++) {
			if (chs1[0]==chs2[i]) {
				dp[0][i]=1;
			}
		}
		for (int i = 1; i < chs1.length; i++) {
			for (int j = i; j < chs2.length; j++) {
				if (chs1[i]==chs2[j]) {
					dp[i][j]=dp[i-1][j-1]+1;
				}
			}
		}
		
		int end=0; //公共字符串最后一个字符对应str1中位置
		int max=0; //最大公共字符串记录
		for (int i = 0; i < chs1.length; i++) {
			for (int j = 0; j < chs2.length; j++) {
				if (dp[i][j]>max) {
					end=i;
					max=dp[i][j];
				}
			}
		}
		return str1.substring(end-max+1,end+1);
	}
	//简化的动态规划
	public static String lcst2(String str1,String str2)  {
		if (str1==null || str2==null ||str1.length()==0 || str2.length()==0) {
			return "";
		}
		char[] chs1=str1.toCharArray();
		char[] chs2=str2.toCharArray();
		int row=0; //斜线开始位置的行
		int col=chs2.length-1; //斜线开始位置的列
		int max=0; //记录最大长度
		int end=0; //最大长度更新时，记录子串的结束位置
		while (row<chs1.length) { //斜线从右上方开始
			int i=row;
			int j=col;
			int len=0;
			while (i<chs1.length && j<chs2.length) {
				if (chs1[i]==chs2[j]) {
					len++;
				}else {
					len=0;
				}
				if (len>max) { //记录最大值及结束位置
					end=i;
					max=len;
				}
				i++;
				j++;
			}
			if (col>0) { //斜线开始位置的列先向左移动
				col--;
			}else {  //列移动到最左后,行向下移动
				row++;
			}
		}
		return str1.substring(end-max+1,end+1);
	}
	public static void main(String[] args) {
		String str1 = "ABC1234567DEFG";
		String str2 = "HIJKL1234567MNOP";
		System.out.println(lcst1(str1, str2));
		System.out.println(lcst2(str1, str2));

	}
}
