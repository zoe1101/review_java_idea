package 递归与动态规划;

import java.util.HashMap;

public class 数组中最长连续序列 {
	public static int longestConsecutive(int[] arr) {
		if (arr==null || arr.length==0) {
			return 0;
		}
		int max=1;
		//arr[i]所在的最长连续序列的长度
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) { //arr[i]没有出现过
				map.put(arr[i], 1);
				if (map.containsKey(arr[i]-1)) { //arr[i]-1出现过，需要进行合并
					max=Math.max(max, merge(map, arr[i]-1,arr[i]));
				}
				if (map.containsKey(arr[i]+1)) { //arr[i]+1出现过，需要进行合并
					max=Math.max(max, merge(map,arr[i], arr[i]+1));
				}
			}
		}
		return max;
	}
	public static int merge(HashMap<Integer, Integer> map,int less,int more) {
		int left=less-map.get(less)+1; //合并时，较小序列中的最小值
		int right=more+map.get(more)-1; //合并时，较大序列中的最大值
		int len=right-left+1; //合并后的序列长度
		map.put(left, len);
		map.put(right,len);
		return len;
	}

}
