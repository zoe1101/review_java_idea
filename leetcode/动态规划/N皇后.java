package 动态规划;

import java.util.ArrayList;
import java.util.List;

/*
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

示例:
输入: 4
输出: [
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
解释: 4 皇后问题存在两个不同的解法。
 */
//回溯算法
public class N皇后 {
	List<List<String>>ans = new ArrayList<List<String>>();
	public List<List<String>> solveNQueens(int n) {
		if (n<1) {
			return ans;
		}
        backtrack(0,n,new boolean[n],new int[n]);
        return ans;
    }

    
    private void backtrack(int k,int n,boolean[]flag,int[]temp)
    {
        if(k == n)
        {
            List<String>list = new ArrayList<String>();
            for(int i = 0;i < n;i++)
            {
                String s = "";
                for(int j = 0;j < n;j++)
                    if(temp[i] == j)
                        s += "Q";
                    else
                        s += ".";
                list.add(s);
            }
            ans.add(list);
            return;
        }
        
        for(int i = 0;i < n;i++)
            if(!flag[i]){
                //判断它和之前的皇后是否成对角线。
                //若成对角线，那么显然是不能放的。
                boolean tag = true;
                for(int last = k-1;last >= 0;last--)
                    if(temp[last] - i == k - last || i - temp[last] == k - last)
                    {
                        tag = false;
                        break;
                    }
                
            if(tag)
            {
                flag[i] = true;
                temp[k] = i;
                backtrack(k+1,n,flag,temp);
                flag[i] = false;
            }
                
            }
    }

}
