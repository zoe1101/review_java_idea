package 二分查找;
/*
假设按照升序排序的数组在预先未知的某个点上进行了旋转。
( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
请找出其中最小的元素。
注意数组中可能存在重复的元素。

输入: [2,2,2,0,1]
输出: 0
 */
public class 寻找旋转排序数组中的最小值II {
public static int findMin(int[] nums) {
	int left=0,right=nums.length-1;
    if(nums[left]<nums[right] || nums.length == 1) { //转数组本身就是升序的
    	return nums[0];
    }
    while(left<right) {
    	int mid=(left+right)/2;
    	if(nums[mid]>nums[right]) {//最小数在右侧  5 2
    		left=mid+1;
    	}else if(nums[mid]<nums[right]) {// 2 5
    		right=mid;
    	}else { //考虑重复元素相等时 ,  2 2
			right--;
		}
    }
    return nums[left];
    }
	public static void main(String[] args) {
	    int[] arr = {4,5,6,7,0,0,1,1,2};
	    System.out.println(findMin(arr));
	}

}
