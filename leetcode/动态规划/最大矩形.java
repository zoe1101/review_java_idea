package 动态规划;

import java.util.Stack;

import test.test;

/*
给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。

输入:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
输出: 6

 */
public class 最大矩形 {
	//对每一行都求出每个元素对应的高度，这个高度就是对应的连续1的长度，
	//然后对每一行都更新一次最大矩形面积。
    public int maximalRectangle(char[][] matrix) {
    	if (matrix==null || matrix.length==0 || matrix[0]==null || matrix[0].length==0) {
			return 0;
		}
        int row=matrix.length;
        int col=matrix[0].length;
        int[][] height=new int[row][col]; //用于存放当前的高
        for (int j = 0; j < col; j++) {//第一层的高度是当前的数字,最高为1
        	height[0][j]=matrix[0][j]-'0';
		}
      //循环所有一行一行的向下来计算每行的高度（一行一行的截取矩形的高度）
        for (int i = 1; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j]=='0') { //如果为零说明断开不能与上一层相连
					height[i][j]=0;
				}else { //不为零则进行计算加上本身的1
					height[i][j]=height[i-1][j]+1;
				}
				
			}
		}
        
        int res=0;
     // 每一行都可以看做是一个底 ,一行一行的算面积（知道高了,找到相应最大的宽就好了）
        for (int i = 0; i < row; i++) {
			res=Math.max(res, maximalRectangle(height[i]));
		}
        return res;
        
    }

	private int maximalRectangle(int[] height) {
		int n=height.length;
		int[] newheight=new int[n+1];
		for (int i = 0; i < n; i++) {
			newheight[i]=height[i];
		}
		newheight[n]=0;
		int res=0;
		Stack<Integer> stack=new Stack<Integer>();
		for (int i = 0; i <= n; i++) {
			while(!stack.isEmpty() && newheight[stack.peek()]>=newheight[i]) {
				int maxheight=stack.pop();
				int left=stack.isEmpty()?-1:stack.peek();
				res=Math.max(res, (i-left-1)*newheight[maxheight]);
			}
			stack.push(i);
		}
		return res;
	}
}
