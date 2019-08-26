package 大数据和空间限制;

//感染过程

public class 岛问题_感染 {
	public static int countIslands(int[][] m) {
		if (m==null || m[0]==null) {
			return 0;
		}
		int row=m.length;
		int col=m[0].length;
		int res=0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(m[i][j]==1) {
					res++;
					infect(m,i,j,row,col);
				}
			}
		}
		return res;
	}

	private static void infect(int[][] m, int i, int j, int row, int col) {
		if (i < 0 || i >= row || j < 0 || j >= col || m[i][j] != 1) {
			return;
		}
		m[i][j]=2;
		infect(m, i, j-1, row, col);
		infect(m, i, j+1, row, col);
		infect(m, i-1, j, row, col);
		infect(m, i+1, j, row, col);
	}
	public static void main(String[] args) {
		int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				        { 0, 1, 1, 1, 0, 1, 1, 1, 0 }, 
				        { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
				        { 0, 1, 1, 0, 0, 0, 0, 0, 0 }, 
				        { 0, 0, 0, 0, 0, 1, 1, 0, 0 }, 
				        { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
				        { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
		System.out.println(countIslands(m1));

		int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
						{ 0, 1, 1, 1, 1, 1, 1, 1, 0 }, 
						{ 0, 1, 1, 1, 0, 0, 0, 1, 0 },
						{ 0, 1, 1, 0, 0, 0, 1, 1, 0 }, 
						{ 0, 0, 0, 0, 0, 1, 1, 0, 0 }, 
						{ 0, 0, 0, 0, 1, 1, 1, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
		System.out.println(countIslands(m2));

	}
}
