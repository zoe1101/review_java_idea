package 数组与矩阵问题;

public class 数组排序之后相邻数的最大差值 {
	//利用桶排序思想
	public static int maxGap(int[] nums) {
		if (nums==null || nums.length<2) {
			return 0;
		}
		int len=nums.length;
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		for (int i = 0; i <len; i++) {
			max=Math.max(max, nums[i]);
			min=Math.min(min, nums[i]);
		}
		if (max==min) { 
			return 0;
		}
		boolean[] hasNum=new boolean[len+1]; //记录每个桶里有没有数
		int[] maxs=new int[len+1]; //记录每个桶中数字的最大值
		int[] mins=new int[len+1]; //记录每个桶中数字的最小值
		int bid=0;
		for (int i = 0; i < len; i++) {
			bid=(nums[i]-min)*len/(max-min); //每个数对应的桶号
			mins[bid]=hasNum[bid]?Math.min(mins[bid], nums[i]):nums[i];
			maxs[bid]=hasNum[bid]?Math.max(maxs[bid], nums[i]):nums[i];
			hasNum[bid]=true;
		}
		int res=0;
		int lastMax=maxs[0]; //左边最近有值桶的最大值
		for (int i = 1; i <= len; i++) {
			if (hasNum[i]) { //第i个桶里有数
				res=Math.max(res, mins[i]-lastMax);
				lastMax=maxs[i];
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int[] arr = { 11, 10, 9, 3, 1, 12 };
		System.out.println(maxGap(arr));

	}

}
