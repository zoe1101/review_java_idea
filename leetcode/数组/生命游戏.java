package 数组;

import java.util.Arrays;

import javax.swing.border.Border;

/*
根据百度百科，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在1970年发明的细胞自动机。
给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。
每个细胞具有一个初始状态 live（1）即为活细胞， 或 dead（0）即为死细胞。
每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
根据当前状态，写一个函数来计算面板上细胞的下一个（一次更新后的）状态。下一个状态是
通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。

示例:

输入: 
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
输出: 
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]

 */
public class 生命游戏 {
	int[][] dir = {
            {-1,-1},    // 左上
            {-1,0},     // 正上
            {-1,1},     // 右上
            {0,-1},     // 左边
            {0,1},      // 右边
            {1,-1},     // 左下
            {1,0},      // 正下
            {1,1}       // 右下
    };
    public  void gameOfLife(int[][] board) {
    	int row = board.length;
        int col = board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                check(board,i,j);
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]==-2){
                    board[i][j] = 0;
                }else if(board[i][j]==2){
                    board[i][j] = 1;
                }
            }
        }
    	
    }
    //判断board处的细胞是否处于存活状态
    public boolean isLive(int[][] borad,int a,int b){
        if(borad[a][b]==1 || borad[a][b]==-2)
            return true;
        else
            return false;
    }
    //更新在(a,b)格子的细胞
    public void check(int[][] board,int a,int b){
        int row = board.length;
        int col = board[0].length;

        // 记录该细胞周围的活细胞数量
        int count = 0;

        for(int i=0;i<dir.length;i++){
            int nextX = a+dir[i][0];
            int nextY = b+dir[i][1];
            if(nextX>=0 && nextX<row && nextY>=0 && nextY<col){
                if(isLive(board,nextX,nextY))
                    count++;
            }
        }

        if(isLive(board,a,b)){
            // 如果当前格子是活细胞
            if(count<2 || count>3)
                // 活细胞死亡
                board[a][b] = -2;
        }else {
            // 如果当前格子是死细胞
            if(count==3)
                // 死细胞复活
                board[a][b] = 2;
        }
    }
}
