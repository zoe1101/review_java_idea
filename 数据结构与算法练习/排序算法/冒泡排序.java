package 排序算法;

import java.util.Arrays;

//N个数字要排序完成，总共进行N-1趟排序，每i趟的排序次数为(N-i)次，所以可以用双重循环语句，
//外层控制循环多少趟，内层控制每一趟的循环次数。
public class 冒泡排序 {
	public static void bubbleSort(int[] arr) {
		if (arr==null || arr.length<2) {
			return ;
		}
		for (int i = 0; i < arr.length-1; i++) { //需要进行N-1趟
			for (int j = 0; j < arr.length-1-i; j++) {
				if (arr[j]>arr[j+1]) {
					swap(arr,j,j+1);
				}
			}
		}
	}

	private static void swap(int[] arr, int j, int i) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		
	}
	//对比器，用于检验算法是否正确
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}
	//生成随机数组
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		//(int)((maxSize + 1) * Math.random())： [0,maxSize]中随机生成一个值作为数组长度
		int[] arr=new int[(int)((maxSize + 1) * Math.random())]; 
		for (int i = 0; i < arr.length; i++) {
			//随机生成属于[-maxValue,maxValue]的值
			arr[i]=(int) ((maxValue+1)*Math.random())-(int)((maxValue+1)*Math.random());
		}
		return arr;
	}
	
	//数组拷贝
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
		if ((arr1==null && arr2!=null) || (arr1!=null &&arr2==null)) {
			return false;
		}
		if (arr1==null && arr2==null) {
			return true;
		}
		if (arr1.length!=arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i]!=arr2[i]) {
				return false;
			}
		}
		return true;
	}

	// 打印数组元素
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int testTime = 500000; //测试次数
		int maxSize = 100; //数组最大长度
		int maxValue = 100; //元素最大值
		boolean succeed = true;  //标志结果是否正确
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			bubbleSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed?"算法正确!":"算法有错!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		bubbleSort(arr);
		printArray(arr);
	}
	


}
