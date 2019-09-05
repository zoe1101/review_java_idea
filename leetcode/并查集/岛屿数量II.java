package 并查集;

import java.util.ArrayList;
import java.util.Arrays;

/**
 A 2d grid map of m rows and n columns is initially filled with water.
 We may perform an addLand operation which turns the water at position (row, col) into a land.
 Given a list of positions to operate, count the number of islands after each addLand operation.
 An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 You may assume all four edges of the grid are all surrounded by water.
(m行n列的矩阵，初始化为0，然后在（i,j）位置进行加操作，计算每一步加操作后得到的小岛数量)
 Example:

 Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].

 *
 * Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).
 *
 * 0 0 0
 * 0 0 0
 * 0 0 0
 * Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
 *
 * 1 0 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 * Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
 *
 * 1 1 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 * Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
 *
 * 1 1 0
 * 0 0 1   Number of islands = 2
 * 0 0 0
 * Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
 *
 * 1 1 0
 * 0 0 1   Number of islands = 3
 * 0 1 0
 * We return the result as an array: [1, 1, 2, 3]

 * @author ZOE
 * @date 2019/8/31 16:40
 */

/*
为每一个位置初始化一个父结点, 因为是一个二维数组, 比较方便的方式是二维转化为一维. 也就是每一个位置的父结点设置(x*n+y),
 其中(x, y)为其位置坐标. 然后每次插入一个新元素的时候查上下左右地图是不是有相邻的陆地,
 当然在此之前还需要建立一张二维的地图用来维护地图的状态.
这样如果新添加的一个点的时候默认小岛数量增加1,
但是如果这个新添加的陆地有相邻的陆地, 就将其合并成一块陆地, 并且小岛数量-1.
因为他有上下左右四个方向, 所以有可能当前点连接了之前并不相连的小岛, 在当前结点碰到第一个相邻的陆地的时候,
他被并入了那块陆地, 如果之后他碰到了另一个小岛和他属于不同的小岛, 则还要合并两个小岛, 又会让小岛数量-1. 

 */
public class 岛屿数量II {
    public static int[] numIslands2(int m,int n, int[][] positions) {
        int[][] map=new int[m][n]; //用来维护地图的状态
        int[] root=new int[m*n]; //记录每个位置对应的根节点
        int num=0;
        ArrayList<Integer> res=new ArrayList<>();
        for (int i = 0; i < m*n; i++) {
            root[i]=i;
        }
        for (int[] pos:positions) {
            int[][] direction={{1,0},{-1,0},{0,1},{0,-1}}; //方向矩阵
            for (int[] dir:direction) {
                int x=pos[0];
                int y=pos[1];
                int px =x+dir[0];
                int py =y+dir[1];
                if(px<0 || px>=m || py<0 || py>=n || map[px][py]==0) {
                    continue;
                }

                int par1=finRoot(root,x*n + y);//当前节点的根节点
                int par2=finRoot(root,px*n + py);//相邻节点的根节点
                if(par1 != par2) { //合并
                    root[par2] = par1;
                    num--;
                }
            }
            map[pos[0]][pos[1]]=1;
            res.add(++num);
        }
        int[] arr=new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i]=res.get(i);
        }
        return arr;

    }
    private static int finRoot(int[] root, int x) {
        while (x!=root[x]){
            x=root[x];
        }
        return x;
    }
    public static void main(String[] args) {
        int[][] positions={{0,0},{0,1},{1,2},{2,1}};
        System.out.println(Arrays.toString(numIslands2(3,3,positions)));
    }
}
