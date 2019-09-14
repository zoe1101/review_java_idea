package 五八同城;

import java.util.Scanner;

/**
 * @author ZOE
 * @date 2019/9/12 20:53
 */
public class Main3 {

    public static int minPathSum(int[][] m) {
        if(m==null || m.length==0 ||m[0]==null ||m[0].length==0) return 0;
        int row=m.length;
        int col=m[0].length;
        int[][] dp=new int[row][col];
        dp[0][0]=m[0][0];
        for(int i=1;i<row;i++) {
            dp[i][0]=dp[i-1][0]+m[i][0];
        }
        for(int j=1;j<col;j++) {
            dp[0][j]=dp[0][j-1]+m[0][j];
        }
//		O(row*col)
        for(int i=1;i<row;i++) {
            for(int j=1;j<col;j++) {
                dp[i][j]=Math.min(dp[i-1][j], dp[i][j-1])+m[i][j];
            }
        }
        return dp[row-1][col-1];
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        int n=scanner.nextInt();
        int[][] maxtrix=new int[m][n];
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                maxtrix[i][j]=scanner.nextInt();
            }
        }
        System.out.println(minPathSum(maxtrix));

    }
}
