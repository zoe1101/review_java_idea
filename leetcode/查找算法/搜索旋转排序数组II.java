package 查找算法;

/*
假设按照升序排序的数组在预先未知的某个点上进行了旋转。
( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。


输入: nums = [2,5,6,0,0,1,2], target = 0
输出: true
 */
public class 搜索旋转排序数组II {
    public static boolean search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right) {
        	int mid=left+(right-left)/2;
        	if(nums[mid]==target) {
        		return true;
        	} 
        	 //3 3 3
        	if(nums[mid]==nums[left] && nums[mid]==nums[right]) {
        		++left;
        		--right;
        	}
        	//3 5 1   左侧有序
        	else if(nums[mid]>=nums[left]){ 
        		if(target<nums[mid] & target>=nums[left]) {//目标值在左侧
        			right=mid-1;
        		}else {
        			left=mid+1;
        		}
        	}
        	// 5 1 3 右侧有序  
        	else{
        		if(target>nums[mid] && target<=nums[right]) {
        			left=mid+1; 
        		}
        		else { //目标值在左侧
        			right=mid-1;
        		}
        	}
    	}
        return false;
    }
    
	public static void main(String[] args) {
        int[] arr = {2,5,6,0,0,1,2};
        System.out.println(search(arr, 7));

	}
}
