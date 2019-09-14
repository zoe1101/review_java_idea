package 查找算法;

/*
假设按照升序排序的数组在预先未知的某个点上进行了旋转。
( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
你可以假设数组中不存在重复的元素。
你的算法时间复杂度必须是 O(log n) 级别。

输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
 */
public class 搜索旋转排序数组 {
    public static int search(int[] nums, int target) {
    	int left=0,right=nums.length-1;
    	while(left<=right) {
    		int mid=left+(right-left)/2;
    		if(nums[mid]==target) {
    			return mid;
    		}
    		// 1 3 5
    		if(nums[mid]>=nums[left]){ //左侧有序
    			if(target<nums[mid] && target>=nums[left]) { //目标值在左侧
    				right=mid-1;
    			}else {//目标值在右侧
    				left=mid+1;
    			}
    		}else {//右侧有序     //5 1 3
    			if(target>nums[mid] &&target<=nums[right]) {////目标值在右侧
    				left=mid+1;
    			}else {
    				right=mid-1;
    			}
    		}
    	}
    	return -1; 
    }

	public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(search(arr, 0));

	}

}
