package 拼多多20190728;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
	public static int[] process(int[] A,int[] B) {
		if (A.length<2) {
			return A;
		}
		int index=0;
		int[] nums=new int[2];
		nums[0]=Integer.MIN_VALUE;
		nums[1]=A[1];
		for (int i = 1; i < A.length; i++) {
			if (A[i]<=A[i-1]) {
				index=i;
				if (i==A.length-1) {
					nums[0]=A[i-1];
					nums[1]=Integer.MAX_VALUE;
				}else {
					nums[0]=A[i-1];
					nums[1]=A[i+1];
				}
			}
		}
		Arrays.sort(B);
		for (int i = B.length-1; i>=0; i--) {
			if (B[i]>nums[0] && B[i]<nums[1]) {
				A[index]=B[i];
				return A;
			}
		}

		return A;
	}

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String str1=scanner.nextLine();
		String str2=scanner.nextLine();
		String[] words1=str1.split("\\s+");
		String[] words2=str2.split("\\s+");
		int[] A=new int[words1.length];
		int[] B=new int[words2.length];
		for (int i=0;i<words1.length;i++) {
			A[i]=Integer.parseInt(words1[i]);
		}
		for (int i=0;i<words2.length;i++) {
			B[i]=Integer.parseInt(words2[i]);
		}
		int[] res=process(A, B);
		for (int i:res) {
			System.out.print(i+" ");
		}
		System.out.println();
		scanner.close();
	}

}
