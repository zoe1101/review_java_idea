import java.util.*;
/**
 * @author ZOE
 * @date 2019/8/21 18:20
 */
public class 进制转换 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            if (str != null && str.length() > 2 && str.charAt(0) == '0' && str.charAt(1) == 'x') {
                int res=0;
                for (int i=2;i<str.length();i++){
                    if (str.charAt(i)>='A' && str.charAt(i)<='F' ){
                        res+=res*15+str.charAt(i)-'A'+10;
                    }else {
                        res+=res*15+str.charAt(i)-'0';
                    }

                }
                System.out.println(res);

            }
        }

    }
}
