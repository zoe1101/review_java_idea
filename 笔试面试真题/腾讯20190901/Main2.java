package 腾讯20190901;

import java.util.Scanner;

/**
 * @author ZOE
 * @date 2019/9/1 20:16
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int[] arr=new  int[n];
            for (int i = 0; i <n ; i++) {
                arr[i]=scanner.nextInt();
            }
            int[][] sum=new int[n][n]; //i到j的和
            int[][] min=new int[n][n]; //i到j的最小值
            for (int i = 0; i <n ; i++) {
                for (int j = 0; j <n ; j++) {
                    min[i][j]=Integer.MAX_VALUE;
                }
            }
            for (int i = 0; i <n ; i++) {
                for (int j = i; j <n ; j++) {
                    for (int k = i; k <=j ; k++) {
                        sum[i][j]+=arr[k];
                        min[i][j]=Math.min(min[i][j],arr[k]);
                    }
                }
            }
            int max=0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <n ; j++) {
                    max=Math.max(max,min[i][j]*sum[i][j]);
                }
            }
            System.out.println(max);

        }
    }


}
