package 数组;
/*
给定一个含有 n 个正整数的数组和一个正整数s,找出该数组中满足其和 ≥s的长度最小的连续子数组。
如果不存在符合条件的连续子数组，返回 0。

示例: 

输入: s = 7, nums = [2,3,1,2,4,3]
输出: 2
解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。

著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 长度最小的子数组 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums==null || nums.length==0 || s<=0) {
			return 0;
		}
        int left=0;
        int right=0;
        int minlen=Integer.MAX_VALUE;
        int sum=nums[0];
        while (right<nums.length) {
			if (sum>=s) {
				minlen=Math.min(minlen, right-left+1);
				sum-=nums[left++];
			}else{
				right++;
				if (right==nums.length) {
					break;
				}
				sum+=nums[right];
			}
		}
        return minlen==Integer.MAX_VALUE?0:minlen; 
    }
}
