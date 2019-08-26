package 腾讯;

import java.util.Scanner;

public class Main3 {
	public static void solution(int[] arr,int n,int k) {
		int arrmax=arr[0];
		int arrmin=arr[0];
		for(int i=0;i<k;i++) {
			for(int j=0;j<n;j++) {
				if(arr[j]<arrmin) {
					arrmin=arr[j];
				}
				if(arr[j]>arrmax) {
					arrmax=arr[j];
				}
			}
			if(arrmin==0 && arrmax==0) {
				System.out.println(0);
				return;
			}
			if(i==0 && arrmin!=0) {
				System.out.println(arrmin);
			}else {
				for(int j=0;j<n;j++) {
					if(arr[j]!=arrmin) {
						arr[j]=arr[j]-arrmin;
						System.out.println(arr[j]);
					}
				}
			}
			
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n=scanner.nextInt();
		int k=scanner.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=scanner.nextInt();
		}
		solution(arr,n,k);
	
	}
}
