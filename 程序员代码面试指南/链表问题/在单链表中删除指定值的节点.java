package 链表问题;

import java.util.Stack;

public class 在单链表中删除指定值的节点 {
	public static class Node{
		public int value;
		public Node next;
		public Node(int val) {
			this.value=val;
		}
	}
	//借助栈结构实现
	public static Node removeValue1(Node head,int num) {
		Stack<Node> stack=new Stack<Node>();
		while (head!=null) {
			if (head.value!=num) {
				stack.push(head);
			}
			head=head.next;
		}
		while (!stack.isEmpty()) {
			stack.peek().next=head;
			head=stack.pop();
		}
		return head;
	}
//	在原链表上进行
	public static Node removeValue2(Node head,int num) {
		while (head!=null) {
			if (head.value!=num) {
				break;
			}
			head=head.next;
		}
		Node preNode=head;
		Node curNode=head;
		while (curNode!=null) {
			if (curNode.value==num) {
				preNode.next=curNode.next;
				
			}else {
				preNode=curNode;
			}
			curNode=curNode.next;
		}
		return head;
	}
	
	public static void printLinkedList(Node head) {
		System.out.print("Linked List: ");
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(1);
		head.next.next = new Node(3);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(1);
		head.next.next.next.next.next = new Node(2);
		head.next.next.next.next.next.next = new Node(1);
		head.next.next.next.next.next.next.next = new Node(1);
		head = removeValue1(head, 1);
		printLinkedList(head);

		head = new Node(1);
		head.next = new Node(1);
		head.next.next = new Node(3);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(1);
		head.next.next.next.next.next = new Node(2);
		head.next.next.next.next.next.next = new Node(1);
		head.next.next.next.next.next.next.next = new Node(1);
		head = removeValue2(head, 1);
		printLinkedList(head);

	}
}
