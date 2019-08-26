package 栈和队列;

import java.util.Stack;



//2座山是1，两座山以上是2*n-3
public class 可见的山峰对数量 {
	public static class Record{
		public int value;
		public int times;
		public Record(int value) {
			this.value=value;
			this.times=1;
		}
	}

	public static int getVisibleNum(int[] arr) {
		if(arr==null ||arr.length<=1) {
			return 0;
		}
		int size=arr.length;
		int maxIndex=0;
		for(int i=0;i<size;i++) {//在环中找到其中一个最大值的位置
			maxIndex=arr[i]>arr[maxIndex]?i:maxIndex;
		}
		Stack<Record> stack=new Stack<Record>();
		stack.push(new Record(arr[maxIndex]));//现将(最大值,1)这条记录压入栈
		int index=nextIndex(maxIndex,size); //从最大值位置开始沿着next方向遍历
		//采用“以小找大”的方式
		int res=0; //可见山峰对数量
		while (index!=maxIndex) {
			while (stack.peek().value<arr[index]) {
				int k=stack.pop().times;
				res+=2*k+getInternalSum(k);
			}
			if(stack.peek().value==arr[index]) {
				stack.peek().times++;
			}else {
				stack.push(new Record(arr[index]));
			}
			index=nextIndex(index, size);
		}
		while (stack.size()>2) {
			int times=stack.pop().times;
			res+=2*times+getInternalSum(times);
		}
		if(stack.size()==2) {
			int times=stack.pop().times;
			res+=getInternalSum(times)+(stack.peek().times==1?times:2*times);
		}
		res+=getInternalSum(stack.pop().times);
		return res;
	}
	
	//环形数组当前位置为i，数组长度为size，返回i的下一个位置
	public static int nextIndex(int i ,int size) {
		return i<(size-1)?i+1:0;
	}
	
	//同一高度的山峰内部可以组成的可见山峰对数量
	public static int getInternalSum(int k) {
		return k==1?0:(k*(k-1)/2); //(k*(k-1)/2):Cn2
	}

	public static void main(String[] args) {
		int[] arr={3,2,5,4};
		System.out.print(getVisibleNum(arr));
	}

}
