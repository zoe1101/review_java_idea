import java.util.*;
/**
 * @author ZOE
 * @date 2019/8/21 18:22
 */
public class 字符个数统计 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()) {
            String str=scanner.nextLine();
            Set<Character> set=new HashSet<>();
            for (int i=0;i<str.length();i++){
                if ((int)str.charAt(i)>0 && (int)str.charAt(i)<127 && !set.contains(str.charAt(i))){
                    set.add(str.charAt(i));
                }
            }
            System.out.println(set.size());
        }

    }

}
