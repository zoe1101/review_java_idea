package 数组与矩阵问题;

import javax.naming.InitialContext;

public class 将正方形矩阵顺时针转动90度 {
	public static void solution(int[][] matrix) {
		int tr=0,tc=0;
		int dr=matrix.length-1,dc=matrix[0].length-1 ;
		while (tr<dr) {
			rotateEdge(matrix, tr++, tc++, dr--, dc--);
		}
	}
	public static void rotateEdge(int[][] matrix,int tr,int tc,int dr,int dc) {
		int times=dr-tr; //需要交换的组数
		for(int i=0;i<times;i++) {
			int temp=matrix[tr][tc+i];
			matrix[tr][tc+i]=matrix[dr-i][tc]; //左列变上行
			matrix[dr-i][tc]=matrix[dr][dc-i];  //下行变左列
			matrix[dr][dc-i]=matrix[tr+i][dc];  //右列变下行
			matrix[tr+i][dc]=temp;    //上行变右列
		}
		
		
	}

	public static void main(String[] args) {
		int[][] matrix= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		solution(matrix);
		for(int[] a:matrix) {
			for(int i:a) {
				System.out.print(i+" ");
			}
		}


	}

}
