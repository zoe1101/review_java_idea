package src;

import java.util.ArrayList;
import java.util.Stack;


/*
输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class 从尾到头打印链表 {
	public static class ListNode{
		ListNode next;
		int val;
		public  ListNode(int val) {
			this.val=val;
		}
	}
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		Stack<Integer> stack=new Stack<Integer>();
		while (listNode!=null) {
			stack.push(listNode.val);
			listNode=listNode.next;
		}
		ArrayList<Integer> res=new ArrayList<Integer>();
		while (!stack.isEmpty()) {
			res.add(stack.pop());
		}
		return res;
	}
}
