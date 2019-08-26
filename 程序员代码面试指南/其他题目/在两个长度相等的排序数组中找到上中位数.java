package 其他题目;

import java.util.concurrent.TimeoutException;

public class 在两个长度相等的排序数组中找到上中位数 {
	public static int getUpMedian(int[] arr1,int[] arr2) {
		if (arr1==null || arr2==null || arr1.length!=arr2.length) {
			throw new RuntimeException("输入有误！");
		}
		int start1=0;
		int end1=arr1.length-1;
		int start2=0;
		int end2=arr2.length-1;
		int mid1=0;
		int mid2=0;
		int offset=0;
		while (start1<end1) {
			mid1=(start1+end1)/2;
			mid2=(start2+end2)/2;
			//元素个数为奇数：0；元素个数为偶数：1
			offset=((end1-start1+1)&1)^1;
			if (arr1[mid1]>arr2[mid2]) {
				end1=mid1;
				start2=mid2+offset;
			}else if (arr1[mid1]<arr2[mid2]) {
				start1=mid1+offset;
				end2=mid2;
			}else { //arr1[mid1] == arr2[mid2]
				return arr1[mid1];
			}
		}
		return Math.min(arr1[start1], arr2[start2]);
	}

}
