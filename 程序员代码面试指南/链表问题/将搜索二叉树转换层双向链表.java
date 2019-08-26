package 链表问题;

import java.util.LinkedList;
import java.util.Queue;

public class 将搜索二叉树转换层双向链表 {
	public static class Node{
		public int value;
		public Node left;
		public Node right;
		public Node(int val) {
			this.value=val;
		}
	}
	//中序遍历，队列
	public static Node convert1(Node head) {
		Queue<Node> queue=new LinkedList<Node>(); //中序遍历结果
		inOrderToQueue(head, queue);
		if (queue.isEmpty()) {
			return head;
		}
		head=queue.poll();
		Node preNode=head;
		preNode.left=null;
		Node curNode=null;
		while (!queue.isEmpty()) {
			curNode=queue.poll();
			preNode.right=curNode;
			curNode.left=preNode;
			preNode=curNode;
		}
		preNode.right=null;
		return head;
		
	}
	
	
	//中序遍历
	public static void inOrderToQueue(Node head,Queue<Node> queue) {
		if (head==null) {
			return;
		}
		inOrderToQueue(head.left, queue);
		queue.offer(head);
		inOrderToQueue(head.right, queue);
	}
	
	
}
