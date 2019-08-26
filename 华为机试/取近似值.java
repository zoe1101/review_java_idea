import java.util.*;
/**
 * @author ZOE
 * @date 2019/8/21 18:21
 */
public class 取近似值 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()) {
            float num=scanner.nextFloat();
            num=num-(int)num>=0.5?(int)num+1:(int)num;
            System.out.println((int)num);
        }

    }
}
