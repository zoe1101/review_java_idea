package 数组;

import java.util.HashMap;

/*
给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，
并且 i 和 j 之间的差的绝对值最大为 ķ。

输入: nums = [1,2,3,1], k = 3, t = 0
输出: true

 */
public class 存在重复元素III {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <= i+k && j<nums.length; j++) {
				if (Math.abs(nums[i]-nums[j])<=t) {
					return true;
				}
			}
		}
        return false;    
    }
}
