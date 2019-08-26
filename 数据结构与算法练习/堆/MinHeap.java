package 堆;

import java.util.Arrays;

public class MinHeap {
	private int[] data;
	public MinHeap(int[] data) {
		this.data=data;
		buildHeap();
	}
	public void buildHeap() {
		for(int i=(data.length)/2-1;i>=0;i--) {
			heapify(i);
		}
	}
	public void heapify(int i) {
		int left=left(i);
		int right=right(i);
		int smallest=i;
		if(left<data.length && data[left]<data[i]) {// 存在左子节点，且左子节点的值小于当前节点的值
			smallest=left;
		}
		if(right<data.length && data[right]<data[i]) {// 存在右子节点，且右子节点的值小于当前节点的值
			smallest=right;
		}
		if(smallest!=i) {// 将最小值与当前节点互换位置
			swap(smallest, i);
		}else {
			return;
		}
		heapify(smallest);// 从之前最小值节点位置重新堆化
	}
	public  void swap(int index1,int index2) {//交换元素
		int temp=data[index1];
		data[index1]=data[index2];
		data[index2]=temp;
		
	}
	public int left(int i) {
		return i*2+1;
	}
	public int right(int i) {
		return i*2+2;
	}
	public int getroot() {//获取堆中最大元素，即根元素
		return data[0];
	}
	public void setRoot(int root) {//替换根元素，并重新heapify
		data[0]=root;
		heapify(0);
	}
	 public void HeapDelete(int value) {
		 int heapsize=data.length;
		 for(int i=0;i<heapsize;i++) {
			 if(data[i]==value) {
				 break;
			 }
		 }
	 }
	public void printHeap() {//二叉树层序遍历
		System.out.print(Arrays.toString(data));
	}

	public static void main(String[] args) {
		int[] num = new int[]{49,38,65,97,76,13,27,49};
		MinHeap heap = new MinHeap(num);
		heap.buildHeap();
		heap.printHeap();

	}

}
