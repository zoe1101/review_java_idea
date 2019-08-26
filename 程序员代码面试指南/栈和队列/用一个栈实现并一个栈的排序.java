package 栈和队列;

import java.util.Stack;
//从栈顶到栈底从大到小排序，即要求从小到大入栈
public class 用一个栈实现并一个栈的排序 {
	public void sortStackByStack(Stack<Integer> stack) {
		Stack<Integer> helpStack =new Stack<Integer>();//辅助排序栈,从大到小的入栈
		while (!stack.isEmpty()) {
			int cur=stack.pop();
			while (!helpStack.isEmpty() && helpStack.peek()<cur) {
				stack.push(helpStack.pop());
			}
			helpStack.push(cur);
		}
		while (!helpStack.isEmpty()) {
			stack.push(helpStack.pop()); //从小到大的入栈
			
		}
		
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
