package 堆;

import java.math.BigDecimal;
import java.util.Arrays;

public class MaxHeap {
	private int[] data;
	/**
	 * 构造方法：传入一个数组，并转换为一个最大堆
	 * @param data
	 */
	public MaxHeap(int[] data) {
		this.data=data;
		buildHeap();
	}
	/**
	 * 将数组转化为最大堆,构造大顶堆
	 */
	private void buildHeap() {
		//完全二叉树只有数组下标小于或等于 (data.length) / 2 - 1 的元素有孩子结点，遍历这些结点
		for(int i=(data.length)/2-1;i>=0;i--) {//建堆，从(data.length) / 2 - 1 开始向上调整
			heapify(i);
		}
	}
	public void heapify(int i) {
		int left=left(i);
		int right=right(i);
		int largest=i;// 假定的当前节点、左子节点、右子节点中 最大值的下标
		if(left<data.length &&data[left]>data[i]) {// 存在左子节点，且左子节点的值大于当前节点的值
			largest=left;
		}
		if(right<data.length && data[right]>data[i]) {// 存在右子节点，且右子节点的值大于当前节点的值
			largest=right;
		}
		if(largest!=i) {
			swap(largest, i);
		}else {
			return;
		}
		
		heapify(largest);// 从之前最大值节点位置重新堆化
	}
	public int left(int i) { //获取左孩子节点的数组下标
		return i*2+1;
	}
	public int right(int i) { //获取右孩子节点的数组下标
		return i*2+2;
	}
	
	
	public  void swap(int index1,int index2) {//交换元素
		int temp=data[index1];
		data[index1]=data[index2];
		data[index2]=temp;
		
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
		MaxHeap heap = new MaxHeap(num);
		heap.buildHeap();
		heap.printHeap();

	}

}
