package 递归与动态规划;

import java.util.HashMap;

//数组最优分割
public class 子数组异或和为0的最多划分 {
	public static int mostEOR(int[] arr) {
		if (arr==null || arr.length==0) {
			return 0;
		}
		int eor=0;
		int[] dp=new int[arr.length];
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();//异或和key上次对应的位置
		map.put(0, -1); 
		dp[0]=arr[0]==0?1:0;
		map.put(arr[0], 0);
		for (int i = 1; i < arr.length; i++) {
			eor^=arr[i];
			if (map.containsKey(eor)) {
				int preEORindex=map.get(eor);
				dp[i]=preEORindex==-1?1:(dp[preEORindex]+1);
			}
			dp[i]=Math.max(dp[i-1], dp[i]);
			map.put(eor,dp[i]);
		}
		return dp[arr.length-1];
	}

}
