package 数组;
/*
给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
数学表达式如下:
如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。



输入: [1,2,3,4,5]
输出: true

 */
public class 递增的三元子序列 {
	/*
a 始终记录最小元素，b 为某个子序列里第二大的数。
接下来不断更新 a，同时保持 b 尽可能的小。
如果下一个元素比 b 大，说明找到了三元组。
	 */
    public boolean increasingTriplet(int[] nums) {
    	int a=Integer.MAX_VALUE;
    	int b=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
			if (nums[i]<=a) {
				a=nums[i];
			}else if (nums[i]<=b) {
				b=nums[i];
			}else { //出现了比a,b都大的数，表示满足递增
				return true;
			}
		}
        return false;
    }
}
