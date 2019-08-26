package 腾讯;

import java.util.Scanner;

/*
给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
输出需要删除的字符个数。

输入例子: 
abcda
google
 
输出例子: 对于每组数据，输出一个整数，代表最少需要删除的字符个数。
2
2
 */   
//动态规划
public class 构造回文 {
	public static int LCS(String str1,String str2) {
		int len=str1.length();
		int[][] dp=new int[len+1][len+1];
		 for (int i=0;i<len+1;i++)
	         dp[i][0]=dp[0][i]=0;
		 for(int i=1;i<len+1;i++) {
			 for(int j=1;j<len+1;j++) {
				 if(str1.charAt(i-1)==str2.charAt(j-1)) { //与反字符串比较，有一个相同字符的记1次，并且和上对角的累计在一起
					 dp[i][j]=dp[i-1][j-1]+1;
				 }else if(dp[i][j-1]>dp[i-1][j]) {//与反字符串比较有不同字符时，该坐标左边与上面比较取较大值
					 dp[i][j]=dp[i][j-1];
				 }else {
					 dp[i][j]=dp[i-1][j];
				 }
			 }
		 }
		 return dp[len][len];  //上面的运算把累计的最大次数推到了最右下格

	}
		

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String str=scanner.nextLine();
			String strrev=new StringBuilder(str).reverse().toString();
			System.out.println(str.length() - LCS(str, strrev));
		}
		

	}

}
