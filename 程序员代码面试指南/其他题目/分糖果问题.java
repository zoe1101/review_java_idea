package 其他题目;

public class 分糖果问题 {
	/*
	 *一群孩子做游戏，现在请你根据游戏得分来发糖果，要求如下： 
　　1、每个孩子不管得分多少，起码分到1个糖果 
　　2、任意两个相邻的孩子之间，得分较多的孩子必须多拿一些糖果
	 */
	//用到了上坡下坡的思想，并且坡顶的值为坡度较高的值
	public static int candy1(int[] arr) {
		if (arr==null || arr.length==0) {
			return 0;
		}
		int index=nextMinIndex(arr,0); 
		int res=rightCands(arr,0,index++);
		int lbase=1; //左坡的起始值
		int next=0;
		int rcands=0;
		int rbase=0;
		while (index!=arr.length) {
			if (arr[index]>arr[index-1]) {
				res+=++lbase;
				index++;
			}else if (arr[index]<arr[index-1]) {
				next=nextMinIndex(arr, index-1);
				rcands=rightCands(arr, index-1, next++);
				rbase=next-index+1;
				res+=rcands+(rbase>lbase?-lbase:-rbase);
				lbase=1;
				index=next;
			}else {
				res+=1;
				lbase=1;
				index++;
			}
		}
		return res;
	}

	private static int nextMinIndex(int[] arr, int start) {
		for (int i = start; i < arr.length-1; i++) {
			if (arr[i]<=arr[i+1]) { 
				return i;
			}
		}
		return arr.length-1;
	}
	
	private static int rightCands(int[] arr, int left, int right) {
		int n=right-left+1;
		return n+n*(n-1)/2;
	}
	
}
