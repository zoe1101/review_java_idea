package 递归与动态规划;
/*
 * 有一头母牛，它每年生一头小母牛。每头小母牛3年成熟后也可以每年一头小母牛。请编程实现在第n年的时候，共有多少头母牛？
 * 第一年有一头成熟的母牛
 */
public class 斐波那契数列_n年后牛的数量 {
//	暴力法
	public static int solution1(int n) {
		if(n<1) return 0;
		if(n==1 || n==2 || n==3) {
			return n;
		}
		return solution1(n-1)+solution1(n-3);
	}
//先计算出每一年的母牛数量，得到n年后的母牛数量
	public static int solution2(int n) {
		if(n<1) return 0;
		if(n==1 || n==2 || n==3) {
			return n;
		}
		int res=3;
		int pre=2;
		int prepre=1;
		int tmp1=0;
		int tmp2=0;
		for(int i=4;i<=n;i++) {
			tmp1=res;
			tmp2=pre;
			res=res+prepre;
			pre=tmp1;
			prepre=tmp2;
		}
		return res;
	}
	
	public static int solution3(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2 || n == 3) {
			return n;
		}
		int[][] base = { { 1, 1, 0 }, { 0, 0, 1 }, { 1, 0, 0 } };
		int[][] res = matrixPower(base, n - 3);
		return 3 * res[0][0] + 2 * res[1][0] + res[2][0];
	}
//	m的p次方
	public static int[][] matrixPower(int[][] matrix,int p) {
		int[][] res=new int[matrix.length][matrix[0].length];
		//先把结果矩阵设为单位矩阵
		for(int i=0;i<matrix.length;i++) {
			res[i][i]=1;
		}
		int[][] temp=matrix;
		for(;p!=0;p>>=1) {
			if((p&1)!=0) {
				res=multMatrix(res, temp);
			}
			temp=multMatrix(temp, temp);
		}
		return res;
	}
	
	public static int[][] multMatrix(int[][] m1,int[][] m2) {
		int[][] res=new int[m1.length][m2[0].length];
		for(int i=0;i<m1.length;i++) {
			for(int j=0;i<m2[0].length;j++) {
				for(int k=0;k<m2.length;k++) {
					res[i][j]+=m1[i][k]*m2[k][j];
				}
			}
		}
		return res;
	}


	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
