package 并查集;

/**
 * 给定编号从 0 到 n-1 的 n 个节点和一个无向边列表（每条边都是一对节点），请编写一个函数来计算无向图中连通分量的数目。
 *
 * 输入:
 * n = 5
 *  和
 * edges = [[0, 1], [1, 2], [3, 4]]
 *
 *
 *      0          3
 *      |          |
 *      1 --- 2    4
 *
 * 输出: 2
 注意:你可以假设在 edges 中不会出现重复的边。而且由于所以的边都是无向边，[0, 1] 与 [1, 0]  相同，所以它们不会同时在 edges 中出现。
 * @author ZOE
 * @date 2019/8/31 16:22
 */
public class 无向图中连通分量的数目 {
//    使用并查集来标记图的连通分量。
    public static int countComponents(int n,int[][] edges) {
        int count=n;
        int[] root=new int[n];
        for (int i = 0; i <n ; i++) {
            root[i]=i;
        }
        for (int i = 0; i <edges.length ; i++) {
            int xf=findRoot(root,edges[i][0]);
            int yf=findRoot(root,edges[i][1]);
            if (xf!=yf){
                root[yf]=xf; //把edges[i][1]所属集合接到edges[i][0]所属集合的根节点上
                count--;
            }
        }
        return count;
    }

    private static int findRoot(int[] root, int x) {
        while (x!=root[x]){
            x=root[x];
        }
        return x;
    }

    public static void main(String[] args) {
        int n=5;
        int[][] edges={{0,1},{1,2},{3,4}};
        System.out.println(countComponents(n,edges));
    }
}
