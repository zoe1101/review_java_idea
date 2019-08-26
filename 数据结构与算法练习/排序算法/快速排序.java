package 排序算法;

import java.util.Arrays;

// 指针交换法
public class 快速排序 {
	public static void quickSort(int[] arr) {
		if (arr==null || arr.length<2) {
			return ;
		}
		quickSort2(arr, 0, arr.length-1);
	}
	
	//选择最左边的元素为基准元素
	public static void quickSort2(int[] arr,int start,int end){
        if(start<end) {
			int left=start; //左指针
			int right=end; //右指针
			int standard=arr[left]; //基准元素
			while (left<right) {
				while (standard<=arr[right] && left<right) {//先看右边，依次往左递减
					right--;
				}
				while (standard>=arr[left] && left<right) {//再看左边，依次往右递增
					left++;
				}
				if (left<right) {//如果满足条件则交换
					swap(arr, left, right);
				}
			}
//			printArray(arr);
			//最后将基准元素与arr[left]交换 (此时left=right)
	         arr[start] = arr[left];
	         arr[left] = standard;
			quickSort2(arr, start, right-1);
			quickSort2(arr, right+1, end);
		}
    }
	
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
  
}
