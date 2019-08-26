package 链表问题;

import java.util.HashSet;

public class 删除无序链表中值重复出现的节点 {
	public static class Node{
		public int value;
		public Node next;
		public Node(int val) {
			this.value=val;
		}
	}
	//利用哈希表
	public static void removeRep1(Node head) {
		if (head==null) {
			return;
		}
		HashSet<Integer> set=new HashSet<Integer>();
		set.add(head.value);
		Node preNode=head;
		Node curNode=head.next;
		while (curNode!=null) {
			if (set.contains(curNode.value)) {
				preNode.next=curNode.next;
			}else {
				set.add(curNode.value);
				preNode=curNode;
			}
			curNode=curNode.next;
		}
	}
	//依次删除重复节点
	public static void removeRep2(Node head) {
		Node curNode=head;
		Node preNode=null;
		Node nexNode=null;
		while (curNode!=null) {
			preNode=curNode;
			nexNode=curNode.next;
			while (nexNode!=null) {
				if (nexNode.value==curNode.value) {
					preNode.next=nexNode.next;
				}else {
					preNode=nexNode;
				}
				nexNode=nexNode.next;
			}
			curNode=curNode.next;
		}
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
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(4);
		head.next.next.next.next.next = new Node(4);
		head.next.next.next.next.next.next = new Node(2);
		head.next.next.next.next.next.next.next = new Node(1);
		head.next.next.next.next.next.next.next.next = new Node(1);
		removeRep1(head);
		printLinkedList(head);

		head = new Node(1);
		head.next = new Node(1);
		head.next.next = new Node(3);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(4);
		head.next.next.next.next.next = new Node(4);
		head.next.next.next.next.next.next = new Node(2);
		head.next.next.next.next.next.next.next = new Node(1);
		head.next.next.next.next.next.next.next.next = new Node(1);
		removeRep2(head);
		printLinkedList(head);

	}
}
