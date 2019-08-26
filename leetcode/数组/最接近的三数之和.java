package 数组;

import java.util.Arrays;

/*
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).

 */
public class 最接近的三数之和 {
	//先排序, 然后遍历, 然后内部使用双指针
    public int threeSumClosest(int[] nums, int target) {
    	// 排序
        Arrays.sort(nums);
        int closestNum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
        	int l = i + 1;
        	int r = nums.length - 1;
        	while (l < r){
        		int threeSum = nums[l] + nums[r] + nums[i];
        		if (Math.abs(threeSum - target) < Math.abs(closestNum - target)) {
                    closestNum = threeSum;
                }
        		if (threeSum > target) {
                    r--;
                } else if (threeSum < target) {
                    l++;
                } else {// 如果已经等于target的话, 肯定是最接近的
                    return target;
                }
        	}
        }
        return closestNum;
    }
}
