package 数组;
/*
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
你的算法时间复杂度必须是 O(log n) 级别。
如果数组中不存在目标值，返回 [-1, -1]。

示例 1:
输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]

示例 2:
输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
    	if (nums==null || nums.length==0 || target<nums[0]) {
			return new int[]{-1,-1};
		}
    	int left=0;
    	int right=nums.length-1;
    	int flag = Integer.MIN_VALUE;
    	while (left<=right) {
			int mid=(left+right)>>1;
	    	if (nums[mid]>target) { //在左边
				right=mid-1;
			}else if (nums[mid]<target) {//在右边
				left=mid+1;
			}else {
				flag=mid;
				break;
			}
		}
    	if (flag==Integer.MIN_VALUE) {//flag没有刷新，证明不存在target
    		return new int[]{-1,-1};
		}
    	int i=flag;
    	int j=flag;
    	for (; i>=0; i--) {
			if (nums[i]!=target) {
				break;
			}
		}
    	for (; j<nums.length; j++) {
			if (nums[j]!=target) {
				break;
			}
		}
    	return new int[] {i+1,j-1};
        
    }
}
