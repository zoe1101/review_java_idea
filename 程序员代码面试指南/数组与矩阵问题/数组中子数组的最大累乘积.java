package 数组与矩阵问题;

public class 数组中子数组的最大累乘积 {
	public static double maxProduct(int[] arr) {
		if (arr==null || arr.length==0) {
			return 0;
		}
		double max=arr[0]; //以arr[i]结尾的最大累乘积
		double min=arr[0]; //以arr[i]结尾的最小累乘积
		double res=arr[0];
		double maxEnd=0; 
		double minEnd=0;
		for (int i = 0; i < arr.length; i++) {
			maxEnd=max*arr[i];  //3*5的情况
			minEnd=min*arr[i]; //负负得正的情况（-3，-5）
			//arr[i]:(0.5,100)的情况
			max=Math.max(Math.max(maxEnd, minEnd), arr[i]); //以arr[i]结尾的最大累乘积
			min=Math.min(Math.min(maxEnd, minEnd), arr[i]);
			res=Math.max(res, max);
		}
		return res;
	}

}
