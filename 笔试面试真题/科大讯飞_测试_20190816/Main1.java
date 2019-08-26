package 科大讯飞_测试_20190816;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 一个包含汉字、字母、数字任意长度的字符串，获取字符串中的数字并升序排列
 * @author ZOE
 * @date 2019/8/16 18:46
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        char[] chas=str.toCharArray();
        StringBuilder stringBuilder=new StringBuilder();
        for (char c:chas) {
            if (c-'0'>=0 && c-'0'<=9){
                stringBuilder.append(c);
            }
        }
        char[] res=stringBuilder.toString().toCharArray();
        Arrays.sort(res);
        String sortedStr=new String(res);
        System.out.println(sortedStr);
    }


}

