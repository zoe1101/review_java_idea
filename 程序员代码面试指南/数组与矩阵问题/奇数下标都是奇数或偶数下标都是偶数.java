package 数组与矩阵问题;

public class 奇数下标都是奇数或偶数下标都是偶数 {
	public static void modify(int[] arr) {
		if (arr==null || arr.length<2) { //无需调整
			return ;
		}
		int even=0; //偶数下标
		int odd=1; //奇数下标
		int end=arr.length-1; //最后一个元素的下标
		while (even<=end && odd<=end) {
			if ((arr[end]&1)==0) { //最后一个元素是偶数
				swap(arr, even, end);
				even+=2;
			}else {
				swap(arr, odd, end);
				odd+=2;
			}
		}
	}
	public static void swap(int[] arr,int i,int j) {
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}

}
