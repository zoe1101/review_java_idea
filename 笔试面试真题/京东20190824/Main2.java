package 京东20190824;

import java.util.Scanner;

/**
 * 与leetcode-768类似
 * @author ZOE
 * @date 2019/8/24 19:58
 */
public class Main2 {
    public static int count=1;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        long[] arr=new long[n];
        for (int i=0;i<n;i++){
            arr[i]=scanner.nextLong();
        }
        process(arr,0,arr.length-1);
        System.out.println(count);
    }

    public static void process(long[] arr,int left,int right) {
        if (left<right){
            int lastminindex=left;
            int firstmaxindex=left;
            for (int i = left; i <=right; i++) {
                if (arr[i]<=arr[lastminindex]){
                    lastminindex=i;
                }
                if (arr[i]>arr[firstmaxindex]){
                    firstmaxindex=i;
                }
            }
            if (firstmaxindex>lastminindex){
                count++;
                process(arr,left,lastminindex);
                process(arr,firstmaxindex,right);
            }
        }
    }

}
