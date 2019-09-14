package 百度20190910;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author ZOE
 * @date 2019/9/10 19:52
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            int[] a=new int[n];
            int[] b=new int[n];
            TreeMap<Integer,Integer> map=new TreeMap<>();
            for (int i = 0; i <n ; i++) {
                a[i]=scanner.nextInt();
            }
            for (int i = 0; i <n ; i++) {
                b[i]=scanner.nextInt();
                map.put(b[i],a[i]);
            }

            int max=0;
            for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
                int bi=entry.getKey();
                int ai= entry.getValue();
                if (ai>0){
                    max+=ai;
                    for (Map.Entry<Integer,Integer> en:map.entrySet()){
                        int bis=en.getKey();
                        int ais= en.getValue();
                        if (bis>bi){
                            map.put(bis,ais-bi);
                        }
                    }
                }else {
                    continue;
                }
            }
            System.out.println(max);
        }
    }
}
