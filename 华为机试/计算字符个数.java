import java.util.Scanner;
/**
 * @author ZOE
 * @date 2019/8/21 18:19
 */
public class 计算字符个数 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine().toLowerCase();
        char exp=scanner.next().toLowerCase().charAt(0);
        int count=0;
        for (int i = 0; i <str.length(); i++) {
            if (str.charAt(i)==exp){
                count++;
            }
        }
        System.out.println(count);

    }
}
