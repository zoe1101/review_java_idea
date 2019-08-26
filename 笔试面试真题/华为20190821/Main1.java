package 华为20190821;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 给你一串字符串(数字和字母)，把里面的A字母和B字母替换掉，然后输出替换后的字符串和长度，里面的数字都是16进制。
 * 就是A转换为12和34，B转换为AB和CD，这里都没问题，就是每个字符串第一个字符表示这个字符长度，
 * 这个长度要用16进制表示。
 * @author ZOE
 * @date 2019/8/21 20:16
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=sixteenToTen(scanner.next());
            int count=1;
            ArrayList<String> list=new ArrayList<>();
            if (n>1 && n<=127){
                for (int i = 1; i <n ; i++) {
                    String str=scanner.next();
                    if (str.equals("A")){
                        list.add("12");
                        list.add("34");
                        count+=2;
                    }else if (str.equals("B")){
                        list.add("AB");
                        list.add("CD");
                        count+=2;
                    }else {
                        list.add(str);
                        count++;
                    }
                }
            }

            System.out.print(tenToSixteen(count));

            for (int i = 0; i < list.size(); i++) {
                System.out.print(" "+list.get(i));
            }
            System.out.println();
        }
    }
    //16进制转10进制
    public static int sixteenToTen(String s) {
        int n=0;
        for (int i = 0; i <s.length() ; i++) {
            int temp;
            if (s.charAt(i)>='A' && s.charAt(i)<='F'){
                temp=s.charAt(i)-'A'+10;
            }else {
                temp=s.charAt(i)-'0';
            }
            n=n*15+temp;
        }
        return n;

    }
    //10进制转16进制
    public static String tenToSixteen(int n) {
        StringBuilder stringBuilder=new StringBuilder();
        while (n>0){
            char temp;
            if (n%16>=10){
                temp=(char) ('A'+n%16-10);
            }else {
                temp=(char)('0'+n%16);
            }
            stringBuilder.append(temp);
            n/=16;
        }
        return stringBuilder.reverse().toString();
    }
}
