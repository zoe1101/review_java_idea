package 商汤科技_测试_20190819;

import java.util.Scanner;

/**
 * LeetCode 845
 *我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < … B[i-1] < B[i] > B[i+1] > … > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 * 如果不含有 “山脉” 则返回 0。
 *
 * 示例 1：
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 *
 * 示例 2：
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。

 * @author ZOE
 * @date 2019/8/19 20:21
 */
public class Main2 {
/*
思路：山脉是先递增后递减，递减从后往前看就是递增，那么
使用up数组记录从前往后看每个元素作为递增终点的递增元素个数；
使用down从后往前看每个元素作为递增终点的元素个数，
只要两个数组同一位置的值都大于0那么说明该元素前面是递增后面是递减可以成为一个山脉
山脉元素个数等于两个数组元素和+1
 */
    public static int longestMountain(int[] A) {
        int res=0;
        int[] up=new int[A.length];
        int[] down=new int[A.length];
        for (int i = A.length-2; i > -1; i--) {
            if (A[i]>A[i+1])
            {
                down[i]=down[i+1]+1;
            }
        }
        for (int i = 1; i < A.length; i++) {
            if (A[i]>A[i-1])
            {
                up[i]=up[i-1]+1;
                if (down[i]>0)
                {
                    int sum=up[i]+down[i]+1;
                    if (sum>res)
                    {
                        res=sum;
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(longestMountain(arr));
    }
}
