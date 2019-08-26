import java.util.Scanner;

/**
 * @author ZOE
 * @date 2019/8/21 14:04
 */
public class 合唱队 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            if (n<=2){
                System.out.println(0);
                continue;
            }
            int[] arr=new int[n];//存储每一个数据元素
            int[] left_queue=new int[n];//数据元素从左到右对应的最大递增子序列数
            int[] right_queue=new int[n];//数据元素从右到左对应的最大递增子序列数
            for (int i=0;i<n;i++){//初始化各个数组数据
                arr[i]=scanner.nextInt();
                left_queue[i]=1;
                right_queue[i]=1;
            }
            for (int i = 0; i <n ; i++) {
                for (int j = 0; j <i ; j++) {
                    if (arr[i]>arr[j] && left_queue[j]+1>left_queue[i]){
                        left_queue[i]=left_queue[j]+1;
                    }
                }
            }


            for(int i=n-1;i>=0;i--){
                for(int j=n-1;j>i;j--){
                    if(arr[i]>arr[j] && right_queue[j]+1>right_queue[i])
                        right_queue[i]=right_queue[j]+1;
                }
            }
            int max=0;
            for(int i=0;i<n;i++){
                if(left_queue[i]+right_queue[i]>max)
                    max=left_queue[i]+right_queue[i];
            }
            System.out.println(n-max+1);

        }
    }

}
