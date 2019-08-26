package 其他题目;

public class 在两个排序数组中找到第k小的数 {
	public static int findKthNum(int[] arr1,int[] arr2,int k) {
		if (arr1==null || arr2==null) {
			throw new RuntimeException("输入数组无效");
		}
		if (k<1||k>arr1.length+arr2.length) {
			throw new RuntimeException("k无效");
		}
		int[] longs=arr1.length>=arr2.length?arr1:arr2;
		int[] shorts=arr1.length<arr2.length?arr1:arr2;
		int lLen=longs.length;
		int sLen=shorts.length;
		if (k<=sLen) {
			return getUpMedian(arr1, 0, k-1, arr2, 0, k-1);
		}
		if (k>lLen) {
			if (shorts[k-lLen-1]>=longs[lLen-1]) {
				return shorts[k-lLen-1];
			}
			if (longs[k-sLen-1]>=shorts[sLen-1]) {
				return longs[k-sLen-1];
			}
		}
		return getUpMedian(arr1, k-1, sLen-1, arr2, k-sLen, lLen-1);
	}
	
	public static int getUpMedian(int[] arr1,int start1,int end1, int[] arr2,int start2,int end2) {
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
