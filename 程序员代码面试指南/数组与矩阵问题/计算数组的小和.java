package 数组与矩阵问题;
/**
数组小和的定义如下：例如，数组s=[1,3,5,2,4,6]
在s[0]的左边小于或等于s[0]的数的和为0
在s[1]的左边小于或等于s[1]的数的和为1
在s[2]的左边小于或等于s[2]的数的和为1+3=4
在s[3]的左边小于或等于s[3]的数的和为1
在s[4]的左边小于或等于s[4]的数的和为1+3+2=6
在s[5]的左边小于或等于s[5]的数的和为1+3+5+2+4=15
所以s的小和为0+1+4+1+6+15=27
给定一个数组s，实现函数返回s的小和。

 * @author zoe
 *
 */
public class 计算数组的小和 {
	public static int getSmallSum(int[] arr) {
		if (arr==null || arr.length==0) {
			return 0;
		}
		return func(arr, 0, arr.length-1);
		
	}
	 //利用归并排序实现，拆分数组再合并
	public static int func(int[] arr,int l,int r) { 
		if (l==r) {
			return 0;
		}
		int mid=(l+r)/2;
		return func(arr, l, mid)+func(arr, mid+1, r)+merge(arr, l, mid, r);
	}
	public static int merge(int[] arr,int left,int mid,int right) {
		int[] help=new int[right-left+1]; //记录排序好的数组
		int hi=0;
		int i=left;
		int j=mid+1;
		int smallSum=0;
		while (i<=mid && j<=right) {
			if (arr[i]<=arr[j]) {
				smallSum+=arr[i]*(right-j+1);
				help[hi++]=arr[i++];
			}else {
				help[hi++]=arr[j++];
			}
		}
		for (; (j<=right || i<=mid);j++,i++) {
			help[hi++]=i>mid?arr[j]:arr[i];
		}
		for (int k = 0; k < help.length; k++) { //将排序好的数组值复制给原数组
			arr[left++]=help[k];
		}
		return smallSum;
	}
	public static void main(String[] args) {
		int[] arr = { 1,3,5,2,4,6 };
		System.out.println(getSmallSum(arr));

	}
}
