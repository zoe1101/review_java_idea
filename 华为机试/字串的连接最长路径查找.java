import java.util.*;
/**
 * @author ZOE
 * @date 2019/8/21 18:24
 */
public class 字串的连接最长路径查找 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()) {
            int n=scanner.nextInt();
            String[] strs=new String[n];
            for (int i=0;i<n;i++){
                strs[i]=scanner.next();
            }
            for (int i = 0; i < n-1; i++) {
                for (int j = 0; j <n-i-1 ; j++) {
                    if (strs[j].compareTo(strs[j+1])>0){
                        String temp= strs[j];
                        strs[j]=strs[j+1];
                        strs[j+1]=temp;
                    }
                }
            }
            for (String s:strs){
                System.out.println(s);
            }

        }

    }
}
