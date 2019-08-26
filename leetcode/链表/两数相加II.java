package 链表;

import java.util.Stack;

/*
给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。
将这两数相加会返回一个新的链表。

你可以假设除了数字 0 之外，这两个数字都不会以零开头。

进阶:
如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。

示例:
输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
输出: 7 -> 8 -> 0 -> 7
 */

//难点: 进位的处理; 链表无法逆向遍历
//以栈的方式实现, 用栈来存放每一个结点的数字
public class 两数相加II {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode result=new ListNode(0);
    	Stack<Integer>stack1=new Stack<Integer>();
    	Stack<Integer>stack2=new Stack<Integer>();
    	ListNode p=l1,q=l2;
    	int carry=0;
    	while (p!=null) {//入栈
    		stack1.add(p.val);
    		p=p.next;
		}
    	while (q!=null) {//入栈
    		stack2.add(q.val);
    		q=q.next;
		}
    	while(!stack1.isEmpty() ||!stack2.isEmpty()) {
    		int x=(!stack1.isEmpty())?stack1.peek():0;
    		int y=(!stack2.isEmpty())?stack2.peek():0;
    		int sum=carry+x+y;
    		carry=sum/10;
    	    ListNode cur=new ListNode(sum%10);
    		cur.next=result.next;
    		result.next=cur;
    		if (!stack1.isEmpty()) stack1.pop();
    		if (!stack2.isEmpty()) stack2.pop();
    	}
    	if(carry>0) {
    		ListNode cur=new ListNode(carry);
    		cur.next=result.next;
    		result.next=cur;
    	}
    	 return result.next;
    }
   
}
