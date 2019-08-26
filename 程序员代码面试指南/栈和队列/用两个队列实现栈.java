package 栈和队列;

import java.util.LinkedList;
import java.util.Queue;

public class 用两个队列实现栈 {
	public static class TwoQueuesStack {
		private Queue<Integer> data;
		private Queue<Integer> help;
		int size;
		public  TwoQueuesStack() {
			data=new LinkedList<Integer>();
			help=new LinkedList<Integer>();
		}
		public void push(int obj) {
			data.add(obj);
			
		}
		public int peek() {
			if (data.isEmpty()) {
				throw new RuntimeException("Stack is empty!");
			}
			while (data.size()!=1) {
				help.add(data.poll());
			}
			int res=data.poll();
			help.add(res);
			swap();
			return res;
		}
		public int pop() {
			if (data.isEmpty()) {
				throw new RuntimeException("Stack is empty!");
			}
			while (data.size() > 1) {
				help.add(data.poll());
			}
			int res = data.poll();
			swap();
			return res;
		}
		private void swap() {
			Queue<Integer> tmp = help;
			help = data;
			data = tmp;
		}
	}

}
