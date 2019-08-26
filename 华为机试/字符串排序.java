import java.util.Scanner;

/**
 * @author ZOE
 * @date 2019/8/21 14:14
 */
public class 字符串排序 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String str=scanner.nextLine();
            char[] chas=str.toCharArray();
            StringBuilder sb=new StringBuilder();
            for (int i = 0; i <26 ; i++) {
                char c=(char) (i+'A');
                for (int j = 0; j <chas.length ; j++) {
                    if (chas[j]==c || chas[j]==(char)(c+32)){ //大小写兼顾
                        sb.append(chas[j]);
                    }
                }
            }
            for (int i = 0; i <chas.length ; i++) {
                if (!((chas[i]>='A' && chas[i]<='Z' ) || (chas[i]>='a' && chas[i]<='z'))){ //非字母字符
                    sb.insert(i, chas[i]);
                }
            }
            System.out.println(sb.toString());
        }
    }

}
