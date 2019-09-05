package 腾讯20190901;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author ZOE
 * @date 2019/9/1 20:38
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int[][] arr=new int[n][2];
            for (int i = 0; i <n ; i++) {
                arr[i][0]=scanner.nextInt();
                arr[i][1]=scanner.nextInt();
            }
            //ai从大到小排序
            Arrays.sort(arr,new Comparator<int[]>() {
                //按ai降序排序,若相等，则按bi升序排序
                public int compare(int[] a,int[] b) {
                    return a[0]==b[0]?a[1]-b[1]:b[0]-a[0];
                }
            });

            int res=0;
            for (int i = 0; i <n ; i++) {
                res+=arr[i][0]*i+arr[i][1]*(n-i-1);
            }
            System.out.println(res);
        }
    }
}
