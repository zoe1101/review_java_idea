package 拼多多20190901;

import 其他题目.设计有setAll功能的哈希表;
import 进程.线程_Thread;

import java.util.*;

/**
 * @author ZOE
 * @date 2019/9/1 15:38
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt(); //骰子数量
            int[] xis=new int[n]; //每个骰子的可能结果数
            for (int i = 0; i < n; i++) {
                xis[i]=scanner.nextInt();
            }
            float ex=0;

            int maxnum=0;
            int[][] dp=new  int[50][51];
            maxnum=Math.max(maxnum,xis[0]);
            for (int i = 1; i <=xis[0] ; i++) {//初始化第1次的结果
                dp[0][i]=1;
            }
            for (int i = 1; i <n ; i++) {//每个骰子
                maxnum=Math.max(maxnum,xis[i]);
                for (int j = 1; j <=maxnum ; j++) {
                    if (xis[i]>=j){
                    }

                }
            }
            System.out.println(String.format("%.2f",ex));
        }
    }


}
