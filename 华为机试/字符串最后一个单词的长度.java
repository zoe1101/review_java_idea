import java.util.Scanner;
/**
 * @author ZOE
 * @date 2019/8/21 18:18
 */
public class 字符串最后一个单词的长度 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        String[] strs=str.trim().split(" ");
        System.out.println(strs[strs.length-1].length());
    }
}
