package 爱奇艺20190908;

import java.util.Scanner;

/**
 * 给定一个长度为N-1且只包含0和1的序列A1到AN-1，如果一个1到N的排列P1到PN满足对于1≤i<N，
 * 当Ai=0时Pi<Pi+1，当Ai=1时Pi>Pi+1，则称该排列符合要求，那么有多少个符合要求的排列？
 * @author ZOE
 * @date 2019/9/8 15:01
 */
public class Main2 {
    static int count=0;
    static int win=0;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
            int n=scanner.nextInt(); //红球数量
            int m=scanner.nextInt(); //蓝球数量
            int[] temp=new int[n+m];
            for (int i = 0; i <n ; i++) {
                temp[i]=1;
            }
            for (int i = n; i <n+m ; i++) {
               temp[i]=0;
            }
            permute(temp);
        System.out.println(String.format("%.5f", (float)win /(float) count));

    }

    private static void permute(int[] temp) {
        if (temp==null || temp.length==0){
            return;
        }
        permute(temp,0);
    }
    private static void permute(int[] arr,int k){
        if (k==arr.length-1){
            count++;
            for (int i = 0; i <arr.length ; i++) {
                if (arr[i]==1 && i%3==0){
                    win++;
                    break;
                }else if (arr[i]==1 && i%3==1){
                    break;
                }
            }
        }else if (k>=arr.length) return;
        for (int i = k; i <arr.length ; i++) {
            swap(arr,i,k);
            permute(arr,k+1);
            swap(arr,i,k);
        }
    }
    public static void swap(int[] nums,int i,int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}
