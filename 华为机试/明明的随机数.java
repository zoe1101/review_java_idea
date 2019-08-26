import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
 * @author ZOE
 * @date 2019/8/21 18:19
 */
public class 明明的随机数 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int[] arr=new int[n];
            for (int i = 0; i <n ; i++) {
                arr[i]=scanner.nextInt();
            }

            Arrays.sort(arr);
            ArrayList<Integer> res=new ArrayList<>();
            res.add(arr[0]);
            int index=0;
            for (int i = 1; i <n ; i++) {
                if (arr[i]!=res.get(index)){
                    res.add(arr[i]);
                    index++;
                }
            }
            for (int i:res){
                System.out.println(i);
            }
        }

    }
}
