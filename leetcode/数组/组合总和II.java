package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的每个数字在每个组合中只能使用一次。

说明：
所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

 */
//排序去重,回溯剪枝
public class 组合总和II {
	List<List<Integer>> res=new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	if (candidates == null || candidates.length == 0) {
            return res;
        }
    	Arrays.sort(candidates);
    	getCombinationSum(candidates,target,0,0,new ArrayList<>());
        return res;
    }
	private void getCombinationSum(int[] candidates, int target, int start, int cursum, ArrayList<Integer> tmp) {
		if (cursum==target) {
			res.add(new ArrayList<>(tmp));
			return ;
		}
		 //前一个出现的数字
		int removed=-1;
		for (int i = start; i <candidates.length ; i++) {
			if(candidates[i]!=removed && cursum+candidates[i]<=target){
				tmp.add(candidates[i]);
				getCombinationSum(candidates,target,i+1,cursum+candidates[i],tmp);
				tmp.remove(tmp.size()-1); //回溯
                removed=candidates[i];
			}
		}
		
	}
}
