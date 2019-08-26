package 校招真题在线编程;
/*
小多想在美化一下自己的庄园。他的庄园毗邻一条小河，他希望在河边种一排树，共 M 棵。小多采购了 N 个品种的树，每个品种的数量是 Ai (树的总数量恰好为 M)。但是他希望任意两棵相邻的树不是同一品种的。小多请你帮忙设计一种满足要求的种树方案。

输入描述:
第一行包含一个正整数 N，表示树的品种数量。
第二行包含 N 个正整数，第 i (1 <= i <= N) 个数表示第 i 个品种的树的数量。
数据范围：
1 <= N <= 1000
1 <= M <= 2000

输出描述:
输出一行，包含 M 个正整数，分别表示第 i 棵树的品种编号 (品种编号从1到 N)。
若存在多种可行方案，则输出字典序最小的方案。若不存在满足条件的方案，则输出"-"。

输入例子1:
3
4 2 1

输出例子1:
1 2 1 2 1 3 1
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
使用搜索来做，但纯粹使用搜索的话通过率为90%，有一个点会超时，所以需要剪枝，
一个简单的剪枝思路是比较当前未种的树和坑的大小关系！
具体的剪枝思路是每次搜索之前判断当前剩余的坑位left和任意品种的树之间的关系:

1) 如果left为偶数，那么只要tree[i] > left / 2，就表示肯定种不了
2) 如果left为奇数，那么只要tree[i] > (left + 1) / 2，就表示肯定种不了
这里有一个小技巧：left为偶数时，left/2 和(left + 1)/2的值是相等的，
所以可以统一使用tree[i] > (left+1)/2的关系来做剪枝优化！
 */
public class 种树_拼多多 {
	static int n;//树的品种
	static int m;//共有多少棵树
	static int[] tree;//每种树的数量
	static List<String> ans;
		 
    static boolean check(int left) {
        for (int i = 1; i <= n; i++) {
            if (tree[i] > (left + 1) / 2) return false;
        }
        return true;
    }
 
    static boolean dfs(int idx) {
        if (!check(m - idx)) return false;
        if (idx == m) {
            return true;
        } else {
            for (int i = 1; i <= n; i++) {
                if (idx == 0 || (tree[i] != 0 && i != Integer.valueOf(ans.get(idx - 1)))) {
                    tree[i]--;
                    ans.add(i + "");
                    if (dfs(idx + 1)) return true;
                    ans.remove(ans.size() - 1);
                    tree[i]++;
                }
            }
        }
        return false;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            n = sc.nextInt();
            tree = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                tree[i] = sc.nextInt();
                m += tree[i];
            }
            ans = new ArrayList<>();
            if (dfs(0)) {
                System.out.println(String.join(" ", ans));
            } else {
                System.out.println("-");
            }
        }
    }
}
