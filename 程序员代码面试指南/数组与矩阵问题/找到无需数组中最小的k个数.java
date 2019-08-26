package 数组与矩阵问题;

import java.util.Arrays;

public class 找到无需数组中最小的k个数 {
		
	//方法一(堆排序方法，建立并维持含k个数的大根堆，时间复杂度为O(NlogK))
    public static int[]getMinKNumsByHeap(int[]arr,int k)
    {
    	if(k<1||k>arr.length)
    	{
    		return arr;
    	}
 
        int[]kheap=new int[k];
        //初始化一个堆的数据
        for(int i=0;i<k;i++)
        {
            heapInsert(kheap,arr[i],i);
        }
 
        for(int i=k;i!=arr.length;i++)
        { 
        	if(arr[i]<kheap[0])
        	{
        		kheap[0]=arr[i];
        		heapify(kheap,0,k);
        	}
 
        }
        
        return kheap;
    }
    //建立含有k个数的大根堆
    public static void heapInsert(int[]arr,int value,int index)
    {
    	 arr[index]=value;
    	 while(index!=0)
    	 {
    	 	int parent=(index-1)/2;
    	 	if(arr[parent]<arr[index])
    	 	{
    	 		swap(arr,parent,index);
    	 		index=parent;
    	 	}else
    	 	{
    	 		break;
    	 	}
    	 }
 
    }
    //调整含有k个数的大根堆
    public static void heapify(int[]arr,int index,int heapSize)
    {
          int left=index*2+1;
          int right=index*2+2;
          int largest=index;
          while(left<heapSize)
          {
          	 if(arr[left]>arr[index])
          	 {
          	 	largest=left;
          	 }
             if(right<heapSize&&arr[right]>arr[largest])
             {
             	largest=right;
             }
             if(largest!=index)
             {
             	swap(arr,largest,index);
             }else
             {
             	break;
             }
             index=largest;
             left=index*2+1;
             right=index*2+2;
          }
 
    }
  
  //****************************************************************************
	//方法二(经典线性查找算法(BFPRT算法)，时间复杂度为O(N))
    public static int[] getMinKNumsByBFPRT(int[] arr, int k) {
		if (k < 1 || k > arr.length) {
			return arr;
		}
		int minKth = getMinKthByBFPRT(arr, k);
		int[] res = new int[k];
		int index = 0;
		for (int i = 0; i != arr.length; i++) {
			if (arr[i] < minKth) {
				res[index++] = arr[i];
			}
		}
		for (; index != res.length; index++) {
			res[index] = minKth;
		}
		return res;
	}
 
	public static int getMinKthByBFPRT(int[] arr, int K) {
		int[] copyArr = copyArray(arr);
		return select(copyArr, 0, copyArr.length - 1, K - 1);
	}
 
	public static int[] copyArray(int[] arr) {
		int[] res = new int[arr.length];
		for (int i = 0; i != res.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}
 
	public static int select(int[] arr, int begin, int end, int i) {
		if (begin == end) {
			return arr[begin];
		}
		int pivot = medianOfMedians(arr, begin, end);
		int[] pivotRange = partition(arr, begin, end, pivot);
		if (i >= pivotRange[0] && i <= pivotRange[1]) {
			return arr[i];
		} else if (i < pivotRange[0]) {
			return select(arr, begin, pivotRange[0] - 1, i);
		} else {
			return select(arr, pivotRange[1] + 1, end, i);
		}
	}
 
	public static int medianOfMedians(int[] arr, int begin, int end) {
		int num = end - begin + 1;
		int offset = num % 5 == 0 ? 0 : 1;
		int[] mArr = new int[num / 5 + offset];
		for (int i = 0; i < mArr.length; i++) {
			int beginI = begin + i * 5;
			int endI = beginI + 4;
			mArr[i] = getMedian(arr, beginI, Math.min(end, endI));
		}
		return select(mArr, 0, mArr.length - 1, mArr.length / 2);
	}
    //划分
	public static int[] partition(int[] arr, int begin, int end, int pivotValue) {
		int small = begin - 1;
		int cur = begin;
		int big = end + 1;
		while (cur != big) {
			if (arr[cur] < pivotValue) {
				swap(arr, ++small, cur++);
			} else if (arr[cur] > pivotValue) {
				swap(arr, cur, --big);
			} else {
				cur++;
			}
		}
		int[] range = new int[2];
		range[0] = small + 1;
		range[1] = big - 1;
		return range;
	}
    //获得中位数
	public static int getMedian(int[] arr, int begin, int end) {
		insertionSort(arr, begin, end);
		int sum = end + begin;
		int mid = (sum / 2) + (sum % 2);
		return arr[mid];
	}
    //插入排序
	public static void insertionSort(int[] arr, int begin, int end) {
		for (int i = begin + 1; i != end + 1; i++) {
			for (int j = i; j != begin; j--) {
				if (arr[j - 1] > arr[j]) {
					swap(arr, j - 1, j);
				} else {
					break;
				}
			}
		}
	}
     //两个数的交换
	public static void swap(int[] arr, int index1, int index2) {
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}
    //打印数组
	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
 
		public static void main(String[]args)
		{
	      int[] arr = { 6, 9, 1, 3, 1, 2, 2, 5, 6, 1, 3, 5, 9, 7, 2, 5, 6, 1, 9 };
		  // sorted : { 1, 1, 1, 1, 2, 2, 2, 3, 3, 5, 5, 5, 6, 6, 6, 7, 9, 9, 9 }
		  printArray(getMinKNumsByHeap(arr, 5));   //堆排序算法
		  printArray(getMinKNumsByBFPRT(arr, 5));  //BFPRT算法
		}
}
	
