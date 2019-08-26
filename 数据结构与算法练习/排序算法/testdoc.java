package 排序算法;

import java.util.ArrayList;

public class testdoc {
	public static void radixSort(int[] arr) {
		if (arr==null || arr.length<2) {
			return;
		}
		
		int max=arr[0];
		for (int i = 1; i < arr.length; i++) {
			max=Math.max(max, arr[i]);
		}
		int maxbit=0;
		while (max!=0) {
			maxbit++;
			max/=10;
		}
		
		ArrayList<ArrayList<Integer>> bucketList=new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 10; i++) {
			bucketList.add(new ArrayList<Integer>());
		}
		for (int i = 0; i <maxbit; i++) {
			for (int j = 0; j < arr.length; j++) {
				int num= arr[j] % (int) (Math.pow(10, i+1)) / (int)(Math.pow(10, i));
				bucketList.get(num).add(arr[j]);
			}
			int index=0;
			for (int j = 0; j < bucketList.size(); j++) {
				for (int k = 0; k < bucketList.get(j).size(); k++) {
					arr[index++]=bucketList.get(j).get(k);
				}
				bucketList.get(j).clear(); //排序后就清空数组，便于后续排序存储
			}
		}
		
	}

}
