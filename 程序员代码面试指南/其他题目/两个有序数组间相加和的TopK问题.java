package 其他题目;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class 两个有序数组间相加和的TopK问题 {
	public static class Node {
		public int index1; //arr1中的位置
		public int index2; //arr2中的位置
		public int value;  //arr1[index1]+arr2[index2]的值
		public Node(int i1,int i2,int sum) {
			this.index1=i1;
			this.index2=i2;
			this.value=sum;
		}
	}
	//大根堆比较器
	public static class MaxHeapComp implements Comparator<Node>{
		public int compare(Node o1,Node o2) {
			return o2.value-o1.value;
		}
	}
	public static int[] topKSum(int[] arr1,int[] arr2,int k) {
		if (arr1==null || arr2==null || k<1) {
			return null;
		}
		k=Math.min(k, arr1.length*arr2.length);
		int[] res=new int[k];
		int resIndex=0;
		PriorityQueue<Node> maxHeap=new PriorityQueue<Node>(new MaxHeapComp());
		HashSet<String> positionSet=new HashSet<String>();
		int i1=arr1.length-1;
		int i2=arr2.length-1;
		maxHeap.add(new Node(i1, i2, arr1[i1]+arr2[i2]));
		positionSet.add(String.valueOf(i1+"_"+i2));
		while (resIndex<k) {
			Node curNode=maxHeap.poll();
			res[resIndex++]=curNode.value;
			i1=curNode.index1;
			i2=curNode.index2;
			if (!positionSet.contains(String.valueOf((i1-1)+"_"+i2))) {
				positionSet.add(String.valueOf((i1-1)+"_"+i2));
				maxHeap.add(new Node(i1-1, i2, arr1[i1-1]+arr2[i2]));
			}
			if (!positionSet.contains(String.valueOf(i1+"_"+(i2-1)))) {
				positionSet.add(String.valueOf(i1+"_"+(i2-1)));
				maxHeap.add(new Node(i1, i2-1, arr1[i1]+arr2[i2-1]));
			}
		}
		return res;
	}

}
