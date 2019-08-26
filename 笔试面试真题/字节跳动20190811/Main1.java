package 字节跳动20190811;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ZOE
 * @date 2019/8/11 18:46
 */
public class Main1 {
    public static String process(String str) {
        char[] chas=str.toCharArray();
        StringBuilder stringBuilder=new StringBuilder();
        for (char c:chas) {
            if (c-'0'>=0 && c-'0'<=9){
                stringBuilder.append(c);
            }
        }
        if (stringBuilder.length()==0){
            return "-1";
        }
        char[] res=stringBuilder.toString().toCharArray();
        Arrays.sort(res);
        return new String(res);
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        process(str);


    }


}
