package 其他;

import java.util.Scanner;

/**和下列题目相同：
 * 今天春天铁子的班上组织了一场春游，在铁子的城市里有n个郊区和m条无向道路，第i条道路连接郊区Ai和Bi，路费是Ci。
 * 经过铁子和顺溜的提议，他们决定去其中的R个郊区玩耍（不考虑玩耍的顺序），但是由于他们的班费紧张，
 * 所以需要找到一条旅游路线使得他们的花费最少，假设他们制定的旅游路线为V1, V2 ,V3 ... VR，
 * 那么他们的总花费为从V1到V2的花费加上V2到V3的花费依次类推，注意从铁子班上到V1的花费和从VR到铁子班上的花费
 * 是不需要考虑的，因为这两段花费由学校报销而且我们也不打算告诉你铁子学校的位置。

 输入描述:
 第一行三个整数n, m, R(2 ≤ n ≤ 200, 1 ≤ m ≤ 5000, 2 ≤ R ≤ min(n, 15))。 //15在此题中为22
 第二行R个整数表示需要去玩耍的郊区编号。
 以下m行每行Ai, Bi, Ci(1 ≤ Ai, Bi ≤ n, Ai ≠ Bi, Ci ≤ 10000)
 保证不存在重边。
 输出描述:
 输出一行表示最小的花费
 示例1

 输入
 4 6 3
 2 3 4
 1 2 4
 2 3 3
 4 3 1
 1 4 1
 4 2 2
 3 1 6
 输出
 3

 * @author ZOE
 * @date 2019/9/6 20:40
 */
public class 途家_2 {
/*
先用floyd求出各城市之间的最短距离
状压dp解决,遍历从去过的地方去没去过的地方
dp[i][j]表示路径状态i,当前在j城市,  从j->k   =>    dp[i][j]->dp[i+(1<<k)][k]
dp[i+(1<<k)][k]等价于dp[i|(1<<k)][k]
*/
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();  //城市数
            int m = scanner.nextInt(); //道路数
            int r = scanner.nextInt(); //需要访问的城市数
            int[] target=new int[r]; //需要访问的城市
            for (int i = 0; i <r ; i++) {
                target[i]=scanner.nextInt();
            }

            int[][] dist=new int[210][210];
            int[][] dp=new int[41000][22];//dp[i][j],i为当前路径状态,j为当前所在的目标城市
            for(int i=0; i<210; i++){
                for (int j = 0; j <210 ; j++) {
                    dist[i][j]=Integer.MAX_VALUE;
                }
            }

            for(int i=0; i<41000; i++){
                for (int j = 0; j <22 ; j++) {
                    dp[i][j]=Integer.MAX_VALUE;
                }
            }

            int x,y,w;

            for(int i=1;i<=m;++i) {
                x = scanner.nextInt();
                y = scanner.nextInt();
                w = scanner.nextInt();
                dist[x][y] = dist[y][x] = w;
            }

            for(int i=1;i<=n;++i)
                for(int j=1;j<=n;++j)
                    for(int k=1;k<=n;++k)
                    {
                        if(i==j||j==k||k==i)continue ;
                        dist[j][k]=Math.min(dist[j][k],dist[j][i]+dist[i][k]);
                    }

            for(int i=0;i<r;++i) {//第一个地方不需要走路
                dp[1 << i][i] = 0;
            }
            for(int i=1;i<(1<<r);++i)
                for(int j=0;j<r;++j)//遍历来过的点
                {
                    if((i&(1<<j))==0)continue ;
                    x=target[j];
                    for(int k=0;k<r;++k)
                    {
                        if((i&(1<<k))!=0) continue ;//来过,不处理
                        y=target[k];
                        dp[i+(1<<k)][k]=Math.min(dp[i+(1<<k)][k],dp[i][j]+dist[x][y]);//从来过的地方
                    }//dp[i+(1<<k)][k]==dp[i|(1<<k)][k]
                }
            int minx=Integer.MAX_VALUE;
            for(int i=0;i<r;++i){
                minx=Math.min(minx,dp[(1<<r)-1][i]);
            }
            System.out.println(minx);

        }
    }
}
