package 招银卡中心;

import java.util.Map;
import java.util.Scanner;

/**
 * @author ZOE
 * @date 2019/9/15 21:19
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            long l=scanner.nextLong();
            long r=scanner.nextLong();
            long min=Integer.MAX_VALUE;
            if (l!=r){
                for (long i = l; i <=r-1 ; i++) {
                    for (long j = i+1; j <=r ; j++) {
                        min= Math.min(min,i*j%2019);
                    }
                }
            }
            System.out.println(min);
        }
    }
}
