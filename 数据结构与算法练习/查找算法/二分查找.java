package 查找算法;

public class 二分查找 {
//	基本的二分查找，非递归
	public static int bisearch1(int[] arr,int target) {
		int left=0;
		int right=arr.length-1;
		while(left<=right) {
			int mid=left+(right-left)/2;  //为了防止数值溢出
			if(target==arr[mid]) {
				return mid;
			}else if(target<arr[mid]) { //在mid的左边
				right=mid-1;
			}else {
				left=mid+1;
			}
		}
		return -1;
	}
//	基本的二分查找，递归
	public static int bisearch2(int[] arr,int left,int right,int target) {

		while(left<=right) {
			int mid=left+(right-left)/2;  //为了防止数值溢出
			if(target==arr[mid]) {
				return mid;
			}else if(target<arr[mid]) { //在mid的左边
				return bisearch2(arr, left, mid-1, target);
			}else {
				return bisearch2(arr, mid+1, right, target);
			}
		}
		return -1;
	}
	
/*
查找目标值区域的左边界/     查找与目标值相等的第一个位置/    查找第一个不小于目标值数的位置
 */
	public static int binarySearchLowerBound(int[] arr, int target){
		int left=0;
		int right=arr.length-1;
		while(left<=right) {
			int mid=left+(right-left)/2;  //为了防止数值溢出
			if(target<=arr[mid]) { //在mid的左边
				right=mid-1;
			}else {
				left=mid+1;
			}
		}
		if(left<arr.length && arr[left]==target) {
			return left;
		}
		return -1;
	}

	
/*
查找目标值区域的右边界/        查找与目标值相等的最后一个位置/           查找最后一个不大于目标值数的位置
 */
	public static int binarySearchUpperBound(int[] arr, int target){
		int left=0;
		int right=arr.length-1;
		while(left<=right) {
			int mid=left+(right-left)/2;  //为了防止数值溢出
			if(target>=arr[mid]) { //在mid的右边
				left=mid+1;
			}else {
				right=mid-1;
			}
		}
		if(right>0 && arr[right]==target) {
			return right;
		}
		return -1;
	}
	
	/*
	 查找最后一个小于目标值的数/查找比目标值小但是最接近目标值的数

	 */
	public static int binarySearchLastLow(int[] arr, int target){
		int left=0;
		int right=arr.length-1;
		while(left<=right) {
			int mid=left+(right-left)/2;  //为了防止数值溢出
			if(target<=arr[mid]) { //在mid的左边
				right=mid-1;
			}else {
				left=mid+1;
			}
		}
		if(right>=0) {
			return right;
		}
		return -1;
	}

	/*
	 查找第一个大于目标值的数   /   查找比目标值大但是最接近目标值的数

	 */
	public static int binarySearchLastHigh(int[] arr, int target){
		int left=0;
		int right=arr.length-1;
		while(left<=right) {
			int mid=left+(right-left)/2;  //为了防止数值溢出
			if(target<=arr[mid]) { //在mid的左边
				right=mid-1;
			}else {
				left=mid+1;
			}
		}
		if(left<=arr.length) {
			return left;
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		int[] arr= {1,3,3,5,7,7,7,7,8,14,14};
		int target=7;
		System.out.println(bisearch1(arr, target));
		System.out.println(bisearch2(arr, 0, arr.length-1, target));
		
		System.out.println(binarySearchLowerBound(arr, target));
		System.out.println(binarySearchUpperBound(arr, target));
	}

}
