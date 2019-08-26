package 数组;

import java.util.Arrays;

/*
给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。

输入: [1,2,3,4]
输出: 24
 */
//解题思路：先从小到大排序，最大乘积在nums[0]*nums[1]*nums[n-1]与nums[n-3]*nums[n-2]*nums[n-1]中取较大者。
public class 三个数的最大乘积 {
	public static int maximumProduct(int[] nums) {
		int n=nums.length;
        if(n<3) {
        	return 0;
        }
        if(n==3) {
        	return nums[0]*nums[1]*nums[2];
        }
        Arrays.sort(nums);
        return (Math.max(nums[0]*nums[1]*nums[n-1],nums[n-3]*nums[n-2]*nums[n-1]));
    }
	public static void main(String[] args) {
		int[] nums= {1,2,3,4};
		System.out.println(maximumProduct(nums));

	}

}
