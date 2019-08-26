package 拼多多20190728;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int m=scanner.nextInt();
		int[] pi=new int[n];
		int[][] rely=new int[m][2];
		for (int i = 0; i < n; i++) {
			pi[i]=scanner.nextInt();
		}
		for (int i = 0; i < m; i++) {
			rely[i][0]=scanner.nextInt();
			rely[i][1]=scanner.nextInt();
		}
//		int n=5;
//		int m=6;
//		int[] pi= {1,2,1,1,1};
//		int[][] rely= {{1,2},{1,3},{1,4},{2,5},{3,5},{4,5}};
		

		ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i <n; i++){
			list.add(new ArrayList<Integer>());
	    }
		for (int i = 0; i < rely.length; i++) {
			list.get(rely[i][1]-1).add(rely[i][0]-1); //压入桶
		}
		
		
		int[] output=new int[n];
		int index=0;
		int minIndex=-1; //初始化任务为-1
		for (int i = n; i >0; i--) {
			//找到字典序最小且当前无依赖关系的任务
			for (int j = 0; j <list.size(); j++) {
				if (!list.get(j).contains(-1) && list.get(j).isEmpty()) {
					if (minIndex==-1) {
						minIndex=j;
					}else {
						minIndex=pi[j]<pi[minIndex]?j:minIndex;
					}
				}
			}
			//对于当前执行任务，执行后将其执行时间最大化，防止再次执行
			pi[minIndex]=Integer.MAX_VALUE; 
			System.out.println(minIndex);
			output[index++]=minIndex+1; //任务编号是从1开始，而索引编号从0开始
			System.out.println("前"+list.toString());
			list.get(minIndex).add(-1);
			for (int j = 0; j < list.size(); j++) {
				if (!list.get(j).isEmpty()) {
					for (int k = 0; k < list.get(j).size(); k++) {
						if (list.get(j).get(k)==minIndex) {
							list.get(j).remove(k);
						}
					}
				}
			}
			System.out.println("后"+list.toString());	
		}
		System.out.println(Arrays.toString(output));
		scanner.close();
	}

}
