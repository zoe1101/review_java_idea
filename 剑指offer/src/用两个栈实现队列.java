package src;
import java.util.Stack;

/*
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class 用两个栈实现队列 {
	Stack<Integer> stack1 = new Stack<Integer>(); //压入栈
    Stack<Integer> stack2 = new Stack<Integer>(); //弹出栈
    
    public void push(int node) {
    	stack1.push(node);

    }
    
    public int pop() {
        if(!stack2.isEmpty()) {
        	return stack2.pop();
        }else {
        	while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
        	return stack2.pop();
        }
    }

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
