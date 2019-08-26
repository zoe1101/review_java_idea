package 数组;
/*
给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。

示例:
输入: [1,2,3,4]
输出: [24,12,8,6]
说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
/*
思路：每一个数除了它本身所有数的乘积都是他左边数的乘积 乘以 右边数的乘积。
例输入[1,2,3,4] , 左边数乘积n1=[1,1,2,6] ,右边数乘积n2=[1,4,12,24] ,返回结果等于[1*24 , 1*12 , 2*4 , 6*1]。
 */
public class 除自身以外数组的乘积 {
	public static int[] productExceptSelf(int[] nums) {
		int n=nums.length;
		int right=1;
		int[] product=new int[n];
		product[0]=1;
		for(int i=1;i<n;i++) { //前向遍历
			product[i]=nums[i-1]*product[i-1];
		}
		for(int i=n-1;i>=0;i--) {//后向遍历
			product[i]*=right;
			right*=nums[i];
		}
		return product;
    }
	
	public static void main(String[] args) {
		int[] nums= {1,2,3,4};
		int[] prod=productExceptSelf(nums);
		for(int e:prod) {
		System.out.print(e+" ");
		}
	}

}
