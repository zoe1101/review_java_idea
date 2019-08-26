package 商汤科技_测试_20190819;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode-996. 正方形数组的数目
 * 给定一个非负整数数组 A，如果该数组每对相邻元素之和是一个完全平方数，则称这一数组为正方形数组。
 * 返回 A 的正方形排列的数目。两个排列 A1 和 A2 不同的充要条件是存在某个索引 i，使得 A1[i] != A2[i]。
 *
 * 示例 1：
 * 输入：[1,17,8]
 * 输出：2
 * 解释：
 * [1,8,17] 和 [17,8,1] 都是有效的排列。
 *
 * 示例 2：
 * 输入：[2,2,2]
 * 输出：1
 *
 * 提示：
 * 1 <= A.length <= 12
 * 0 <= A[i] <= 1e9
 * @author ZOE
 * @date 2019/8/19 19:57
 */
public class Main3 {
    /*
    构造一张图，包含所有的边 ii 到 jj ，如果满足 A[i] + A[j] 是一个完全平方数。
    我们的目标就是求这张图的所有哈密顿路径，即经过图中所有点仅一次的路径。

实现算法：
我们使用 count 记录对于每一种值还有多少个节点等待被访问，与一个变量 todo 记录还剩多少个节点等待被访问。
对于每一个节点，我们可以访问它的所有邻居节点（从数值的角度来看，从而大大减少复杂度）。

对于每一个节点，我们可以访问它的所有邻居节点（从数值的角度来看，从而大大减少复杂度）。
     */
    public static Map<Integer,Integer> count;
    public static Map<Integer,List<Integer>> graph;
    public static int numSquarefulPerms(int[] arr) {
        int n=arr.length;
        count=new HashMap<>();
        graph=new HashMap<>();
        // count.get(v) : 数组 arr 中值为 v 的节点数量
        for (int x:arr){
            count.put(x,count.getOrDefault(x,0)+1);
        }
        // graph.get(v) : 在 A 中的值 w 满足 v + w 是完全平方数
        //                (ie., "vw" is an edge)
        for (int x: count.keySet()) {
            graph.put(x, new ArrayList());
        }
        for (int x:count.keySet()){
            for (int y:count.keySet()){
                int r=(int) (Math.sqrt(x+y)+0.5);
                if (r*r == x+y){
                    graph.get(x).add(y);
                }
            }
        }
        // 增加从 x 开始的可行路径数量
        int ans = 0;
        for (int x: count.keySet())
            ans += dfs(x, n - 1);
        return ans;

    }

    private static int dfs(int x, int todo) {
        count.put(x, count.get(x) - 1);
        int ans = 1;
        if (todo != 0) {
            ans = 0;
            for (int y: graph.get(x)) if (count.get(y) != 0) {
                ans += dfs(y, todo - 1);
            }
        }
        count.put(x, count.get(x) + 1);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr={8,8,8};
        System.out.println(numSquarefulPerms(arr));
    }
}
