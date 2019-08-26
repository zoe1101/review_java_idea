package 数组;

import java.util.HashMap;

/*
给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，
并且 i 和 j 的差的绝对值最大为 k。
输入: nums = [1,2,3,1], k = 3
输出: true

 */
public class 存在重复元素II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

    	HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                if(Math.abs(i-map.get(nums[i]))<=k){
                    return true;
                }
            }
            map.put(nums[i],i);
		}
        return false;    
    }
}
