package 数组与矩阵问题;

public class 在行列都排好的矩阵中找到指定数 {
	//矩阵行有序，列也有序
	public static boolean isContains(int[][] matrix,int k) {
		//从右上角开始查找
		int row=0;
		int col=matrix[0].length-1;
		while (row<matrix.length && col>=0) {
			if (matrix[row][col]==k) { //找到了
				return true;
			}else if (matrix[row][col]>k) { //在matrix[row][col]的前一列继续找
				col--;
			}else { //k大于matrix[row][col]：在matrix[row][col]的下一行继续找
				row++;
			}
		}
		return false;
	}

}
