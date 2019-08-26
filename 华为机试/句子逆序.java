import java.util.*;
/**
 * @author ZOE
 * @date 2019/8/21 18:23
 */
public class 句子逆序 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()) {
            String str=scanner.nextLine();
            String revstr=reverse(str);
            String[] words=revstr.trim().split(" ");
            String res="";
            for (String w:words){
                res+=" "+reverse(w);
            }
            System.out.println(res.trim());
        }

    }

    private static String reverse(String str) {
        if (str==null || str.length()<2){
            return str;
        }
        char[] chas=str.toCharArray();
        int left=0;
        int right=chas.length-1;
        while (left<right){
            char temp=chas[left];
            chas[left]=chas[right];
            chas[right]=temp;
            left++;
            right--;
        }
        return String.valueOf(chas);
    }

}
