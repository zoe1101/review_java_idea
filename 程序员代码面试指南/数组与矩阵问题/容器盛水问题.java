package 数组与矩阵问题;

public class 容器盛水问题 {
	public static int getWater1(int[] arr) {
		if (arr==null || arr.length==0) {
			return 0;
		}
		int res=0;
		//0位置和arr.length-1位置位于容器边缘，不能盛水
		for (int i = 1; i < arr.length-1; i++) {
			int leftMax=0;
			int rightMax=0;
			for (int l = 0; l < i; l++) { //i位置左侧的最大值
				leftMax=Math.max(leftMax, arr[l]);
			}
			for (int r = i+1; r <arr.length; r++) { //i位置右侧的最大值
				rightMax=Math.max(rightMax, arr[r]);
			}
			//Math.max(Math.min(leftMax, rightMax)-arr[i], 0)：i位置的盛水量
			res+=Math.max(Math.min(leftMax, rightMax)-arr[i], 0);
		}
		return res;
	}
	public static int getWater2(int[] arr) {
		if (arr==null || arr.length==0) {
			return 0;
		}
		int res=0;
		int[] leftMax=new int[arr.length];
		int[] rightMax=new int[arr.length];
		leftMax[0]=arr[0];
		rightMax[arr.length-1]=arr[arr.length-1];
		for (int i = 1; i < arr.length; i++) {
			leftMax[i]=Math.max(leftMax[i-1], arr[i]);
		}
		for (int i = arr.length-2; i >=0; i--) {
			rightMax[i]=Math.max(rightMax[i+1], arr[i]);
		}
		//0位置和arr.length-1位置位于容器边缘，不能盛水
		for (int i = 1; i < arr.length-1; i++) {
			res+=Math.max(Math.min(leftMax[i-1], rightMax[i+1])-arr[i],0);
		}
		return res;
	}
	public static int getWater3(int[] arr) {
		if (arr==null || arr.length==0) {
			return 0;
		}
		int res=0;
		int leftMax=arr[0];
		int rightMax=arr[arr.length-1];
		int L=1;
		int R=arr.length-2;
		while (L<=R) {
			if (leftMax<=rightMax) {
				res+=Math.max(leftMax-arr[L], 0);
				leftMax=Math.max(leftMax, arr[L++]);
			}else {
				res+=Math.max(rightMax-arr[R], 0);
				rightMax=Math.max(rightMax, arr[R--]);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int[] arr1= {3,1,2,5,2,4};
		int[] arr2= {4,5,1,3,2};
		System.out.println(getWater1(arr1));
		System.out.println(getWater2(arr2));
		System.out.println(getWater3(arr2));

	}
}
