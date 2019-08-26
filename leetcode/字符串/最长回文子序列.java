package 字符串;

import javax.naming.InitialContext;

import test.class_A;

/*
给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。

输入:
"bbbab"
输出:
4
 */
//子序列可以不连续
//对任意字符串，如果头和尾相同，那么它的最长回文子序列一定是去头去尾之后的部分的最长回文子序列加上头和尾。
//如果头和尾不同，那么它的最长回文子序列是去头的部分的最长回文子序列和去尾的部分的最长回文子序列的较长的那一个。
public class 最长回文子序列 {
	//动态规划法
    public static int longestPalindromeSubseq(String s) {
    	int n=s.length();
    	if(n<=1) {
    		return s.length();
    	}
    	
    	int[][] dp=new int[n][n];

    	for(int j=0;j<n;j++) {
    		dp[j][j]=1;//主对角线置1
    		for(int i=j-1;i>=0;i--) {
    			if(s.charAt(i)==s.charAt(j)) {
    				dp[i][j]=dp[i+1][j-1]+2;
    			}else {
    				dp[i][j]=Math.max(dp[i][j-1], dp[i+1][j]);
    			}
    		}
    	}
    	return dp[0][n-1];
    }

    public static int longestPalindromeSubseq2(String s) {
    	int n=s.length();
    	if(n<=1) {
    		return s.length();
    	}
    	
    	int[][] dp=new int[n][n];

    	for(int i=n-1;i>=0;i--) {
    		dp[i][i]=1; 
    		for(int j=i+1;j<n;j++) {
    			if(s.charAt(i)==s.charAt(j)) {
    				dp[i][j]=dp[i+1][j-1]+2;
    			}else {
    				dp[i][j]=Math.max(dp[i][j-1], dp[i+1][j]);
    			}
    		}
    	}
    	return dp[0][n-1];
    }

	public static void main(String[] args) {
		String string="abbada";
		System.out.println(longestPalindromeSubseq2(string));

	}

}
