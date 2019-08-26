package 排序算法;

import java.util.Arrays;
import java.util.Scanner;

public class 直接插入排序 {
	public static void insertSort(int[] arr) {
		if (arr==null || arr.length<2) {
			return;
		}
//从第2个元素开始比较，因为第一个元素左边没有元素，不需要与左边的元素进行比较插入
		for(int i=1;i<arr.length;i++) { //遍历所有元素
			for (int j=i;j>0;j--) { //为arr[i]在前面的arr[0...i-1]有序区间中找一个合适的位置
				if(arr[j]<arr[j-1]) { //如果arr[j]小于前一个数，进行插入调换,将arr[j]和arr[j-1]交换
					swap(arr,j,j-1);
				}
			}
		}
	}		
	private static void swap(int[] arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		
	}
	
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}
	
	public static int[] generateRandomArray(int maxSize,int maxValue) {
		int[] arr=new int[(int)((maxSize+1)*Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=(int)((int)((maxValue+1)*Math.random())-(int)((maxValue+1)*Math.random()));
		}
		return arr;
	}
	
	public static int[] copyArray(int[] arr) {
		if (arr==null) {
			return null;
		}
		int[] res=new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i]=arr[i];
		}
		return res;
	}
	
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
	private static void printArray(int[] arr) {
		if (arr==null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int testTime=500;
		int maxSize=100;
		int maxValue=100;
		boolean succeed=true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1=generateRandomArray(maxSize, maxValue);
			int[] arr2=copyArray(arr1);
			insertSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed=false;
				break;
			}
		}
		System.out.println(succeed?"算法正确!":"算法有错!");
		int[] arr=generateRandomArray(maxSize, maxValue);
		printArray(arr);
		insertSort(arr);
		printArray(arr);

	}

	

}

