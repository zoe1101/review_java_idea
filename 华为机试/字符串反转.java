import java.util.*;
/**
 * @author ZOE
 * @date 2019/8/21 18:23
 */
public class 字符串反转 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()) {
            String str=scanner.nextLine();
            StringBuilder stringBuilder=new StringBuilder();
            for (int i=0;i<str.length();i++){
                stringBuilder.append(str.charAt(i));
            }
            System.out.println(stringBuilder.reverse().toString());
        }

    }

}
