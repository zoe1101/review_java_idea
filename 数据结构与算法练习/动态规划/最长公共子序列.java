package 动态规划;

import java.util.Scanner;


/*
假设C=<z1,z2,...,zk>是X与Y的LCS(最长公共子序列)， 我们观察到
如果Xm=Yn，则Ck=Xm=Yn，有Ck−1是Xm−1与Yn−1的LCS；
如果Xm≠Yn，则Ck是Xm与Yn−1的LCS，或者是Xm−1与Yn的LCS。
*/
public class 最长公共子序列 {
	public static void main(String[] args) {
		Scanner inScanner=new Scanner(System.in);
	    String str1=inScanner.next();
	    String str2=inScanner.next();
	    inScanner.close();
	    System.out.println(LCS(str1,str2)); 
	}
		
	public static int LCS(String str1,String str2) {
		char[] s1=str1.toCharArray();  //字符串转换为字符数组
		char[] s2=str2.toCharArray();
		int str1len=s1.length; 
		int str2len=s2.length;
		int[][] c=new int[str1len+1][str1len+1];//此处的棋盘长度要比字符串长度多加1，需要多存储一行0和一列0
		
		for(int i=1;i<=str1len;i++) { //利用动态规划将数组赋满值
			for(int j=1;j<=str2len;j++) {
				if(s1[i-1]==s2[j-1]) {
					c[i][j]=c[i-1][j-1]+1;
				}
				else {
					c[i][j]=Math.max(c[i][j-1],c[i-1][j]);
				}
			}
				
		}
		return c[str1len][str2len];
		
	}

}
