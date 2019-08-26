package 数组与矩阵问题;

import java.util.PriorityQueue;

//哈夫曼编码问题，求加权路径最小
public class 分金条的最小花费 {
	public static int getMinSplitCost(int[] arr) {
		if (arr==null || arr.length<2) {
			return 0;
		}
		PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>();
		for (int i = 0; i < arr.length; i++) { //所有元素入堆
			minHeap.add(arr[i]);
		}
		int res=0;
		while (minHeap.size()!=1) {
			int sum=minHeap.poll()+minHeap.poll(); //弹出两个较小的元素
			res+=sum;
			minHeap.add(sum);
		}
		return res;
	}
}
