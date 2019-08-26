package 链表问题;

public class 反转单向和双向链表 {
	public static class Node { //单链表
		public int value;
		public Node next;
		public Node(int data) {
			this.value=data;
		}
	}
	public static Node reverseList(Node head) {
		Node preNode=null; //前一个结点
		Node nexNode=null; //后一个结点
		while (head!=null) {//当前节点不为空
			nexNode=head.next;
			head.next=preNode;
			preNode=head;
			head=nexNode;
		}
		return preNode;
	}
	
	public static class DoubleNode { //双向链表
		public int value;
		public DoubleNode next;
		public DoubleNode last;
		public DoubleNode(int data) {
			this.value=data;
		}
	}
	public static DoubleNode reverseDoubleList(DoubleNode head) {
		DoubleNode preNode=null;
		DoubleNode nextNode=null;
		while (head!=null) {
			nextNode=head.next;
			head.next=preNode;
			head.last=nextNode;
			preNode=head;
			head=nextNode;

		}
		return preNode;
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
