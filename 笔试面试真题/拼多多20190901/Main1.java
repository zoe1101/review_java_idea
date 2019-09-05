package 拼多多20190901;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author ZOE
 * @date 2019/9/1 14:58
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String string=scanner.next();
            String[] strings=string.trim().split(";");
            int n=Integer.parseInt(strings[1]);
            ArrayList<Integer> evens=new ArrayList<>();
            ArrayList<Integer> odds=new ArrayList<>();
            String[] numstr=strings[0].split(",");
            int[] nums=new int[numstr.length];
            for (int i = 0; i <numstr.length ; i++) {
                nums[i]=Integer.parseInt(numstr[i]);
                if (nums[i]%2==0){
                    evens.add(nums[i]);
                }else {
                    odds.add(nums[i]);
                }
            }
            Collections.sort(evens);
            Collections.sort(odds);
            int[] res=new int[n];
            int index=0;
            int i1=evens.size()-1;
            while (n>0 && i1>=0){
                res[index++]=evens.get(i1--);
                n--;
            }
            i1=odds.size()-1;
            while (n>0 && i1>=0){
                res[index++]=odds.get(i1--);
                n--;
            }
            for (int i = 0; i <res.length-1 ; i++) {
                System.out.print(res[i]+",");
            }
            System.out.println(res[res.length-1]);

        }
    }
}
