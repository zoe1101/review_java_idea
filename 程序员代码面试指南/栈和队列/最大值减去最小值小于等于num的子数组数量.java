package 栈和队列;

import java.util.LinkedList;
import java.util.Stack;

//利用双端队列结构，需要进行数组移动变换时常用
public class 最大值减去最小值小于等于num的子数组数量 {
	public static int getnum(int[] arr,int num) {
		if(arr==null ||arr.length==0 || num<0) {
			return 0;
		}
		LinkedList<Integer> qmin=new LinkedList<Integer>(); //维护arr[i:j]的最小值，从大到小存位置索引
		LinkedList<Integer> qmax=new LinkedList<Integer>(); //维护arr[i:j]的最大值，从小到大存位置索引
		int i=0,j=0,res=0;
		while(i<arr.length){
			while (j<arr.length) {
				if(qmin.isEmpty() || qmin.peekLast()!=j) { //qmin为空或arr[i:j]不满足条件
					while (!qmin.isEmpty() && arr[qmin.peekLast()]>=arr[j]) {//arr[i:j]不满足条件时
						qmin.pollLast();
					}
					qmax.addLast(j);
				}
				if(arr[qmax.getFirst()]-arr[qmin.getFirst()]>num) {//qmax中最小的-qmin最大的都大于num
					break;//该子数组不合格，停止更新j
				}
				j++;
			}
			res+=j-1;
			if(qmin.peekFirst()==i) {
				qmin.pollFirst();
			}
			if(qmax.peekFirst()==i) {
				qmax.pollFirst();
			}
			i++;
		}
		return res;
		
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
