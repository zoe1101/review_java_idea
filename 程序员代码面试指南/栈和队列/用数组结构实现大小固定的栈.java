package 栈和队列;

public class 用数组结构实现大小固定的栈 {
	public static class ArrayStack {
		private Integer[] arr;
		private Integer index; //指针指向当前栈顶元素
		public ArrayStack(int size) {
			if (size<0) {
				throw new IllegalArgumentException("The init size is less than 0");
			}
			arr=new Integer[size];
			index=0;
		}
		public Integer peek() {
			if (index==0) {
				return null;
			}
			return arr[index-1];
		}
		public void push(int obj) {
			if (index==arr.length) {
				throw new ArrayIndexOutOfBoundsException("The stack is full");
			}
			arr[index++]=obj;
		}
		public Integer pop() {
			if (index==0) {
				throw new ArrayIndexOutOfBoundsException("The stack is empty");
			}
			return arr[--index];
		}
	}

}
