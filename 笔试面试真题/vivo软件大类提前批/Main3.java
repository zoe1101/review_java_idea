package vivo软件大类提前批;

import java.util.Arrays;

//有n种礼品，每个礼品对应一个热度值，总金额为k，
//每个礼品只能买一次，如何购买可以使得所有礼品的总热度值最高。

//01背包问题
public class Main3 {
	public static int Solution(int k,int[] cost,int[] hot) {
		if (k<0 || cost.length!=hot.length) {
			return 0;
		}
		int len=cost.length;
		int[][] dp=new int[len+1][k+1]; 
		//dp[i][j]:在花销金额为j的情况下，前i件物品最佳组合的总热度值
		for (int i = 1; i <=len; i++) {
			for (int j = 1; j <=k; j++) {
				if (j<cost[i-1]) { //金额不够买礼品i
					dp[i][j]=dp[i-1][j];
				}else {//决定拿不拿第i件礼品：dp[i-1][j]为不拿
					dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-cost[i-1]]+hot[i-1]);
				}
			}
		}
		System.out.println("动态规划表：");
		for (int[] e:dp) {
			System.out.println(Arrays.toString(e));
		}
		System.out.print("总热度值最大值：");
		return dp[len][k];
		
	}
	public static void main(String[] args) {
		int[] cost = { 2 , 3 , 4 , 5 };			
		int[] hot= {3 , 4 , 5 , 6 };	
		int k = 8;
		System.out.println(Solution(k, cost, hot));
	}

}
