
import java.util.*;
/**
 * 王强今天很开心，公司发给N元的年终奖。王强决定把年终奖用于购物，他把想买的物品分为两类：主件与附件，附件是从属于某个主件的，下表就是一些主件与附件的例子：
 * 主件	附件
 * 电脑	打印机，扫描仪
 * 书柜	图书
 * 书桌	台灯，文具
 * 工作椅	无
 * 如果要买归类为附件的物品，必须先买该附件所属的主件。每个主件可以有 0 个、 1 个或 2 个附件。附件不再有从属于自己的附件。王强想买的东西很多，为了不超出预算，他把每件物品规定了一个重要度，分为 5 等：用整数 1 ~ 5 表示，第 5 等最重要。他还从因特网上查到了每件物品的价格（都是 10 元的整数倍）。他希望在不超过 N 元（可以等于 N 元）的前提下，使每件物品的价格与重要度的乘积的总和最大。
 *     设第 j 件物品的价格为 v[j] ，重要度为 w[j] ，共选中了 k 件物品，编号依次为 j 1 ， j 2 ，……， j k ，则所求的总和为：
 * v[j 1 ]*w[j 1 ]+v[j 2 ]*w[j 2 ]+ … +v[j k ]*w[j k ] 。（其中 * 为乘号）
 *     请你帮助王强设计一个满足要求的购物单。

 * 输入描述:
 * 输入的第 1 行，为两个正整数，用一个空格隔开：N m
 * （其中 N （ <32000 ）表示总钱数， m （ <60 ）为希望购买物品的个数。）
 * 从第 2 行到第 m+1 行，第 j 行给出了编号为 j-1 的物品的基本数据，每行有 3 个非负整数 v p q
 * （其中 v 表示该物品的价格（ v<10000 ）， p 表示该物品的重要度（ 1 ~ 5 ）， q 表示该物品是主件还是附件。如果 q=0 ，表示该物品为主件，如果 q>0 ，表示该物品为附件， q 是所属主件的编号）
 *
 * 输出描述:
 *  输出文件只有一个正整数，为不超过总钱数的物品的价格与重要度乘积的总和的最大值（ <200000 ）。
 * 示例1
 * 输入
 * 1000 5 800 2 0 400 5 1 300 5 1 400 3 0 500 2 0
 * 输出
 * 2200
 * @author ZOE
 * @date 2019/8/21 13:35
 */
public class 购物单 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()) {
            int n=scanner.nextInt(); //N （ <32000 ）表示总钱数
            int m=scanner.nextInt();//m （ <60 ）为希望购买物品的个数。
            int[] v=new int[m+1];
            int[] p=new int[m+1];
            int[] q=new int[m+1];
            for (int i=1;i<=m;i++){
                v[i]=scanner.nextInt();//v 表示该物品的价格（ v<10000 ）
                p[i]=scanner.nextInt()* v[i]; //价格与重要度的乘积,即价值,  scanner.nextInt() 表示该物品的重要度（ 1 ~ 5 ）
                q[i]=scanner.nextInt(); //q 表示该物品是主件还是附件。如果 q=0 ，表示该物品为主件，如果 q>0 ，表示该物品为附件， q 是所属主件的编号）
            }
            System.out.println(getMaxValue(n,m,v,p,q));

        }

    }

    private static int getMaxValue(int n, int m, int[] v, int[] p, int[] q) {
        int[][] dp=new int[m+1][n+1];  //dp[i][j]:买i件商品需要j元钱
        for (int i=1; i<=m; i++){
            for (int j = 1; j <=n ; j++) {
                if (q[i]==0){// 第i件商品为 主件
                    if (v[i]<=j){// 用j这么多钱去买 i 件商品 可以获得最大价值
                        dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-v[i]]+p[i]);
                    }
                }else {// // 第i件商品为 附件
                    if (v[i]+v[q[i]]<=j){//附件的话 加上主件一起算
                        dp[i][j]=Math.max(dp[i-1][j],dp[i - 1][j- v[i]]+ p[i]);
                    }
                }
            }
        }
        return dp[m][n];
    }
}
