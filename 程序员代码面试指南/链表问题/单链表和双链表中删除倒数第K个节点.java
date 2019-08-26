package 链表问题;


public class 单链表和双链表中删除倒数第K个节点 {
	public static class Node { //单链表
		public int value;
		public Node next;
		public Node(int data) {
			this.value=data;
		}
	}
	
	public static class DoubleNode { //双向链表
		public int value;
		public DoubleNode next;
		public DoubleNode last;
		public DoubleNode(int data) {
			this.value=data;
		}
	}
	 //单链表删除
	public static Node removeLastKthNode(Node head,int k) {
		if(head==null || k<1) {
			return head;
		}
		Node curNode=head;
		while (curNode!=null) {
			k--;
			curNode=curNode.next;
		}
		if (k==0) {
			head=head.next;
		}
		if(k<0) {
			curNode=head;
			while (++k!=0) {
				curNode=curNode.next;
			}
			curNode.next=curNode.next.next;
		}
		return head;
	}
	//双向链表
	public static DoubleNode removeLastKthNode2(DoubleNode head,int k) {
		if(head==null || k<1) {
			return head;
		}
		DoubleNode curNode=head;
		while (curNode!=null) {
			k--;
			curNode=curNode.next;
		}
		if(k==0) {
			head=head.next;
			head.last=null;
		}
		if(k<0) {
			curNode=head;
			while (++k!=0) {
				curNode=curNode.next;
			}
			DoubleNode newNextNode=curNode.next.next;
			curNode.next=newNextNode;
			if(newNextNode!=null) {
				newNextNode.last=curNode;
			}
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
	
	public static void printDoubleLinkedList(DoubleNode head) {
		System.out.print("Double Linked List: ");
		DoubleNode end = null;
		while (head != null) {
			System.out.print(head.value + " ");
			end = head;
			head = head.next;
		}
		System.out.print("| ");
		while (end != null) {
			System.out.print(end.value + " ");
			end = end.last;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		printLinkedList(head1);
		head1 = removeLastKthNode(head1, 3);
		// head1 = removeLastKthNode(head1, 6);
		// head1 = removeLastKthNode(head1, 7);
		printLinkedList(head1);

		DoubleNode head2 = new DoubleNode(1);
		head2.next = new DoubleNode(2);
		head2.next.last = head2;
		head2.next.next = new DoubleNode(3);
		head2.next.next.last = head2.next;
		head2.next.next.next = new DoubleNode(4);
		head2.next.next.next.last = head2.next.next;
		head2.next.next.next.next = new DoubleNode(5);
		head2.next.next.next.next.last = head2.next.next.next;
		head2.next.next.next.next.next = new DoubleNode(6);
		head2.next.next.next.next.next.last = head2.next.next.next.next;
		printDoubleLinkedList(head2);
		head2 = removeLastKthNode2(head2, 3);
		// head2 = removeLastKthNode(head2, 6);
		// head2 = removeLastKthNode(head2, 7);
		printDoubleLinkedList(head2);

	}

}
