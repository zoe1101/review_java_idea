package 数组;

import java.util.HashSet;

/*
给定一个整数数组，判断是否存在重复元素。
如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。


输入: [1,2,3,1]
输出: true

 */
public class 存在重复元素 {
    public boolean containsDuplicate(int[] nums) {
        if (nums==null || nums.length<2) {
			return false;
		}
        HashSet<Integer> set =new HashSet<Integer>();
        for (int num:nums) {
			if (set.contains(num)) {
				return true;
			}else {
				set.add(num);
			}
		}
        return false;
    }
}
