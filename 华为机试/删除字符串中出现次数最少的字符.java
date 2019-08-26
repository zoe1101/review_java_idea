import java.util.Scanner;
import java.util.regex.Matcher;

/**
 * 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。
 * 输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 * 输入描述:
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 *
 * 输出描述:
 * 删除字符串中出现次数最少的字符后的字符串。
 *
 * 示例1
 * 输入
 * abcdd
 * 输出
 * dd
 *
 * @author ZOE
 * @date 2019/8/21 13:46
 */
public class 删除字符串中出现次数最少的字符 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String str=scanner.nextLine();
            int[] map=new int[26];
            for (int i = 0; i < str.length(); i++) {
                map[str.charAt(i)-'a']++;
            }
            int min=Integer.MAX_VALUE;
            for (int i:map){
                if (i!=0 && i < min){
                    min= i;
                }
            }

            for (int i = 0; i <str.length() ; i++) {
                if (map[str.charAt(i)-'a']!=min){
                    System.out.print(str.charAt(i));
                }
            }
            System.out.println();

        }
    }

}
