package 拼多多20190901;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ZOE
 * @date 2019/9/1 15:37
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            int k=scanner.nextInt();
            if (k<1 || k>m*n){
                return;
            }
            int[][] arr=new int[m][n];
            int[] sortarr=new int[m*n];
            for (int i = 1; i <=m ; i++) {
                for (int j = 1; j <=n ; j++) {
                    arr[i-1][j-1]=i*j;
                    sortarr[i*(m-1)+j-1]=arr[i-1][j-1];
                }
            }
            Arrays.sort(sortarr);
            System.out.println(sortarr[m*n-k]);
        }
    }
}
