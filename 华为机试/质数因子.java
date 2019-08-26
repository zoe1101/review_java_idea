import java.util.*;
/**
 * @author ZOE
 * @date 2019/8/21 18:20
 */
public class 质数因子 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()) {
            long num = scanner.nextLong();
            canculate(num);
        }

    }
    public static void canculate(long num){
        for (long i=2;i<=num;i++){
            if (num%i==0){
                System.out.print(i+" ");
                canculate(num/i);
                return ;
            }
        }
    }
}
