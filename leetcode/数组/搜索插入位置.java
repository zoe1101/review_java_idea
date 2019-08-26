package 数组;
/*
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

输入: [1,3,5,6], 2
输出: 1
 */

public class 搜索插入位置 {
	
	public static int searchInsert(int[] nums, int target) {
		int i=0;  //被按顺序插入的位置
		for(int j=0;j<nums.length;j++) {
			if(nums[i]>=target) {//一旦当前元素不在小于目标值 就返回当前元素的下标
				break;
			}
			i++;
		}
		return i;
	}
	
	//二分法  超时!!!!
	public static int searchInsert1(int[] nums, int target) {
		if(nums.length==0) {
			return 0;
		}
		int low=0;
		int high=nums.length;
        while (low<high) {
        	int mid=(high-low)/2;
        	if(nums[mid]>target) {//在前半部分
        		high=mid;
        	}else if(nums[mid]<target) {//在后半部分
        		low=mid;
        	}else //中间值等于目标值
        		return mid;
		}
        return low;
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
