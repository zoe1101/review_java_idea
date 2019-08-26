package 数组;

import javax.xml.crypto.Data;

/*
给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。

输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
 */
//乘积子序列中有正也有负或者0，虽然只要求一个最大积，但由于负数的存在，不但纪录最大乘积，也要记录最小乘积。
//解题思想：动态规划
public class 乘积最大子序列 {
	public static int maxProduct(int[] nums) {
		if(nums.length==0||nums==null) {
			return 0;
		}
		int max;
		int[] maxend=new int[nums.length] ; //纪录最大乘积
		int[] minend=new int[nums.length] ; //记录最小乘积
		maxend[0]=nums[0];
		minend[0]=nums[0];
        for(int i=1;i<nums.length;i++) {
        	maxend[i]=Math.max(Math.max(maxend[i-1]*nums[i],minend[i-1]*nums[i]),nums[i]);
        	minend[i]=Math.min(Math.min(maxend[i-1]*nums[i],minend[i-1]*nums[i]),nums[i]);
        }
        max=maxend[0];
        for(int i=0;i<nums.length;i++){
        	if(maxend[i]>max) {
        		max=maxend[i];
        	}
        }
        return max;
    }
	public static void main(String[] args) {
		int[] nums= {2,3,-2,4};
		System.out.println(maxProduct(nums));

	}

}
