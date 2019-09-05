package 腾讯20190901;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ZOE
 * @date 2019/9/1 21:02
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt(); //竞拍次数
            int[][] arr=new int[n][2]; //竞拍公司、竞拍价格
            for (int i = 0; i <n ; i++) {
                arr[i][0]=scanner.nextInt();
                arr[i][1]=scanner.nextInt();
            }
            int q=scanner.nextInt(); //询问次数
            int[] nums=new int[q];//每次询问去掉的公司数量
            ArrayList<ArrayList<Integer>> rems=new ArrayList<>(); ////每次询问去掉的公司
            for (int i = 0; i <q ; i++) {
                nums[i]=scanner.nextInt();
                ArrayList<Integer> list=new ArrayList<>();
                for (int j = 0; j <nums[i] ; j++) {
                    list.add(scanner.nextInt());
                }
                rems.add(list);
            }


        }
    }
}
