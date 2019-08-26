package 数组;

import java.util.Arrays;

/*
给定一个未排序的整数数组，找到最长递增子序列的个数。

示例 1:

输入: [1,3,5,4,7]
输出: 2
解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
示例 2:

输入: [2,2,2,2,2]
输出: 5
解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。

 */
public class 最长递增子序列的个数 {
    public int findNumberOfLIS(int[] nums) {
        if (nums==null || nums.length==0) {
			return 0;
		} 
        int[] dp=new int[nums.length]; // 记录以第i个元素结尾的LIS
        int[] combination = new int[nums.length];//记录以第i个元素结尾LIS的种类
        Arrays.fill(dp, 1);
        Arrays.fill(combination, 1);
        int max=1;
        int res=0;
        for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j <i; j++) {
				if (nums[i]>nums[j]) {//如果j位的数值比i位小，则可加入i位的LIS比较队列
					if (dp[j]+1 > dp[i]) {//如果+1长于当前LIS 则组合数不变
						dp[i]=dp[j]+1;
						combination[i]=combination[j];
					}else if (dp[j]+1 == dp[i]) {//如果+1等于当前LIS 则说明找到了新组合
						combination[i] += combination[j];
					}
				}
			}
			max = Math.max(max, dp[i]);
		}
        for (int i = 0; i < nums.length; i++)
            if (dp[i] == max) res += combination[i];

        return res;
    }
    
}
