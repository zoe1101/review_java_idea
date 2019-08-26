import java.util.*;
/**
 * @author ZOE
 * @date 2019/8/21 18:24
 */
public class 求int型正整数在内存中存储时1的个数 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()) {
            int n=scanner.nextInt();
            int count=0;
            while (n!=0){
                if (n%2==1){
                    count++;
                }
                n/=2;
            }
            System.out.println(count);

        }

    }
}
