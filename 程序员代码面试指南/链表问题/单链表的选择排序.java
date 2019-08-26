package 链表问题;

import java.awt.image.SampleModel;

//要求空间复杂度O（1）;
public class 单链表的选择排序 {
	public static class Node{
		public int value;
		public Node next;
		public Node(int val) {
			this.value=val;
		}
	}
	public static Node selectionSort(Node head) {
		Node curNode=head; //排序部分的尾部
		Node tailNode=null; //未排序部分的头部
		Node smallPreNode=null;//最小节点的前一个节点
		Node smallNode=null;//最小节点
		while (curNode!=null) {
			smallNode=curNode;
			smallPreNode=getSmallestNode(curNode);
			if (smallPreNode!=null) {
				smallNode=smallPreNode.next;
				smallPreNode.next=smallNode.next;
			}
			curNode=curNode==smallNode?curNode.next:curNode;
			if (tailNode==null) {
				head=smallNode;
			}else {
				tailNode.next=smallNode;
			}
			tailNode=smallNode;
		}
		return head;
	}
	public static Node getSmallestNode(Node head) {
		Node smallPreNode=null;
		Node smallNode=head;
		Node preNode=head;
		Node curNode=head.next;
		while (curNode!=null) {
			if (curNode.value<smallNode.value) {
				smallPreNode=preNode;
				smallNode=curNode;
			}
			preNode=curNode;
			curNode=curNode.next;
		}
		return smallPreNode;
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
		Node head = null;
		head = selectionSort(head);
		printLinkedList(head);

		head = new Node(1);
		head = selectionSort(head);
		printLinkedList(head);

		head = new Node(1);
		head.next = new Node(2);
		head = selectionSort(head);
		printLinkedList(head);

		head = new Node(2);
		head.next = new Node(1);
		head = selectionSort(head);
		printLinkedList(head);

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head = selectionSort(head);
		printLinkedList(head);

		head = new Node(1);
		head.next = new Node(3);
		head.next.next = new Node(2);
		head = selectionSort(head);
		printLinkedList(head);

		head = new Node(2);
		head.next = new Node(1);
		head.next.next = new Node(3);
		head = selectionSort(head);
		printLinkedList(head);

		head = new Node(2);
		head.next = new Node(3);
		head.next.next = new Node(1);
		head = selectionSort(head);
		printLinkedList(head);

		head = new Node(3);
		head.next = new Node(1);
		head.next.next = new Node(2);
		head = selectionSort(head);
		printLinkedList(head);

		head = new Node(3);
		head.next = new Node(2);
		head.next.next = new Node(1);
		head = selectionSort(head);
		printLinkedList(head);

		head = new Node(3);
		head.next = new Node(1);
		head.next.next = new Node(4);
		head.next.next.next = new Node(2);
		head = selectionSort(head);
		printLinkedList(head);

	}

}
