package 字符串;

public class 回文最少分割数 {
	public static int minCut(String str) {
		if (str==null || str.length()==0) {
			return 0;
		}
		char[] chas=str.toCharArray();
		int len=chas.length;
		int[] dp=new int[len+1]; //dp[i]:str[i..len-1]回文最少分割数
		dp[len]=-1;
		boolean[][] p=new boolean[len][len]; //p[i][j]：str[i..j]是否回文
		for (int i = len-1; i >=0; i--) { //从右往左遍历
			dp[i]=Integer.MAX_VALUE;
			for (int j = i; j < len; j++) { //计算str[i..j]是否回文
				//j-i<2:str[i]与str[j]相邻
				//p[i+1][j-1]：str[i+1..j-1]是回文
				if (chas[i]==chas[j] && (j-i<2 || p[i+1][j-1])) {
					p[i][j]=true;
					dp[i]=Math.min(dp[i], dp[j+1]+1);
				}
			}
		}
		return dp[0];
	}

}
