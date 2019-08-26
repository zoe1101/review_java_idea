package Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：
Si % Sj = 0 或 Sj % Si = 0。

如果有多个目标子集，返回其中任何一个均可。

示例 1:
输入: [1,2,3]
输出: [1,2] (当然, [1,3] 也正确)

示例 2:
输入: [1,2,4,8]
输出: [1,2,4,8]

 */
public class 最大整除子集 {
	/*
先对数组排序，dp[i]表示nums[0 ... i]中最大整除子集的长度
 递推关系式： dp[i] = dp[j] + 1 , if nums[i] % nums[j] == 0;
 边界条件：初始值dp[i] = 1;(每个数本身就可以构成一整除子集)
	 */
    public List<Integer> largestDivisibleSubset(int[] nums) {
    	List<Integer> res = new ArrayList<>();
    	if (nums.length==0) {
    		return res;
		}
    	int[] dp = new int[nums.length];
    	Arrays.fill(dp, 1);
        Arrays.sort(nums); //排序
        for(int i = 1 ; i < nums.length ; i ++){
            for(int j = i - 1 ; j >= 0 ; j --){
                if(nums[i] % nums[j] == 0)
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
        }

        int maxLen = dp[0];
        for(int i = 1; i < dp.length; i ++){
            maxLen = maxLen > dp[i] ? maxLen : dp[i];
        }

        /**
         	* 最大值在靠右边的位置，因此可以从length - 1处开始遍历
         */
        for(int i = dp.length - 1 ; i >= 0 ; i --){
            if(maxLen == dp[i]){
                if(res.size() == 0){
                    res.add(nums[i]);
                    maxLen --;
                }else{
                    if(res.get(res.size() - 1) % nums[i] == 0){
                        res.add(nums[i]);
                        maxLen--;
                    }
                }
            }
        }
        Collections.reverse(res);
        return res;
    	
    }
}
