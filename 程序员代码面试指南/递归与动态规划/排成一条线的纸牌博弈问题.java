package 递归与动态规划;

import 堆.MaxHeap;

public class 排成一条线的纸牌博弈问题 {
	//暴力递归
	public static int win1(int[] arr) {
		if (arr==null || arr.length==0) {
		return 0;
		}
		return Math.max(f(arr, 0,arr.length-1),s(arr,0,arr.length-1));
	}
	//如果arr[i..j]被绝顶聪明的人先拿，返回最终能获得的分数f(i,j)
	public static int f(int[] arr,int i,int j) {
		if (i==j) { //只有一张牌arr[i]
			return arr[i];
		}
		//可以先拿走arr[i]或arr[j]
		return Math.max(arr[i]+s(arr, i+1, j), arr[j]+s(arr, i, j-1));
	}
	//如果arr[i..j]被绝顶聪明的人后拿，返回最终能获得的分数是s(i,j)
	public static int s(int[] arr,int i,int j) {
		if (i==j) {
			return 0;
		}
		return Math.min(f(arr, i+1, j), f(arr, i, j-1));
	}
	public static int win2(int[] arr) {
		if (arr==null || arr.length==0) {
			return 0;
			}
		int len=arr.length;
		int[][] f=new int[len][len];
		int[][] s=new int[len][len];
		for (int j = 0; j < len; j++) {
			f[j][j]=arr[j];
			for (int i = j-1; i >=0; i--) {
				f[i][j]=Math.max(arr[i]+s[i+1][j], arr[j]+s[i][j-1]);
				s[i][j]=Math.min(f[i-1][j],f[i][j-1]);
			}
		}
		return Math.max(f[0][len-1], s[0][len-1]);
	}
	

}
