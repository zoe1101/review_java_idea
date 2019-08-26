package 数组与矩阵问题;

import java.util.Arrays;
import java.util.HashSet;

//可整合数组:一个数组排序后，相邻元素的差的绝对值为1,即递增排序后应该是依次递增1的
//方法1
public class 最长的可整合子数组的长度 {
	public static int getLIL1(int[] arr) {
		if (arr==null ||arr.length==0) {
			return 0;
		}
		int len=0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if (isIntegrated(arr, i, j)) {
					len=Math.max(len, j-i+1);
				}
			}
		}
		return len;
		
	}
	//判断arr[i:j]是否是可整合数组
	public static boolean isIntegrated(int[] arr,int left,int right) {
		int[] newArr=Arrays.copyOfRange(arr, left, right+1);//从原数组中复制一份
		Arrays.sort(newArr); //排序
		for (int i = 1; i < newArr.length; i++) {
			if (newArr[i]-newArr[i-1]!=1) {
				return false;
			}
		}
		return true;
	}
	
	//方法2：
	public static int getLIL2(int[] arr) {
		if (arr==null || arr.length==0) {
			return 0;
		}
		int len=0; //可整合数组的长度
		int max=0; //数组中最大的数
		int min=0; //数组中最小的数
		HashSet<Integer> set=new HashSet<Integer>(); //判断是否有重复元素
		for (int i = 0; i < arr.length; i++) {
			max=Integer.MIN_VALUE;
			max=Integer.MAX_VALUE;
			for (int j = i; j < arr.length; j++) { //对arr[i:j]进行判断
				if (set.contains(arr[j])) { //出现重复元素，调出循环
					break;
				}
				set.add(arr[j]);
				max=Math.max(max, arr[j]);
				min=Math.min(min, arr[j]);
				if (max-min==j-i) { //如果arr[i:j]是目前可整合数组，进行最大长度判断更新
					//只要最大值减去最小值加1等于区间数组的长度就满足要求
					len=Math.max(len, j-i+1);
				}
			}
			set.clear();
		}
		return len;
	}
	

}
