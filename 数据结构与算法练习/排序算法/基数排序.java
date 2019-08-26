package 排序算法;

import java.util.ArrayList;
import java.util.Arrays;

public class 基数排序 {
	public static int[] radixSort(int[] arr) {
		if (arr == null || arr.length < 2)
			return arr;
		// 1.先算出最大数的位数；
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		int maxDigit = 0; //最大值的位数
		while (max != 0) {
			max /= 10;
			maxDigit++;
		}
		
		//10个桶,第i个桶里放当前位为i的数
		ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();                   
		for (int i = 0; i < 10; i++) {//i是位数，在每个位数上构造一个数组
			bucketList.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < maxDigit; i++) {
			for (int j = 0; j < arr.length; j++) {
				int num = arr[j] % (int)(Math.pow(10, i + 1)) / (int)(Math.pow(10, i)); //当前位的数字
				bucketList.get(num).add(arr[j]); //加入对应桶
			}
			//形成新的arr数组
			int index = 0;
			for (int j = 0; j < bucketList.size(); j++) { //桶遍历
				for (int k = 0; k < bucketList.get(j).size(); k++) { //桶内遍历
					arr[index++] = bucketList.get(j).get(k);
				}
				bucketList.get(j).clear();  //排序后就清空数组，便于后续排序存储
			}
		}
		return arr;
	}
	
	public static void main(String[] args)
	{
		int[] arrays = new int[] { 5, 3, 6, 2, 1, 19, 4, 8, 7 };
		System.out.println("未排序的数组：" + Arrays.toString(arrays));
		radixSort(arrays);
		System.out.println("排序后的数组：" + Arrays.toString(arrays));

	}

}
