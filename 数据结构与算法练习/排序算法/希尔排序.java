package 排序算法;

import java.util.Arrays;
import java.util.Scanner;

public class 希尔排序 {
//	  希尔排序
	public static int[] shellSort(int[] arr) {
		for(int gap=arr.length/2;gap>=1;gap/=2) { //遍历所有的步长
			//组内直接插入排序
			for (int i=gap;i<arr.length;i++) { //遍历所有组
				for(int j=i-gap;j>=0;j-=gap) { //遍历每组中所有的元素
					if(arr[j]>arr[j+gap]) {
						swap(arr,j,j+gap);
					}
				}

			}
			System.out.print(gap+": ");
			System.out.println(Arrays.toString(arr));
		}
		return arr;
	}
	
	private static void swap(int[] arr, int j, int i) {
		int temp=arr[j];
		arr[j]=arr[i];
		arr[i]=temp;
	}

	public static void main(String[] args) {
		Scanner stdinScanner=new Scanner(System.in);
		int[] arr=new int[] {3,2,5,1,7,2,6,4,0};
		System.out.println(Arrays.toString(arr));
		arr=shellSort(arr);
		System.out.println(Arrays.toString(arr));

	}
			
}
	
