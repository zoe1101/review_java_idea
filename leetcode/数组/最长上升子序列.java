package 数组;

import java.util.Arrays;

/*
给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4 
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。

 */
public class 最长上升子序列 {
    public int lengthOfLIS(int[] nums) {
    	 if (nums==null ||nums.length==0) {
 			return 0;
 		}
         if (nums.length==1) {
 			return 1;
 		}
         int[] dp = new int[nums.length];//dp[i]代表以第num[i]为结尾取得的最长长度
         Arrays.fill(dp, 1); //先把dp全部元素都初始化为1，因为dp[i]无论如何最少的长度都是1
         int res=1;
         for (int i = 1; i < nums.length; i++) { //以第num[i]为结尾
 			for (int j = 0; j < i; j++) {
 				// 看以前的，比它小的，说明可以接在后面形成一个更长的子序列
 				if (nums[j]<nums[i]) {
 					dp[i] = Math.max(dp[i],dp[j]+1);
 				}
 			}
 			res=Math.max(res, dp[i]);
 		}
         return res; 
    }
}
