package 排序算法;

import java.util.Arrays;
//时间复杂度O(N*logN)， 额外空间复杂度O(1)
public class 堆排序 {
	public static void heapSort(int[] arr) {
		if (arr==null || arr.length<2) {
			return;
		}
	    //建立大根堆，整体复杂度为O(N)
		for (int i = 0; i < arr.length; i++) { //向大根堆里加入arr[i]
			heapInsert(arr, i);
		}
		int size=arr.length;
		swap(arr, 0, --size); //最后一个数与堆顶交换， --size可以实现弹出堆顶元素的操作
		while (size>0) {
			heapify(arr,0,size); //因为交换导致了不平衡，所以需要堆调整
			swap(arr, 0, --size);
		}
	}


	private static void heapInsert(int[] arr, int i) {
		while (arr[i]>arr[(i-1)/2]) { //当前节点i的值大于其父节点的值
			swap(arr, i, (i-1)/2);
			i=(i-1)/2;
		}
	}

//假如大根堆里某一个值变小了，需要进行下沉操作
    private static void heapify(int[] arr, int i, int size) {
		int left=2*i+1;
		int right=2*i+2;
		while (left<size) { //左孩子不越界
			//右孩子不越界，且大于左孩子时，左右两个孩子的较大值为右孩子left+1
			int largest=left+1<size && arr[left+1]>arr[left]?left+1:left;
			largest=arr[i]>arr[largest]?i:largest;
			if (largest==i) { //当前节点就是最大值，大于左右孩子，不用继续下沉
				break;
			}
			//需要继续下沉 
			swap(arr, largest, i);
			i=largest;
			left=2*i+1;
		}
		
	}
    

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
	//test
    public static void main(String[] args) {
        int[] arr = {10, 23, 17, 88, 39, 13, 11, 109, 108, 383, 100, 1, 10, 14};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}