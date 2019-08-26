package 数组;

import java.util.HashSet;

/*
给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
假设只有一个重复的整数，找出这个重复的数。

示例 1:

输入: [1,3,4,2,2]
输出: 2

 */
public class 寻找重复数 {
    public int findDuplicate(int[] nums) {
    	HashSet<Integer> set=new HashSet<Integer>();
    	for (int num:nums) {
			if (set.contains(num)) {
				return num;
			}
			set.add(num);
		}
    	return nums[1];
    }
}
