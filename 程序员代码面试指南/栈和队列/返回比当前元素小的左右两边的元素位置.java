package 栈和队列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 返回比当前元素小的左右两边的元素位置 {
//	暴力法 
//	时间复杂度：O(n^2)
	public static int[][] violence(int[] arr) {//无重复值时
		int[][] res=new int[arr.length][2];
		for(int i=0;i<arr.length;i++) {
			int leftLessIndex=-1; //-1代表不存在
			int rightLessIndex=-1;
			int cur=i-1;//左边元素查找起始位置
			while (cur>=0) {
				if(arr[cur]<arr[i]) {
					leftLessIndex=cur;
					break;
				}
				cur--;
			}
			cur=i+1;//右边元素查找起始位置
			while (cur<arr.length) {
				if(arr[cur]<arr[i]) {
					rightLessIndex=cur;
					break;
				}
				cur++;
			}
			res[i][0]=leftLessIndex;
			res[i][1]=rightLessIndex;
		}
		return res;
	}
	//	使用单调栈结构
	public static int[][] ByStack(int[] arr) {//无重复值时
		int[][] res=new int[arr.length][2];
		Stack<Integer> stack=new Stack<Integer>();//存的索引位置
		for(int i=0;i<arr.length;i++) {
			while (!stack.isEmpty() && arr[stack.peek()]>arr[i]) {
				int popIndex=stack.pop();
				int leftLessIndex=stack.isEmpty()?-1:stack.peek();
				res[popIndex][0]=leftLessIndex;
				res[popIndex][1]=i;
				
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {//清空栈中剩下的位置，这些位置对应的元素右边没有比其小的元素，因为栈是单调的
			int popIndex=stack.pop();
			int leftLessIndex=stack.isEmpty()?-1:stack.peek();
			res[popIndex][0]=leftLessIndex;
			res[popIndex][1]=-1;
		}
		return res;
	}
	
	//	使用单调栈结构
	public static int[][] ByStack2(int[] arr) {//有重复值时
		int[][] res=new int[arr.length][2];
		Stack<List<Integer>> stack=new Stack<List<Integer>>();//相同的元素索引存在一个list中
		for(int i=0;i<arr.length;i++) {
			while (!stack.isEmpty() && arr[stack.peek().get(0)]>arr[i]) {//栈非空且栈顶元素大于当前元素
				List<Integer> popIs=stack.pop();
				int leftLessIndex=stack.isEmpty()?-1:stack.peek().get(stack.peek().size()-1);//返回最晚加入的那一个索引位置
				for(Integer popi:popIs) {
					res[popi][0]=leftLessIndex;
					res[popi][1]=i;
				}
			}
			if(!stack.isEmpty() && arr[stack.peek().get(0)]==arr[i]) {//已有该元素的一个位置索引，则继续添加
				stack.peek().add(Integer.valueOf(i));
			}else {//栈中还没有该元素的索引
				ArrayList<Integer> list=new ArrayList<Integer>();
				list.add(i);
				stack.push(list);
			}
		}
		while (!stack.isEmpty()) {
			List<Integer> popIs=stack.pop();
			int leftLessIndex=stack.isEmpty()?-1:stack.peek().get(stack.peek().size()-1);
			for(Integer popi:popIs) {
				res[popi][0]=leftLessIndex;
				res[popi][1]=-1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr= {3,4,3,1,5,6,2,7};
		int[][] a=violence(arr);
		int[][] b=ByStack2(arr);
		for(int[] row:a) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println("单调栈方法");
		for(int[] row:b) {
			System.out.println(Arrays.toString(row));
		}

	}

}
