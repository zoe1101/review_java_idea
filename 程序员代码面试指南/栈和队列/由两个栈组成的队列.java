package 栈和队列;

import java.util.Stack;

import javax.management.RuntimeErrorException;
import javax.swing.text.rtf.RTFEditorKit;

public class 由两个栈组成的队列 {
	public Stack<Integer> stackpush; //压入栈
	public Stack<Integer> stackpop; //弹出栈
	public 由两个栈组成的队列() {
		stackpush=new Stack<Integer>();
		stackpop=new Stack<Integer>();
	}
	public void pushTopop() {//将压入栈的内容压入弹出栈
		if(stackpop.isEmpty()) {
			while (!stackpush.isEmpty()) {
				stackpop.push(stackpush.pop());
			}
		}
	}
	public void add(int value) {//入队
		stackpush.push(value);
		pushTopop();
	}
	public int poll() {//出队
		if(stackpop.isEmpty() &&stackpush.isEmpty()) {
			throw new RuntimeErrorException(null,"空队列");
		}
		pushTopop();
		return stackpop.pop();
	}
	public int peek() {//获取队头元素，但不出队
		if(stackpop.isEmpty() &&stackpush.isEmpty()) {
			throw new RuntimeErrorException(null,"空队列");
		}
		pushTopop();
		return stackpop.peek();
	}

	public static void main(String[] args) {
		由两个栈组成的队列 queue=new 由两个栈组成的队列();
		queue.add(4);
		queue.add(2);
		queue.add(1);
		queue.add(3);
		System.out.println(queue.poll());
		System.out.println(queue.peek());


	}

}
