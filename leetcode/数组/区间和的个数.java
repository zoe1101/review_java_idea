package 数组;
/*
给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。
区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。

说明:
最直观的算法复杂度是 O(n2) ，请在此基础上优化你的算法。

示例:

输入: nums = [-2,5,-1], lower = -2, upper = 2,
输出: 3 
解释: 3个区间分别是: [0,0], [2,2], [0,2]，它们表示的和分别为: -2, -1, 2。

 */
public class 区间和的个数 {
    public int countRangeSum(int[] nums, int lower, int upper) {
    	if(nums == null || nums.length == 0){
            return 0;
        }
    	int count=0;
    	long[] res = new long[nums.length];
    	long sum = 0;
    	for(int i = 0; i < nums.length; i++){
            if(lower<= nums[i] && nums[i]<=upper){//单个数值在所给区间范围
                count++;
            }
            sum += nums[i];
            res[i] = sum;
        }
    	for(int i = 1; i < nums.length; i++){
            if(lower<= res[i] && res[i]<=upper){//从第0个到第i个元素之和在所给区间范围
                count++;
            }
            for(int j = 0; j < i-1; j++){
                long z = res[i] - res[j];
                if(lower<= z && z<=upper){ //从第j个到第i个元素之和在所给区间范围
                    count++;
                }
            }
        }
        return count;
    }
}
