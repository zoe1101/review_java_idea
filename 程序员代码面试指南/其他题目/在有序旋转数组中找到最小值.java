package 其他题目;
//二分查找
public class 在有序旋转数组中找到最小值 {
	public static int getMin(int[] arr) {
		int low=0;
		int high=arr.length-1;
		while (low<high) {
			if (low==high-1) {
				break;
			}
			if (arr[low]<arr[high]) { //表明arr[low:high]范围是有序的，最小值就是arr[low]
				return arr[low];
			}
			int mid=(high+low)/2;
			if (arr[low]>arr[mid]) { //最小值在arr[low:mid]范围内
				high=mid;
				continue;
			}
			if (arr[mid]>arr[high]) { //最小值在arr[mid:high]范围内
				low=mid;
				continue;
			}
			//当arr[low]=arr[mid]=arr[high]时
			while (low<mid) {
				if (arr[low]==arr[mid]) {
					low++;
				}else if (arr[low]<arr[mid]) {
					return arr[low];
				}else {
					high=mid;
					break;
				}
			}
		}
		return Math.min(arr[low], arr[high]);
	}

}
