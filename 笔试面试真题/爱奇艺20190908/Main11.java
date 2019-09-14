package 爱奇艺20190908;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author ZOE
 * @date 2019/9/8 14:26
 */
public class Main11 {
    static int count=0;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] a=new int[n-1];
        for (int i = 0; i <n-1 ; i++) {
            a[i]=scanner.nextInt();
        }

        int[] b=new int[n];

        for (int i = 0; i <n; i++) {
            b[i]=i+1;
        }
        process(b,a);

        System.out.println(count);

    }

    private static void process(int[] nums, int[] a) {
        if (nums==null || nums.length==0){
            return ;
        }
        int count=0;
        //排序
        insertSort(nums);
        countCount(nums,a);
        int i;
        while ((i=hasNext(nums))>0){
            int x=nums[i-1];
            int y=nums[i];
            int k=i;
            int j=i;
            while (j<nums.length){
                if (nums[j]>x & nums[j]<=y){
                    y=nums[j];
                    k=j;
                }
                j++;
            }
            swap(nums,i-1,k);
            reverse(nums,i,nums.length-1);
            countCount(nums,a);
        }
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i<j){
            swap(nums,i++,j--);
        }
    }

    private static int hasNext(int[] nums) {
        for (int i = nums.length-1; i >0 ; i--) {
            if (nums[i]>nums[i-1]){
                return i;
            }
        }
        return 0;
    }

    private static void insertSort(int[] nums) {
        int len=nums.length;
        int preidx,cur;
        for (int i = 1; i <len; i++) {
            preidx=i-1;
            cur=nums[i];
            while (preidx>=0 && nums[preidx]>cur){
                nums[preidx+1]=nums[preidx];
                preidx--;
            }
            nums[preidx+1]=cur;
        }
    }


    public static void swap(int[] nums,int i,int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void countCount(int[] num,int[] a) {
        boolean flag=true;
        for (int i = 0; i <num.length-1 ; i++) {
            if (a[i]==0 && num[i]>=num[i+1]){
                flag=false;
            }
            if (a[i]==1 && num[i]<=num[i+1]){
                flag=false;
            }
        }
        if (flag){
            count++;
        }
    }
}
