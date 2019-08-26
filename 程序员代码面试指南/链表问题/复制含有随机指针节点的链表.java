package 链表问题;

import java.util.HashMap;

public class 复制含有随机指针节点的链表 {
	public static class Node{
		public int value;
		public Node next;
		public Node rand;
		public Node(int val) {
			this.value=val;
		}
	}
	//使用哈希表
	public static Node copyListWithRand1(Node head) {
		HashMap<Node, Node> map=new HashMap<Node,Node>();//源节点与副本节点对应
		Node curNode=head;
		while (curNode!=null) {
			map.put(curNode, new Node(curNode.value));
			curNode=curNode.next;
		}
		curNode=head;
		while (curNode!=null) {
			map.get(curNode).next=map.get(curNode.next);
			map.get(curNode).rand=map.get(curNode.rand);
			curNode=curNode.next;
		}
		return map.get(head);
	}
	//对原链表进行扩充,每个结点紧跟着复制一份
	public static Node copyListWithRand2(Node head) {
		if (head==null) {
			return null;
		}
		Node curNode=head;
		Node nextNode=null;
		//复制并链接每一个结点
		while (curNode!=null) {
			nextNode=curNode.next;
			curNode.next=new Node(curNode.value);
			curNode.next.next=nextNode;
			curNode=nextNode;
		}
		
		curNode=head;
		//设置复制结点的rand指针
		Node curCopy=null;
		while (curNode!=null) {
			nextNode=curNode.next.next;
			curCopy=curNode.next;
			curCopy.rand=curNode.rand!=null?curNode.rand.next:null;
			curCopy=nextNode;
		}
		Node res=head.next;
		curNode=head;
		//将原链表与复制链表拆分
		while (curNode!=null) {
			nextNode=curNode.next.next;
			curCopy=curNode.next;
			curNode.next=nextNode;
			curCopy.next=nextNode!=null?nextNode.next:null;
			curNode=nextNode;
		}
		return res;
	}
	
	public static void printRandLinkedList(Node head) {
		Node cur = head;
		System.out.print("order: ");
		while (cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
		System.out.println();
		cur = head;
		System.out.print("rand:  ");
		while (cur != null) {
			System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
			cur = cur.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head = null;
		Node res1 = null;
		Node res2 = null;
		printRandLinkedList(head);
		res1 = copyListWithRand1(head);
		printRandLinkedList(res1);
		res2 = copyListWithRand2(head);
		printRandLinkedList(res2);
		printRandLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);

		head.rand = head.next.next.next.next.next; // 1 -> 6
		head.next.rand = head.next.next.next.next.next; // 2 -> 6
		head.next.next.rand = head.next.next.next.next; // 3 -> 5
		head.next.next.next.rand = head.next.next; // 4 -> 3
		head.next.next.next.next.rand = null; // 5 -> null
		head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

		printRandLinkedList(head);
		res1 = copyListWithRand1(head);
		printRandLinkedList(res1);
		res2 = copyListWithRand2(head);
		printRandLinkedList(res2);
		printRandLinkedList(head);
		System.out.println("=========================");

	}
}
