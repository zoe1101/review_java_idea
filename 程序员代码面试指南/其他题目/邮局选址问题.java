package 其他题目;

import java.util.Arrays;

public class 邮局选址问题 {
	public static int minDistances(int[] arr,int num) {
		if (arr==null||num<1 || arr.length<num) {
			return 0;
		}
		int[][] w=new int[arr.length+1][arr.length+1];
		//w[i][j]代表在arr[i:j]区域上建一个邮局的总距离（每个点到邮局的距离和）
		
		int[][] dp=new int[num][arr.length]; 
		//dp[i][j]:在arr[0:j]上建i+1个邮局的最少总距离
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				w[i][j]=w[i][j-1]+arr[j]-arr[(i+j)/2];
			}
		}

		for (int j = 0; j != arr.length; j++) {
			dp[0][j] = w[0][j];
		}
		for (int i = 1; i < num; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = 0; k <= j; k++) {
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + w[k + 1][j]);
				}
			}
		}
		for (int[] d:dp) {
			System.out.println(Arrays.toString(d));
		}
		
		return dp[num-1][arr.length-1];
	}
public static void main(String[] args) {
	int[] arr= {1,2,3,4,5,1000};
	System.out.println(minDistances(arr, 2));
}

}
