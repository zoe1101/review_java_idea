package 栈和队列;

import java.util.Arrays;
import java.util.Stack;

import javax.management.RuntimeErrorException;

//用两个栈实现，一个存所有元素，一个存最小元素
public class 设计一个有getMin功能的栈 {
	private Stack<Integer> stackdata;
	private Stack<Integer> stackMin;
	public 设计一个有getMin功能的栈() {
		this.stackdata=new Stack<Integer>();
		this.stackMin=new Stack<Integer>();
	}
	public void push(int newNUm) {
		if(this.stackMin.isEmpty()) {
			this.stackMin.push(newNUm);
		}else if(newNUm<=this.getMin()) {
			this.stackMin.push(newNUm);
		}
		this.stackdata.push(newNUm);
		
	}
	public int pop() {
		if(this.stackdata.isEmpty()) {
			throw new RuntimeErrorException(null, "栈为空");
		}
		int value=this.stackdata.pop();
		if(value==this.getMin()) {
			this.stackMin.pop();
		}
		return value;
		
	}
	public int getMin() {
		if(this.stackMin.isEmpty()) {
			throw new RuntimeErrorException(null, "栈为空");
		}
		return this.stackMin.peek();
	}
	

	public static void main(String[] args) {
		设计一个有getMin功能的栈 mystack=new 设计一个有getMin功能的栈();
		mystack.push(3);
		mystack.push(4);
		mystack.push(2);
		mystack.push(3);
		mystack.push(1);
		System.out.println(mystack.getMin());
		mystack.pop();
		System.out.println(mystack.getMin());

	}

}
