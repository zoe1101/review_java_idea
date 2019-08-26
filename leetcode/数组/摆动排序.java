package 数组;

import java.util.Arrays;

/*
给你一个没有排序的数组，请将原数组就地重新排列满足如下性质 
nums[0] <= nums[1] >= nums[2] <= nums[3]….

样例
给出数组为 nums = [3, 5, 2, 1, 6, 4] 一种输出方案为 [1, 6, 2, 5, 3, 4]

 */
public class 摆动排序 {
	/*
	 * 先从小到大排序，在进行元素交叉，
	 * 即每次把第三个数和第二个数调换个位置，第五个数和第四个数调换个位置，以此类推直至数组末尾
	 */
	public void wiggleSort(int[] nums) {
		Arrays.sort(nums);
		if (nums.length<2) {
			return ;
		}
		for (int i = 2; i < nums.length; i+=2) {
			swap(nums,i-1,i);
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
}
