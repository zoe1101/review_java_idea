import java.util.Scanner;
/**
 * 如果A是个x行y列的矩阵，B是个y行z列的矩阵，把A和B相乘，其结果将是另一个x行z列的矩阵C。这个矩阵的每个元素是由下面的公式决定的：
 * 原型：
 * voidmatrix_multiply(int *m1,int *m2,int *r, int x, int y, int z);
 * 输入参数：
 *     int *m1：x行y列的矩阵(array1[x][y])
 *     int *m2：y行z列的矩阵(array2[y][z])
 *     int x：矩阵m1的行数
 *     int y：矩阵m1的列数/矩阵m2的行数
 *     int z：矩阵m2的列数

 * 输出参数：
 *
 *     int *r：矩阵m1, m2相乘的结果(array3[x][z])

 * 返回值：
 *
 *         void

 * 输入描述:
 * 输入说明：
 * 1、第一个矩阵的行数
 * 2、第一个矩阵的列数和第二个矩阵的行数
 * 3、第二个矩阵的列数
 * 4、第一个矩阵的值
 * 5、第二个矩阵的值
 *
 * 输出描述:
 * 输出两个矩阵相乘的结果
 * @author ZOE
 * @date 2019/8/21 18:38
 */
public class 矩阵乘法 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            //获取行,列信息
            int row1 = scan.nextInt();
            int column = scan.nextInt();
            int column2 = scan.nextInt();
            int[][] first = new int[row1][column];
            int[][] second = new int[column][column2];
            int[][] temp = new int[row1][column2];
            //将数组存储在数组中
            for(int i=0;i<row1;i++){
                for(int j=0;j<column;j++){
                    first[i][j]=scan.nextInt();
                }
            }
            for(int i=0;i<column;i++){
                for(int j =0;j<column2;j++){
                    second[i][j]=scan.nextInt();
                }
            }
            //对数组进行计算
            for(int i=0;i<row1;i++){
                for(int j=0;j<column2;j++){
                    for(int k= 0;k<column;k++){
                        temp[i][j] += first[i][k]*second[k][j];
                    }
                }
            }
            //按照格式输出
            for(int i=0;i<row1;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<column2;j++){
                    if(j==column2-1){
                        sb.append(temp[i][j]);
                    }else{
                        sb.append(temp[i][j]+" ");
                    }
                }
                System.out.println(sb.toString());
            }
        }
    }
}
