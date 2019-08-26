package src;
/*
假设一个单调递增的数组里的每个元素都是整数并且是唯一的。
请编程实现一个函数找出数组中任意一个数值等于其下标的元素。
例如，在数组{-3, -1, 1, 3, 5}中，数字3和它的下标相等。
 */

//利用二分查找实现
public class 数组中数值和下标相等的元素 {
	private static int findValueEqualIndex(int[] nums) {
		if (nums==null || nums.length==0) {
			return -1;
		}
		int left=0;
		int right=nums.length-1;
		while (left<=right) {
			int mid=left+((right-left)>>1);
			if (nums[mid]==mid) {
				return mid;
			}else if (nums[mid]<mid) { //在右边
				left=mid+1;
			}else {  //在左边
				right=mid-1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] nums= {-3,-1,1,3,5};
		System.out.println(findValueEqualIndex(nums));
	}
}
