package 数组与矩阵问题;


public class 打印N个数组整体最大的TopK {
	//利用大顶堆实现
	/**
	1.构建一个大小为N的大根堆，建堆的过程就是把每一个数组的最后一个值，
		也就是该数组的最大值，依次加入到堆里，这个过程就是建堆的调整过程。
	2.建好堆以后，此时堆顶的元素就是所有数组中最大的元素，打印堆顶元素。
	3.假设堆顶的元素来自 a 数组的 i 位置，那么将堆顶的元素用a[i-1]替换，
		然后从堆的头部重新调整堆。如果发现此时 a 数组已经没有元素，那么就将堆顶元素与堆尾元素交换，
		同时令堆的大小减1，仍然是从堆的头部重新调整堆。
	4.每次都可得到一个堆顶元素，打印k个堆顶元素，就是最终的结果。
	 */
	public static class HeapNode{
		public int value; //节点值
		public int arrNum; //节点来自哪个数组
		public int index; //节点来自数组的哪个位置
		public HeapNode(int value,int arrNum,int index) {
			this.value=value;
			this.arrNum=arrNum;
			this.index=index;
		}
	}
	public static void printTopK(int[][] matrix,int topK) {
		int heapSize=matrix.length; //数组的个数
		HeapNode[] heap=new HeapNode[heapSize];
		for (int i = 0; i < heapSize; i++) {  
			int index=matrix[i].length-1; 
			 //把每个数组的最后一个元素放进堆中
			heap[i]=new HeapNode(matrix[i][index], i, index);
			heapInsert(heap, i);
		}
		System.out.println("Top" +topK+" : ");
		for (int i = 0; i < topK; i++) {
			if (heapSize==0) { //已经没有元素了
				break;
			}
			System.out.print(heap[0].value+" "); //输出堆顶元素
			if (heap[0].index!=0) { //不是第一个元素时用前一个元素替换堆顶元素
				heap[0].value=matrix[heap[0].arrNum][--heap[0].index];
			}else { //堆顶元素所在的数组已经遍历完了，需要对堆的节点数做调整
				swap(heap, 0, --heapSize);
			}
			heapify(heap, 0, heapSize); //堆调整
		}
	}
	//在堆中插入节点
	public static void heapInsert(HeapNode[] heap,int index) {
		while (index!=0) { //如果不是堆顶节点
			int parent=(index-1)/2; //父节点
			if (heap[parent].value<heap[index].value) {
				swap(heap, parent, index);
				index=parent;
			}else {
				break;
			}
		}
	}
	//堆调整
	public static void heapify(HeapNode[] heap,int index,int heapSize) {
		int left=index*2+1;
		int right=index*2+2;
		int largest=index;
		while (left<heapSize) {
			if (heap[left].value>heap[index].value) {
				largest=left;
			}
			if (right<heapSize && heap[right].value>heap[largest].value) {
				largest=right;
			}
			if (largest!=index) {
				swap(heap, largest, index);
			}else {
				break;
			}
			index=largest;
			left=index*2+1;
			right=index*2+2;
		}
	}
	public static void swap(HeapNode[] heap,int index1,int index2) {
		HeapNode tmp=heap[index1];
		tmp=heap[index1]=tmp=heap[index2];
		tmp=heap[index2]=tmp;
	}

}
