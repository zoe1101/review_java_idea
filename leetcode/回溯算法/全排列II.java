package 回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import test.test;

/*
给定一个可包含重复数字的序列，返回所有不重复的全排列。

输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

 */
public class 全排列II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        backtrack(res, nums, visited, new ArrayList<Integer>());
        return res;
    }

	private void backtrack(List<List<Integer>> res, int[] nums, int[] visited, ArrayList<Integer> tmp) {
		if (tmp.size()==nums.length) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (visited[i] == 1 || (i > 0 && visited[i - 1] == 0 && nums[i - 1] == nums[i])) {
				continue;
			}
            visited[i] = 1;
            tmp.add(nums[i]);
            backtrack(res, nums, visited, tmp);
            tmp.remove(tmp.size() - 1);//退回一格
            visited[i] = 0;
		}
	}
}
