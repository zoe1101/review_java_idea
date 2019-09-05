package 并查集;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 * 你可以假设网格的四个边均被水包围。
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3

 * @author ZOE
 * @date 2019/8/31 18:30
 */
public class 岛屿数量 {
    public static int numIslands(char[][] grid) {
        if (grid==null ||  grid.length==0 || grid[0].length==0){
            return 0;
        }

        int count=0;
        int m=grid.length;
        int n=grid[0].length;
        int[] root=new int[m*n];
        for (int i = 0; i < m*n; i++) {//创建初始并查集
            root[i]=i;
        }

        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                int t1=i*m+j;
                int t2=t1+1; //t1右侧
                int t3=t1+m; //t1下方
                if (j+1<n && grid[i][j]=='1' && grid[i][j+1]=='1'){
                    merge(root, t1, t2);
                }
                if (i+1<m && grid[i][j]=='1' && grid[i+1][j]=='1'){
                    merge(root, t1, t3);
                }
            }
        }
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                if (root[i*m+j]==i*m+j && grid[i][j]=='1'){
                    count++;
                }
            }
        }
        return count;

    }

    private static int[] merge(int[] root, int x, int y) {
        int xf=findRoot(root,x);
        int yf=findRoot(root,y);
        if (xf!=yf){
            root[yf]=xf;
        }
        return root;
    }

    private static int findRoot(int[] root, int x) {
        while (x!=root[x]){
            x=root[x];
        }
        return x;
    }

    public static void main(String[] args) {
        char[][] grid={{'1','1','0','0','0'},
                        {'1','1','0','0','0'},
                        {'0','0','1','0','0'},
                        {'0','0','0','1','1'}};
        System.out.println(numIslands(grid));

    }
}
