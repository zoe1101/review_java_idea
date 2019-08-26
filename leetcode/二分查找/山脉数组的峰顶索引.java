package 二分查找;
/*
我们把符合下列属性的数组 A 称作山脉：
A.length >= 3
存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。

输入：[0,2,1,0]
输出：1
 */
public class 山脉数组的峰顶索引 {
    public static int peakIndexInMountainArray(int[] A) {
    	  int left=0,right=A.length-1; 
          while(left+1<right) {
          	int mid=(left+right)/2;
          	if(A[mid]<A[mid+1]) { //A[mid+1]>A[mid],那么峰顶必然在mid+1到A.length内(右侧)
          		left=mid+1;
          	}else {
          		right=mid;
          	}
          }
          return (left==A.length-1|| A[left]>A[left+1])?left:right;
    }
	public static void main(String[] args) {
	    int[] arr = {0,2,1,0};
	    System.out.println(peakIndexInMountainArray(arr));

	}

}
