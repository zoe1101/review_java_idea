package 动态规划;

import java.util.Scanner;

/*
假设我们有8种不同面值的硬币｛1，2，5，10，20，50，100，200｝，用这些硬币组合够成一个给定的数值n。
例如n=200，例如n=200，那么一种可能的组合方式为 200 =2*100.
问总过有多少种可能的组合方式？保证n小于等于100000。
*/

public class 货币拼面值 {

	public static void main(String[] args) {
		Scanner inScanner=new Scanner(System.in);
		while(inScanner.hasNext()) {
			int n=inScanner.nextInt();
			System.out.println(coin_counts1(n));
			System.out.println(coin_counts2(n));
		}

	}

	//	简化为一维数组
	public static int coin_counts1(int n) {
		int[] coins = { 1, 5, 10, 20, 50, 100, 200 };
		int[] dp = new int[100001];
		dp[0] = 1;
		for (int i = 0; i < 7; ++i) {
			for (int j = coins[i]; j <= n; ++j) {
				dp[j] = dp[j] + dp[j - coins[i]];
			}
		}
		return dp[n];
	}

	// 动态规划原始求解
	public static int coin_counts2(int n){
		int[] coins = { 1, 5, 10, 20, 50, 100, 200 };
		int[][] d = new int[coins.length+1][n+1];//length+1表示不适用任何币种、只使用1、只使用1 2 只使用1 2 3......等等，共length+1种情况，且n+1表示总计0、1.....至n元共n+1种情况
		for(int i = 0;i<=coins.length;i++) d[i][0] = 1;
		for(int i = 1 ;i<=coins.length;i++){//因为d[0][i]是0，所以i从1开始
			for(int sum = 1;sum<=n;sum++){//由于d[i][0]==1，所以j从1开始
				for(int k=0;k<=sum/coins[i-1];k++){//例如，使用面值为1时，对应的coins[]下标是i-1，逻辑上河实际上不是一致的
					d[i][sum] +=d[i-1][sum-k*coins[i-1]];
				}
			}
		}
		return d[coins.length][n];
	}

}