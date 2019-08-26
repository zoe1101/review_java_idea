package 回溯算法;

import java.util.ArrayList;
import java.util.List;

/*
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:
输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */

// 组合问题
public class 子集 {
    public List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> result=new ArrayList<List<Integer>>();
    	result.add(new ArrayList<>());
    	for(int n : nums){
            int size = result.size();
            for(int i=0; i<size; i++){
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(n);
                result.add(subset);
            }
        }
        return result;
    }
    
}
