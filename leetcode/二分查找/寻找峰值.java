package 二分查找;

/*
峰值元素是指其值大于左右相邻值的元素。
给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
你可以假设 nums[-1] = nums[n] = -∞。

输入: nums = [1,2,3,1]
输出: 2
解释: 3 是峰值元素，你的函数应该返回其索引 2。
 */
public class 寻找峰值 {
    public static int findPeakElement(int[] nums) {
        int left=0,right=nums.length-1;
        while(left<right) {
        	int mid=(left+right)/2;
        	if(nums[mid]<nums[mid+1]) { //mid右侧存在峰值
        		left=mid+1;
        	}else {
        		right=mid;
        	}
        }
        return right;
    }
	public static void main(String[] args) {
	    int[] arr = {1,2,3,1};
	    System.out.println(findPeakElement(arr));

	}

}
