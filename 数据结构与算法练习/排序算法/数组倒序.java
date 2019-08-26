package 排序算法;

import java.util.Scanner;

public class 数组倒序 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
	Scanner stdinScanner=new Scanner(System.in);
			
			int n=stdinScanner.nextInt();
			
			int[] arr=new int[n];
			//数组的输入
			for(int i=0;i<arr.length;i++) { 
				arr[i]=stdinScanner.nextInt();
			}
			
			printArray(arr);
			
			for(int ele:arr) {
				System.out.print(ele+" ");
			}
			
			System.out.println("\n");
			arr = 数组倒序.reverse(arr);
			
			printArray(arr);
			
	
	}
	
	// 打印所有数组元素
	public static void printArray(int[] arr) {
		for(int ele:arr) {
			System.out.print(ele+" ");
		}
	}
	 public static int[] reverse(int[] arr){
	        int[] result = new int[arr.length];
	        for (int i = 0,j=result.length-1; i < arr.length; i++,j--) {
	            result[j] = arr[i];
	        }
	        return result;
	    }

}
