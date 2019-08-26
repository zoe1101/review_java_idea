import java.util.*;
/**
 * @author ZOE
 * @date 2019/8/21 18:22
 */
public class 提取不重复的整数 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()) {
            int n=scanner.nextInt();
            ArrayList<Integer> list=new ArrayList<>();
            while (n!=0){
                int temp=n%10;
                if (!list.contains(temp)){
                    list.add(temp);
                }
                n/=10;
            }
            int res=0;
            for (int i:list){
                res=res*10+i;
            }
            System.out.println(res);

        }

    }
}
