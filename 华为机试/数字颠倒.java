
import java.util.*;
/**
 * @author ZOE
 * @date 2019/8/21 18:23
 */
public class 数字颠倒 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()) {
            int num=scanner.nextInt();
            if (num==0){
                System.out.println(0);
                return;
            }
            StringBuilder stringBuilder=new StringBuilder();
            while (num!=0){
                stringBuilder.append(num%10);
                num/=10;
            }
            System.out.println(stringBuilder.toString());
        }

    }

}
