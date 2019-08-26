package 数组与矩阵问题;

public class 边界都是1的最大正方形大小 {
	public static int getMaxSize(int[][] m) {
		int row=m.length;
		int col=m[0].length;
		int[][] right=new int[row][col]; //right[i][j]：从(i,j)出发向右走连续是1的个数
		int[][] down=new int[row][col]; //down[i][j]：从(i,j)出发向下走连续是1的个数
		setBorderMap(m, right, down); //计算某一个位置向右和向下时1连续出现的个数
		for (int size =Math.min(row, col); size>0; size--) { //从大到小遍历是否存在边长为size的正方形
			if (hasSizeOfBorder(size, right, down)) { //存在就返回size
				return size;
			}
		}
		return 0;
		
	}
	
	public static void setBorderMap(int[][] m,int[][] right,int[][] down) {
		int row=m.length;
		int col=m[0].length;
//		从矩阵的右下角进行计算
		//右下角的元素
		if (m[row-1][col-1]==1) {
			right[row-1][col-1]=1;
			down[row-1][col-1]=1;
		}
		//最后一列
		for (int i = row-2; i >=0; i--) { 
			if (m[i][col-1]==1) {
				right[i][col-1]=1;
				down[i][col-1]=down[i+1][col-1]+1;
			}
		}
		//最后一行
		for (int i = col-2; i>=0; i--) { 
			if (m[row-1][i]==1) {
				down[row-1][i]=1;
				right[row-1][i]=right[row-1][i+1]+1;
			}
		}
		//其他位置
		for (int i = row-2; i >=0; i--) {
			for (int j = col-2; j >=0; j--) {
				if (m[i][j]==1) {
					right[i][j]=right[i][j+1]+1;
					down[i][j]=down[i+1][j]+1;
				}
			}
		}
	}
	public static boolean hasSizeOfBorder(int size,int[][] right,int[][] down) {
		//以(i,j)为起点
		//right.length-size+1:以size为边长向下（行上）有多少个位置需要检验
		//right[0].length-size+1:以size为边长向右（列上）有多少个位置需要检验
		for (int i = 0; i < right.length-size+1; i++) { 
			for (int j = 0; j < right[0].length-size+1; j++) {
				//检查是否可以构成正方形
				if (right[i][j]>=size && down[i][j]>=size//左上角(i,j)位置向右和向下满足要求
					&& right[i+size-1][j]>=size //左下角(i+size-1,j)位置向右满足要求
					&& down[i][j+size-1]>=size)  //右上角(i,j+size-1)位置向下满足要求
				{
					return true;
				}
			}
		}
		return false;
	}
	public static int[][] generateRandom01Matrix(int rowSize, int colSize) {
		int[][] res = new int[rowSize][colSize];
		for (int i = 0; i != rowSize; i++) {
			for (int j = 0; j != colSize; j++) {
				res[i][j] = (int) (Math.random() * 2);
			}
		}
		return res;
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i != matrix.length; i++) {
			for (int j = 0; j != matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] matrix = generateRandom01Matrix(7, 8);
		printMatrix(matrix);
		System.out.println(getMaxSize(matrix));
	}

}
