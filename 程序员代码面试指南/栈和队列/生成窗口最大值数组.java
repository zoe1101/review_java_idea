package 栈和队列;

import java.util.Arrays;
import java.util.LinkedList;

//利用双端队列实现
public class 生成窗口最大值数组 {
	public static int[] getMaxWindow(int[] arr,int w) {
		if(arr==null ||w<1 || arr.length<w) {
			return null;
		}
		LinkedList<Integer> qmax=new LinkedList<Integer>(); //双端队列，存放的是下标
		int[] res=new int[arr.length-w+1];
		int index=0;
		for(int i=0;i<arr.length;i++) {
			//非空,且队尾存放的下标对应的元素小于等于arr[i],则弹出元素
			while (!qmax.isEmpty() && arr[qmax.peekLast()]<=arr[i]) {
				qmax.pollLast();
			}//直到队空或队尾存放的下标对应的元素大于arr[i],然后将i压入队列
			qmax.addLast(i);
			if(qmax.peekFirst()==i-w) {//队头存放的下标已过期，只维护窗口为w的子数组
				qmax.pollFirst();
			}
			if(i>=w-1) {
				res[index++]=arr[qmax.peekFirst()];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr= {4,3,5,4,3,3,6,7};
		System.out.println(Arrays.toString(getMaxWindow(arr, 3)));

	}

}
