package 数组与矩阵问题;

import java.util.Arrays;

public class  数组中未出现的最小正整数{
	public static int missNum1(int[] arr) {
		if (arr==null || arr.length==0) {
			return 1;
		}
		Arrays.sort(arr);
		if(arr[arr.length-1]<1) {
			return 1;
		}
		int res=1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]==res) {
				res++;
			}
		}
		return res;
	}
	public static int missNum2(int[] arr) {
		int l=0; //表示[1,l]范围的数已经出现过了，初始化为0，表示还没有正整数出现
		int r=arr.length; //表示后续出现最有情况下，可能包含[1,r]范围的数
		//初始化为arr.length，表示还没有开始遍历，最优情况事[1,N]中的数都出现
		
		while (l<r) {
			if (arr[l]==l+1) { 
				l++;
			}else if (arr[l]<=l || arr[l]>r || arr[arr[l]-1]==arr[l]) {
				arr[l]=arr[--r];
			}else {
				swap(arr, l, arr[l]-1);
			}
		}
		return l+1;
	}
	public static void swap(int[] arr,int i,int j) {
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
	
	public static void main(String[] args) {
		int[] arr = { -1, 0, 2, 1, 3, 5 };
		System.out.println(missNum1(arr));
		System.out.println(missNum2(arr));

	}
}
