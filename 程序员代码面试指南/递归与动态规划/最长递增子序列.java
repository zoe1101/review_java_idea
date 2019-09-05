package 递归与动态规划;

import java.util.Arrays;


public class 最长递增子序列 {
	public static int[] getdp1(int[] arr) {
		int[] dp=new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			dp[i]=1;
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i]) {
					dp[i]=Math.max(dp[i], dp[j]+1);
				}
			}
		}
		return dp;
	}
	
	public static int[] generateLIS(int[] arr, int[] dp) {
		int len=0;
		int index=0;
		for(int i=0;i<dp.length;i++) {
			if(dp[i]>len) {
				len=dp[i];
				index=i;
			}
		}
		int[] lis=new int[len];
		lis[--len]=arr[index];
		for(int i=index;i>=0;i--) {
			if(arr[i]<arr[index] && dp[i]==dp[index]-1) {
				lis[--len]=arr[i];
				index=i;
			}
		}
		return lis;
	}
	
	public static int[]  lis1(int[] arr) {
		if(arr==null || arr.length==0) {
			return null;
		}
		int[] dp=getdp1(arr);
		return generateLIS(arr, dp);
	}
	
	 //还未思考
	
	public static int[] lis2(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		int[] dp = getdp2(arr);
		return generateLIS(arr, dp);
	}

	public static int[] getdp2(int[] arr) {
		int[] dp = new int[arr.length];
		int[] ends = new int[arr.length];
		ends[0] = arr[0];
		dp[0] = 1;
		int right = 0;
		int l = 0;
		int r = 0;
		int m = 0;
		for (int i = 1; i < arr.length; i++) {
			l = 0;
			r = right;
			while (l <= r) {
				m = (l + r) / 2;
				if (arr[i] > ends[m]) {
					l = m + 1;
				} else {
					r = m - 1;
				}
			}
			right = Math.max(right, l);
			ends[l] = arr[i];
			dp[i] = l + 1;
		}
		return dp;
	}

	public static void main(String[] args) {
		int[] arr= {2,1,5,3,6,4,8,9,7};
		System.out.println(Arrays.toString(lis1(arr)));
		System.out.println(Arrays.toString(lis2(arr)));
	}

}
