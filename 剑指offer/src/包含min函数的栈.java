package src;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * @author zoe
 *
用一个辅助栈来实现最小值的更新工作。
入栈时:
1）当数据栈为空时，进入栈的元素同时也进入辅助栈；
2）当它不为空时，就把该入栈元素与辅助栈的栈顶元素进行比较，若入栈元素小，则该元素同时也进入辅助栈；若不是，则对辅助栈不进行操作

出栈时:
1）当时辅助栈的栈顶元素等于处理数据的数据栈栈顶元素时，不经数据栈要弹出元素，辅助栈也要弹出栈顶元素，
2)当不等时，只对数据栈进行出栈操作。
 */
public class 包含min函数的栈 {
	Stack<Integer> datestack=new Stack<Integer>();//存放元素栈
	Stack<Integer> minstack=new Stack<Integer>();//辅助栈，data栈中每次进入一个元素，min辅助栈就存放当前data栈中的最小元素
	public void push(int node) {
        datestack.push(node);
        if(minstack.isEmpty()) {
        	minstack.push(node);
        }else if (!minstack.isEmpty() && minstack.peek()>node) {
			minstack.push(node);
		}
        
    }
    
    public void pop() {
    	 if(!datestack.isEmpty()) {
    		 int tmp=datestack.pop();
    		 if(minstack.peek()==tmp) {
    			 minstack.pop();
    		 }
        }
    }
    
    public int top() {
        return datestack.peek();
    }
    
    public int min() {
        return minstack.peek();
    }
}
