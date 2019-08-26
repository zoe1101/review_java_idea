package 数组与矩阵问题;

public class 需要排序的最短子数组长度 {
	public static int getMinLength(int[] arr) {
		if (arr==null ||arr.length<=1) {
			return 0;
		}
		//假设arr[noMinIndex:noMaxIndex]是需要排序的部分
		int min=arr[arr.length-1]; //从右至左遍历时，右侧出现过的最小值
		int noMinIndex=-1;
		int max=arr[0]; //从左至右遍历时，左侧出现过的最大值
		int noMaxIndex=-1;
		for (int i = arr.length-1; i >=0; i--) {
			if (arr[i]>min) { //有序
				noMinIndex=i;
			}else {
				min=Math.min(arr[i], min);
			}
		}
		if (noMinIndex==-1) { //整体有序，无需继续排序
			return 0;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]<max) { //有序
				noMaxIndex=i;
			}else {
				max=Math.max(arr[i], max);
			}
		}
		return noMaxIndex-noMinIndex+1;
	}

}
