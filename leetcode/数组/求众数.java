package 数组;
/*
给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在众数。

示例 1:
输入: [2,2,1,1,1,2,2]
输出: 2
 */
public class 求众数 {
    public int majorityElement(int[] nums) {
        int cand=0;
        int times=0;
        for (int i = 0; i < nums.length; i++) {
			if (times==0) {
				cand=nums[i];
				times=1;
			}else if (cand==nums[i]) {
				times++;
			}else {
				times--;
			}
		}
        times=0;
        for (int i = 0; i < nums.length; i++) {
			if (nums[i]==cand) {
				times++;
			}
		}
        if (times>nums.length/2) {
			return cand;
		}
        return -1;
    }
}
