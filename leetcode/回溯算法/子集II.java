package 回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: [1,2,2]
输出:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

 */
public class 子集II {
	 public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        reback(nums, result, new ArrayList<>(), 0);
        return result;
	 }

    // 回溯算法
    public static void reback(int[] nums, List<List<Integer>> result, List<Integer> temp, int start) {
        if (start == nums.length + 1) {
            return;
        }
        result.add(new ArrayList<>(temp));
        int lastUsed = Integer.MIN_VALUE;
        for (int i = start, length = nums.length; i < length; i++) {
            if (nums[i] != lastUsed) {
                temp.add(nums[i]);
                reback(nums, result, temp, i + 1);
                temp.remove(temp.size() - 1);
                lastUsed = nums[i];
            }
        }
    }
}
