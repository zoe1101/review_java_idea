package 数组与矩阵问题;

public class 之字形打印矩阵 {
	public static void solution(int[][] matrix) {
		int tr=0,tc=0,dr=0,dc=0;
		int endr=matrix.length-1;
		int endc=matrix[0].length-1;
		boolean fromUp=false;  //是否是从左上往右下,用于判定打印方向
		while (tr<=endr) {
			printLevel(matrix, tr, tc, dr, dc, fromUp);
			tr=tc==endc?tr+1:tr; //
			tc=tc==endc?tc:tc+1;
			dc=dr==endr?dc+1:dc;
			dr=dr==endr?dr:dr+1;
			fromUp=!fromUp;
		}
		System.out.println();
		
	}
	public static void printLevel(int[][] matrix,int tr,int tc,int dr,int dc,boolean fromUp) {
		if(fromUp) {//从左上往右下方向打印
			while(tr<=dr) {
				System.out.print(matrix[tr++][tc--]+" ");
			}
		}else {//从右下往左上方向打印
			while(dr>=tr) {
				System.out.print(matrix[dr--][dc++]+" ");
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix= {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		solution(matrix);

	}

}
