package 回溯算法;

import java.util.ArrayList;
import java.util.List;

/*
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。


输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

 */
public class 组合 {
	 List<List<Integer>> res = new ArrayList<List<Integer>>();
	 public List<List<Integer>> combine(int n, int k) {
		 if(n <= 0 || k <= 0 || k > n) {
			 return res;
		 }
		 List<Integer> tmp = new ArrayList<>();
		 generationList(n, k, 1, tmp);
        return res;
	        
    }
	private void generationList(int n, int k, int start, List<Integer> list) {
		if(list.size() == k){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = start; i <= n - (k  - list.size()) + 1; i++){
            list.add(i);
            generationList(n, k, i + 1, list);
            list.remove(list.size() - 1);
        }
        return;
	}
}
