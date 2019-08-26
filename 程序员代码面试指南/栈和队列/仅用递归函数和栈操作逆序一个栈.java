package 栈和队列;

import java.util.Stack;

public class 仅用递归函数和栈操作逆序一个栈 {
	//栈逆序
	public static void reverse(Stack<Integer> stack) {
		if(stack.isEmpty()) return;
		int i=getAndRemoveLastElement(stack);
		reverse(stack);
		stack.push(i);
		
	}
	//移除并返回当前栈底元素
	public static int getAndRemoveLastElement(Stack<Integer> stack) {
		int result=stack.pop();
		if(stack.isEmpty()) {
			return result;
		}else {
			int last=getAndRemoveLastElement(stack);
			stack.push(result);
			return last;
		}
		
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
