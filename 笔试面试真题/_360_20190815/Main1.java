package _360_20190815;

import java.util.Scanner;

/**
 * 求n行m列的的立体图形的表面积
 * @author ZOE
 * @date 2019/8/15 19:47
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt(); //n行
        int m=scanner.nextInt(); //m列
        int[][] A=new int[n][m];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                A[i][j]=scanner.nextInt(); //第i行j列放多少个正方体组成的矩形条
            }
        }
        int sum=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j]>0){ //防止0的情况
                    sum+=(6*A[i][j]-(A[i][j]-1)*2);
                    if (j<m-1){
                        sum-=A[i][j]>=A[i][j+1]?A[i][j+1]*2:A[i][j]*2;
                    }
                    if (i<n-1){
                        sum-=A[i][j]>=A[i+1][j]?A[i+1][j]*2:A[i][j]*2;
                    }
                }
            }
        }
        System.out.println(sum);
    }


}
