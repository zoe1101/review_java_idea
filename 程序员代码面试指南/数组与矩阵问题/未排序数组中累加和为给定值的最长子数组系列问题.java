package 数组与矩阵问题;

import java.util.HashMap;

public class 未排序数组中累加和为给定值的最长子数组系列问题 {
	//1：数组中包含正数，负数或0，要求累加和为k
	//利用sum-(sum-k)=k实现
	public static int maxLength1(int[] arr,int k) {
		if (arr==null ||arr.length==0) {
			return 0;
		}
		//记录key为sum第一次出现的位置j
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		map.put(0, -1); //和为0第一次出现在-1的位置
		int len=0;
		int sum=0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
			if (map.containsKey(sum-k)) {//利用sum-(sum-k)=k实现
				len=Math.max(len, i-map.get(sum-k));
			}
			if (!map.containsKey(sum)) { //如果map的key中不存在sum元素
				map.put(sum, i);
			}
		}
		return len;
	}
	
	//2：数组中包含正数，负数或0，要求子数组中正数和负数的个数相等
	public static int maxlength2(int[] arr) {
		if (arr==null || arr.length==0) {
			return 0;
		}
		//正数用1替换，负数用-1替换，然后求和为0的最长子数组长度
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]>0) {
				arr[i]=1;
			}
			if (arr[i]<0) {
				arr[i]=-1;
			}
		}
		return maxLength1(arr, 0);
	}
	//在只有0和1的数组中，找到0和1个数相等的最长子数组长度
	public static int maxlength3(int[] arr) {
		if (arr==null || arr.length==0) {
			return 0;
		}
		//0用-1替换，然后求和为0的最长子数组长度
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]==0) {
				arr[i]=-1;
			}
		}
		return maxLength1(arr, 0);
		
	}
	public static int[] generateArray(int size) {
		int[] result = new int[size];
		for (int i = 0; i != size; i++) {
			result[i] = (int) (Math.random() * 11) - 5;
		}
		return result;
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = generateArray(20);
		printArray(arr);
		System.out.println(maxLength1(arr, 10));
		System.out.println(maxlength2(arr));
		System.out.println(maxlength3(arr));

	}

}
