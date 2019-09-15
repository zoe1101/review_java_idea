package 招银卡中心;

import java.util.Scanner;

/**
 * @author ZOE
 * @date 2019/9/15 21:32
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()) {
            int n=scanner.nextInt();
            long[] a=new long[n+1];
            long[] b=new long[n];
            for (int i = 0; i <n+1 ; i++) {
                a[i]=scanner.nextInt();
            }
            for (int i = 0; i <n ; i++) {
                b[i]=scanner.nextInt();
            }
            long sum=0;

            for (int i = 0; i <n; i++) {
                if (a[i]<b[i] && a[i]+a[i+1]>b[i]){
                    sum+=b[i];
                    a[i+1]=a[i]+a[i+1]-b[i];
                }else if (a[i]<b[i] && a[i]+a[i+1]<=b[i]){
                    sum+=a[i]+a[i+1];
                    a[i+1]=0;
                }else{
                    sum+=b[i];
                }
            }
            System.out.println(sum);
        }

    }
}
