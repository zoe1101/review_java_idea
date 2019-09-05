package 图;

/**
 * @author ZOE
 * @date 2019/8/31 18:43
 */

//深度优先遍历实现
public class 岛屿数量 {
    int m = 0, n = 0;
    public int numIslands(char[][] grid) {
        int sum = 0;
        m = grid.length;
        if(m == 0) return 0;
        n = grid[0].length;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(grid[i][j] == '1')//遇到1就把与它相邻的1变为0 count++
                {
                    DFSMaking(grid, i, j);
                    sum++;
                }
        return sum;
    }
    public void DFSMaking(char[][] grid, int i, int j){
        if(i >= m || i < 0 || j >= n || j < 0 || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFSMaking(grid, i + 1, j);
        DFSMaking(grid, i - 1, j);
        DFSMaking(grid, i, j + 1);
        DFSMaking(grid, i, j - 1);
    }
}
