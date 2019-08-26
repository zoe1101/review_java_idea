package 数组与矩阵问题;

public class 转圈打印矩阵 {
	public static void solution(int[][] matrix) {
		int tr=0,tc=0; //用于指代左上角(tr,tc)
		int dr=matrix.length-1,dc=matrix[0].length-1; //用于指代右下角(dr,dc)
		while (tr<=dr && tc<=dc) {
			printEdge(matrix, tr++, tc++, dr--, dc--);
		}
	}
	
	public static void printEdge(int[][] matrix,int tr,int tc,int dr,int dc) {
		if(tr==dr) {//矩阵只有一行
			for(int i=tc;i<=dc;i++) {
				System.out.print(matrix[tr][i]+" ");
			}
		}else if(tc==dc) { //矩阵只有一列
			for(int i=tr;i<=dr;i++) {
				System.out.print(matrix[i][tc]+" ");
			}
		}else {//一般情况
			for(int i=tc;i<dc;i++) { //打印上行
				System.out.print(matrix[tr][i]+" ");
			}
			
			for(int i=tr;i<dr;i++) { //打印右列
				System.out.print(matrix[i][dc]+" ");
			}
			
			for(int i=dc;i>tc;i--) { //打印下行
				System.out.print(matrix[dr][i]+" ");
			}
			
			for(int i=dr;i>tr;i--) { //打印左列
				System.out.print(matrix[i][tc]+" ");
			}
		}
	}
		

	public static void main(String[] args) {
		int[][] matrix= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		solution(matrix);
	}
}
