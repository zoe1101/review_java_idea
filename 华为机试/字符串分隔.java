import java.util.Scanner;
/**
 * @author ZOE
 * @date 2019/8/21 18:20
 */
public class 字符串分隔 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String str=scanner.nextLine();
            if (str.length()%8!=0){
                str+="00000000";
            }
            while (str.length()>=8){
                System.out.println(str.substring(0,8));
                str=str.substring(8);
            }
        }


    }
}
