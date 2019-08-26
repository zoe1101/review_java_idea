package src;

import java.util.ArrayList;

/*
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。例如：如果输入如下矩阵： 
1， 2， 3， 4 
5， 6， 7， 8 
9， 10，11，12 
13，14，15，16 
则依次打印出数字1，2，3，4，8，12，16，15，14，13，9，5，6，7，11，10.
 */
//1.分析发现，我们可以通过循环的每一次打印矩阵中的一个圈（从外到内）。 
//2.接下来分析循环结束的条件：假设这个矩阵的行数是rows，列数是columns。
//打印第一圈的左上角的坐标是(0,0),第二圈的左上角的坐标是(1,1),依次类推。
//我们注意到，左上角的行坐标和列坐标总是相同的，于是可以在矩阵中选取左上角为(start,start)的一圈作为我们分析的目标。 
//3.条件是：columns > startX × 2 并且 rows > startY × 2

public class 顺时针打印矩阵 {
	public static ArrayList<Integer> printMatrix(int[][] matrix) {
	       ArrayList<Integer> list=new ArrayList<Integer>();
	       int rows=matrix.length;
	       int cols=matrix[0].length;
	       if(matrix==null ||cols<=0 ||rows<=0) {
	    	   return null;
	       }
	       int start=0;
	       while (rows>start*2 && cols>start*2 ) {
	    	   printMatrixInCircle(list,matrix,rows,cols,start);
	    	   start++;	
	       }
	       return list;
    }
	public static void printMatrixInCircle(ArrayList<Integer> list,int[][] matrix,
			int rows,int cols,int start) {
		int endY=cols-start-1;//列结束位置
		int endX=rows-start-1; //行结束位置
		
		for(int i=start;i<=endY;i++) { //从左往右打印上行
			list.add(matrix[start][i]);
		}
		if(start<=endY)
			for(int i=start+1;i<=endX;i++) { //从上到下打印右列
				list.add(matrix[i][endY]);
		}
		
		if(start<endX &&start<endY) {
			for(int i=endY-1;i>=start;i--) {//从右往左打印下行
				list.add(matrix[endX][i]);
			}
		}
		if(start<endY && start<endX-1) {
			for(int i=endX-1;i>start;i--) {//从下往上打印左列
				list.add(matrix[i][start]);
			}
		}
	}
	
	public static void main(String[] args) {
	    int[][] matrix1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}}; //多行多列
	    int[][] matrix2 = {{1,2,3,4}}; //单行多列
	    int[][] matrix3 = {{1},{5},{9}}; //多行单列
	    int[][] matrix4 = {{1}}; //单元数
	    int[][] matrix5 = {{}}; //空矩阵
	    int[][] matrix6 = null; //null
	    System.out.println(printMatrix(matrix1));
	    System.out.println(printMatrix(matrix2));
	    System.out.println(printMatrix(matrix3));

	}

}
