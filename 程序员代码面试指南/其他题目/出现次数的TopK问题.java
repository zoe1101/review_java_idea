package 其他题目;

import java.util.HashMap;
import java.util.Map.Entry;

public class 出现次数的TopK问题 {
	public static class Node {
		public String str; 
		public int times;
		public Node(String str,int times) {
			this.str=str;
			this.times=times;
		}
	}
	public static void printTopKAndRank(String[] arr,int k) {
		if (arr==null ||k<1) {
			return ;
		}
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			}else {
				map.put(arr[i], map.get(arr[i])+1);
			}
		}
		Node[] heap=new Node[k];
		int index=0;
		for (Entry<String, Integer> entry:map.entrySet()) {
			String str=entry.getKey();
			int times=entry.getValue();
			Node node=new Node(str,times);
			if (index!=k) {
				heap[index]=node;
				heapInsert(heap,index++);
			}else {
				if (heap[0].times<node.times) {
					heap[0]=node;
					heapify(heap,0,k);
				}
			}
		}
		//按照词频从大到小的顺序排
		for (int i = index-1; i>0; i--) {
			swap(heap, 0, i);
			heapify(heap, 0, i);
		}
		for (int i = 0; i < heap.length; i++) {
			if(heap[i]==null) {
				break;
			}else {
				System.out.println("No."+(i+1)+": "+heap[i].str+",times: "+heap[i].times);
			}
		}
	}
	private static void heapify(Node[] heap, int index, int heapSize) {
		int left=index*2+1;
		int right=index*2+2;
		int smallest=index;
		while (left<heapSize) {
			if (heap[left].times<heap[index].times) {
				smallest=left;
			}
			if (right<heapSize && heap[right].times<heap[smallest].times) {
				smallest=right;
			}
			if (smallest!=index) {
				swap(heap, smallest, index);
			}else {
				break;
			}
			index=smallest;
			left=index*2+1;
			right=index*2+2;
			
		}
		
	}
	private static void heapInsert(Node[] heap, int index) {
		while (index!=0) {
			int parent=(index-1)/2;
			if (heap[index].times<heap[parent].times) {
				swap(heap,parent,index);
				index=parent;
			}else {
				break;
			}
		}
		
	}
	private static void swap(Node[] heap, int index1, int  index2) {
		Node tmp=heap[ index1];
		heap[index1]=heap[index2];
		heap[index2]=tmp;
		
	}
	public static String[] generateRandomArray(int len, int max) {
		String[] res = new String[len];
		for (int i = 0; i != len; i++) {
			res[i] = String.valueOf((int) (Math.random() * (max + 1)));
		}
		return res;
	}

	public static void printArray(String[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		String[] arr = generateRandomArray(50, 10);
		int topK = 3;
		printArray(arr);
		printTopKAndRank(arr, topK);

	}
	
}
