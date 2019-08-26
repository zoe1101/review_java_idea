package 二分查找;

import java.util.Arrays;

/*
给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。

示例 1:

输入: [3,0,1]
输出: 2
示例 2:

输入: [9,6,4,2,3,5,7,0,1]
输出: 8

你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?

 
 */
public class 缺失数字 {
	public static int missingNumber(int[] nums) { 
		if (nums==null || nums.length==0) {
			return -1;
		}
		int res = nums.length;
		//利用1^1^2^2^3=3实现，没出现的那个数字会被留下来
        for (int i = 0; i < nums.length; ++i){
            res ^= nums[i];
            res ^= i;
        }
        return res;
	}
	public static void main(String[] args) {
		int[] arr= {0,1,2,3,4,5,6,8,9,10};
		System.out.println(missingNumber(arr));
	}
}
