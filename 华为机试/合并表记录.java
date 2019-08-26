import java.util.*;
/**
 * @author ZOE
 * @date 2019/8/21 18:21
 */
public class 合并表记录 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()) {
            int n=scanner.nextInt();
            Map<Integer,Integer> map=new TreeMap<>();// TreeMap中键值会自动按照升序排列
            for (int i=0;i<n;i++){
                int key=scanner.nextInt();
                int value=scanner.nextInt();
                map.put(key,map.getOrDefault(key,0)+value);
            }
            for (Integer k:map.keySet()){
                System.out.println(k+" "+map.get(k));
            }

        }

    }

}
