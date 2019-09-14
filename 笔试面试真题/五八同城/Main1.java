package 五八同城;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author ZOE
 * @date 2019/9/12 20:39
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        HashMap<String,Integer> map=new HashMap<>();
        String[] strs=scanner.nextLine().split(",");
        for (String s:strs) {
            String temp=s.trim();
            map.put(temp,map.getOrDefault(temp,0)+1);
        }


        System.out.println(map.size());

    }
}
