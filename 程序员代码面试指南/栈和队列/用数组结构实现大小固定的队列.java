package 栈和队列;

public class 用数组结构实现大小固定的队列 {
	public static class ArrayQueue {
		private Integer[] arr;
		private Integer first;
		private Integer last;
		private Integer size;
		private ArrayQueue(int capacity) {
			if (capacity<0) {
				throw new IllegalArgumentException("The init size is less than 0");
			}
			arr=new Integer[capacity];
			first=0;
			last=0;
			size=0;
		}
		public void push(int obj) {
			if (size==arr.length) {
				throw new ArrayIndexOutOfBoundsException("The queue is full");
			}
			size++;
			arr[last]=obj;
			last=last==arr.length-1?0:last+1;
		}
		public Integer poll() {
			if (size==0) {
				throw new ArrayIndexOutOfBoundsException("The queue is empty");
			}
			size--;
			int temp=first;
			first=first==arr.length-1?0:first+1;
			return arr[temp];
		}
		
		public Integer peek() {
			if (size == 0) {
				return null;
			}
			return arr[first];
		}
	}
}
