package 拼多多20190901;

import java.util.Scanner;

/**
 * @author ZOE
 * @date 2019/9/1 15:38
 */
public class Main33 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int[] xis=new int[n];
            for (int i = 0; i < n; i++) {
                xis[i]=scanner.nextInt();
            }
            float ex=0;
            //转折点为n；等差数列
            int chengshu=1;
            int max=0;
            for (int i = 0; i <xis.length ; i++) {
                chengshu*=xis[i];
                max+=xis[i];
            }

            int fenzi=0;
            int diff=n-1;
            int num=1;
            for (int i = 1; i <=max/2 ; i++) {
                fenzi+=num*(n+i-1);
                num+=diff;
            }
            for (int i = max/2; i >=1 ; i--) {
                fenzi+=num*(n+i-1);
                num-=diff;
            }
            ex=fenzi/chengshu;
            System.out.println(String.format("%.2f",ex));
        }
    }


}
