package 字符串;

import javax.naming.InitialContext;

/*
给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。

输入: "aaa"
输出: 6
说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 */
public class 回文子串 {
    public static int countSubstrings(String s) {
    	int n=s.length();
        boolean[][] dp=new boolean[n][n];
        int count=0;//统计回文子串数
        for(int i=0;i<n;i++) {  // 单个字符均为回文
        	dp[i][i]=true;
        }
        // two character
        // 斜着遍历 [0,1] -> [1,2] -> ...
        for(int i=0;i<n-1;i++) { // 两个字符均相同才是回文
        	if(s.charAt(i)==s.charAt(i+1)) {
        	dp[i][i+1]=true;
        	}
        }
        // others
        // 开始dp,  此子串 = 字符 + 左下角的子串 + 字符
        // 只有左下角是回文,同时两端添加的字符相同时,才是回文
        for(int i=2;i<n;i++) {
        	for(int j=0;j<n-i;j++) {
        		if(s.charAt(j)==s.charAt(j+i) && dp[j+1][j+i-1]==true) {
        			dp[j][j+i]=true;
        		}
        	}
        }
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		if(dp[i][j]==true) {
        			count++;
        		}
        	}
        }
        return count;
    }

	public static void main(String[] args) {
		String string="abbada";
		System.out.println(countSubstrings(string));

	}

}
