import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author ZOE
 * @date 2019/8/21 14:24
 */
public class 查找兄弟单词 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            String[] words=new String[n];
            for (int i = 0; i < n; i++) {
                words[i]=scanner.next();
            }
            String keyword=scanner.next();
            char[] keyChar = keyword.toCharArray();
            Arrays.sort(keyChar);
            int no = scanner.nextInt();//第几个
            int count=0;
            ArrayList<String> list=new ArrayList<>();
            for (int i = 0; i <n ; i++) {
                int c=check(keyword,words[i],keyChar);
                count+=c;
                if (c==1){
                    list.add(words[i]);
                }
            }
            System.out.println(count);
            Collections.sort(list);
            if (count>=no){
                System.out.println(list.get(no-1));
            }
        }
    }

//判断两个单词是否为兄弟单词
    private static int check(String keyword, String word, char[] keyChar) {
        if (keyword.equals(word) || keyword.length()!=word.length()){
            return 0;
        }
        char[] wordChar=word.toCharArray();
        Arrays.sort(wordChar);
        return Arrays.equals(keyChar,wordChar)?1:0;
    }
}
