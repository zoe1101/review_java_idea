package 排序算法;

import java.util.Scanner;

public class 归并排序 {
	public static void mergeSort(int[] arr) {
		if (arr==null || arr.length<2) {
			return;
		}
		mergeSort(arr,0,arr.length-1);

	}
    private static void mergeSort(int[] arr, int left, int right) {
		if (left<right) {
			int mid=(left+right)>>1;
		mergeSort(arr,left,mid); //左边归并排序
		mergeSort(arr,mid+1,right); //右边归并排序
		merge(arr, left, mid, right); //将左右合起来得到有序序列
		}
	}
    //合并两个有序序列为一个有序序列
	private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; //辅助数组
        int i = left;
        int j = mid+1;
        int index = 0;
        while(i<=mid && j<=right){ //两个序列都不为空的情况下
            if (arr[i] < arr[j]) {
                temp[index++] = arr[i++];
            } else {
                temp[index++] = arr[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[index++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[index++] = arr[j++];
        }
        //将temp中的元素全部拷贝到原数组中
        for (int k = 0; k < temp.length; k++) {
            arr[k + left] = temp[k]; //从left开始，left左边是排好了的
        }
    }
	
}
