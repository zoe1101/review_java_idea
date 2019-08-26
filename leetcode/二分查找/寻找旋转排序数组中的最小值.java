package 二分查找;
/*
假设按照升序排序的数组在预先未知的某个点上进行了旋转。
( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
请找出其中最小的元素。
你可以假设数组中不存在重复元素。

输入: [3,4,5,1,2]
输出: 1
 */
public class 寻找旋转排序数组中的最小值 {
    public static int findMin(int[] nums) {
        int left=0,right=nums.length-1;
        if(nums[left]<nums[right] || nums.length == 1) { //转数组本身就是升序的
        	return nums[0];
        }
        while (left<right) {
        	int mid=left+(right-left)/2;
        	if(nums[mid]>nums[right]) { //最小值在右侧  4 7 3
        		left=mid+1;
        	}else {
        		right=mid;//这样做是为了避免忽略了nums[mid]这个元素
        	}
		}
        return nums[left];
    }
    
	public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(findMin(arr));

	}
}
