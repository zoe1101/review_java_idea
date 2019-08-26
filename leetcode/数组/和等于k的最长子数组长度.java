package 数组;

import java.util.HashMap;

/*
 */
public class 和等于k的最长子数组长度 {
	//问题1：给定一个数组，值全是正数，请返回累加和为给定值k的最长子数组长度。
	public static int getMaxLength1(int[] arr, int k) {
		if (arr==null || arr.length==0 || k<=0) {
			return 0;
		}
		int left=0;
		int right=0;
		int sum=arr[0];
		int maxlen=0;
		while (right<arr.length) {
			if (sum==k) {
				maxlen=Math.max(maxlen, right-left+1);
				sum-=arr[left++];
			}else if (sum<k) {
				sum+=arr[right++];
				if (right==arr.length) {
					break;
				}
			}else {
				sum-=arr[left++];
			}
			
		}
		return maxlen;
	}
	//问题2：给定一个数组，值可以为正、负和0，请返回累加和为给定值k的最长子数组长度。
	public static int getMaxLength2(int[] arr, int k) {
		if (arr==null || arr.length==0) {
			return 0;
		}
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>(); //累加和K最小出现的下标位置
		map.put(0, -1);
		int maxlen=0;
		int sum=0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
			//i位置的和为sum，找到和为sum-k的位置，两个位置相减，就能得到和为k的长度
			if (map.containsKey(sum-k)) {
				maxlen=Math.max(maxlen, i-map.get(sum-k));
			}
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		return maxlen;
	}
}
