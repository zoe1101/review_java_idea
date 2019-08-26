package 字符串;

public class 子数组的最大异或和 {
	public static int maxXorSubarray1(int[] arr) {
		if (arr==null || arr.length==0) {
			return 0;
		}
		int[] eor=new int[arr.length]; //eor[i]:记录arr[0:i]的异或和
		eor[0]=arr[0];
		for (int i = 1; i < arr.length; i++) {
			eor[i]=eor[i-1]^arr[i];
		}
		int max=Integer.MIN_VALUE;
		for (int j = 0; j < arr.length; j++) {
			for (int i = 0; i<=j; i++) {
				max=Math.max(max, i==0?eor[j]:eor[j]^eor[i-1]); //eor[i:j]=eor[j]^eor[i-1]
			}
		}
		return max;
	}
	//还有一种基于前缀树的挑选方法

}
