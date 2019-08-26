package src;
/*
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。 
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * 
 *  a b c e 
 *  s f c s 
 *  a d e e 
 */
public class 矩阵中的路径 {
	//需要一个辅助矩阵记录
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {   if(matrix==null || matrix.length==0 || str==null || str.length==0 || 
    	   matrix.length!=rows*cols || rows<=0 || cols<=0 || rows*cols < str.length) {
        	return false ;
    	}
    	boolean[] flag=new boolean[matrix.length];
    	int len=0;
    	for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (hasPathCore(matrix, rows, cols, str, i, j, flag, len)) {
					return true;
				}
			}
		}
    	return false;
    }
    
    public static boolean  hasPathCore(char[] matrix, int rows, int cols, char[] str,
    								   int i, int j, boolean[] visited, int len) {
    	boolean flag=false;

        int index = i * cols + j;
    	if (i>=0 && i<rows && j>=0 && j<cols && !visited[index] && matrix[index]==str[len]) {
			len++;
			visited[index]=true;
			if (len==str.length) {
				return true;
			}
			flag=hasPathCore(matrix, rows, cols, str, i-1, j, visited, len)||  //向上
				 hasPathCore(matrix, rows, cols, str, i+1, j, visited, len)||  //向下
				 hasPathCore(matrix, rows, cols, str, i, j-1, visited, len) || //向左
				 hasPathCore(matrix, rows, cols, str, i, j+1, visited, len);   //向右
			if (!flag) { //如果以当前路径走不通，则回溯到前一个位置进行重走，同时标记当前位置已经走过了
				len--;
				visited[index]=false;
			}
    	}
		return flag;
	}
}
