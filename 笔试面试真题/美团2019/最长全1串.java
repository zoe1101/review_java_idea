package 美团2019;

import java.util.Scanner;

/*
给你一个01字符串，定义答案=该串中最长的连续1的长度，现在你有至多K次机会，
每次机会可以将串中的某个0改成1，现在问最大的可能答案

输入描述:
输入第一行两个整数N,K，表示字符串长度和机会次数

第二行输入N个整数，表示该字符串的元素

( 1 <= N <= 300000
, 0 <= K <= N )

输出描述:
输出一行表示答案

输入例子1:
10 2 
1 0 0 1 0 1 0 1 0 1

输出例子1:
5
 */
public class 最长全1串 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int k=scanner.nextInt();
		int[] arr=new int[n+1];
		int[] sum=new int[n+1];
		for (int i = 1; i <= n; i++) {
			int temp=scanner.nextInt();
			if (temp!=0 && temp!=1) {
				System.out.println("输入有误");
				break;
			}
			arr[i]=temp;
			sum[i] = sum[i-1] + temp;
		}
		int r=1;
		int l=1;
		int ans=0;
		while (r<=n) { // 双指针尺取法一下  左右区间推进一下就行了
			if ((r-l+1)-(sum[r]-sum[l-1])<=k) { // 总数减去1的个数就是0的个数
				ans = Math.max(ans,r - l + 1);
				r++;
			}else if (l<r) {
				l++;
			}else {
				l++;
				r++;
			}
		}
		System.out.println(ans);
		scanner.close();
	}

}
