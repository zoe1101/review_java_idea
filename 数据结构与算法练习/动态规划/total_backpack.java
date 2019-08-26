package 动态规划;

import java.util.Scanner;

//完全背包
/*
有N种物品和一个容量为V的背包，每种物品都有无限件可用。
第i种物品的重量是w[i]，价值是v[i]。
求解将哪些物品装入背包可使这些物品的重量总和不超过背包容量，且价值总和最大。
*/
public class total_backpack {

	public static void main(String[] args) {
		Scanner inScanner=new Scanner(System.in);
		int n=inScanner.nextInt();
		int[] w=new int[n];
		int[] v=new int[n];
		for (int i=0;i<n;i++) {
			w[i] = inScanner.nextInt();
		}
		for (int i=0;i<n;i++) {
			v[i] = inScanner.nextInt();
		}
		int C=inScanner.nextInt();
		findMAX1(w, v, C);
		findMAX2(w, v, C);
		
	}
	public static int[] findMAX1(int[] w,int[] v,int C) {
		int[] dp=new int[C+1];
		
		for(int i=1;i<=w.length;i++) {
			for(int j=1;j<=C;j++) {
				int m = j / w[i-1];	//如果能放下，要看看能放几个
				for(int k=0;k<=m;k++ ) {
					//然后放几个跟不放所有情况比一下看哪个价值最大
					if(dp[j-k*w[i-1]]+k*v[i-1]>dp[j]) {
						dp[j]=dp[j-k*w[i-1]]+k*v[i-1];
					}
				}
			}
		}
		System.out.println("输出dp数组");
		for(int j=0;j<dp.length;j++) {
				System.out.print(dp[j]+" ");}
		System.out.println();
		System.out.println("最大价值为："+dp[dp.length-1]);
		return dp;
	}
	public static int[][] findMAX2(int[] w,int[] v,int C) {
		int[][] dp=new int[w.length+1][C+1];
		
		for(int i=1;i<=w.length;i++) {
			for(int j=1;j<=C;j++) {
				int m = j / w[i-1];	//如果能放下，要看看能放几个
				for(int k=0;k<=m;k++ ) {
					//然后放几个跟不放所有情况比一下看哪个价值最大
					if(dp[i-1][j-k*w[i-1]]+k*v[i-1]>dp[i][j]) {
						dp[i][j]=dp[i-1][j-k*w[i-1]]+k*v[i-1];
					}
				}
			}
		}
		System.out.println("输出dp数组");
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("最大价值为："+dp[dp.length-1][dp[0].length-1]);
		return dp;
	}

}
