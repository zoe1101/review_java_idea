package 链表问题;


/*
 * 链表是否有环
 * 无环链表是否相交
 * 有环链表是否相交
 */
public class 两个单链表相交的一系列问题 {
	public static class Node{
		public int value;
		public Node next;
		public Node(int val) {
			this.value=val;
		}
	}
	public static Node getIntersectNode(Node head1,Node head2) {
		if (head1==null || head2==null) {
			return null;
		}
		Node loop1=getLoopNode(head1);
		Node loop2=getLoopNode(head2);
		if (loop1==null && loop2==null) { //两个无环链表
			return noLoop(head1, head2);
		}else if (loop1!=null && loop2!=null) { //两个有环链表
			return bothLoop(head1, head2, loop1, loop2);
		}else { //一个有环，一个无环
			return null;
		}
	}
	//判断链表是否有环,如果有，返回第一个进入环的节点，否则返回null
	public static Node getLoopNode(Node head) {
		if (head==null || head.next==null || head.next.next==null) {
			return null;
		}
		Node slow=head.next;
		Node fast=head.next.next;
		while (slow!=fast) { //判断时候有环
			if (fast.next==null || fast.next.next==null) { //无环的情况
				return null;
			}
			slow=slow.next;
			fast=fast.next.next;
		}
		//有环的情况下，让fast回到head，然后每次走两步去追击slow
		fast=head;
		while (fast!=slow) {
			slow=slow.next;
			fast=fast.next;
		}
		return slow;
	}
	//无环链表是否相交
	public static Node noLoop(Node head1,Node head2) {
		if (head1==null ||head2==null) {
			return null;
		}
		Node cur1Node=head1;
		Node cur2Node=head2;
		int n=0; //记录两个链表长度的差值
		while (cur1Node.next!=null) {
			n++;
			cur1Node=cur1Node.next;
		}
		while (cur2Node.next!=null) {
			n--;
			cur2Node=cur2Node.next;
		}
		if (cur1Node!=cur2Node) {//两个链表尾节点不同，则不相交
			return null;
		}
		cur1Node=n>0?head1:head2; //cur1Node表示长度较长的链表
		cur2Node=cur1Node==head1?head2:head1; //cur2Node表示长度较短的链表
		n=Math.abs(n);
		while (n!=0) { //让长度较长的链表先走差值步
			cur1Node=cur1Node.next;
			n--;
		}
		while (cur1Node!=cur2Node) { //找到公共起点
			cur1Node=cur1Node.next;
			cur2Node=cur2Node.next;
		}
		return cur1Node;
	}

	//有环链表是否相交
	public static Node bothLoop(Node head1,Node head2,Node loop1,Node loop2) {
		Node cur1Node=null;
		Node cur2Node=null;
		if (loop1==loop2) {
			cur1Node=head1;
			cur2Node=head2;
			int n=0;
			while (cur1Node!=loop1) {
				n++;
				cur1Node=cur1Node.next;
			}
			while (cur2Node!=loop2) {
				n--;
				cur2Node=cur2Node.next;
			}
			cur1Node=n>0?head1:head2;
			cur2Node=cur1Node==head1?head2:head1;
			n=Math.abs(n);
			while (n>0) {
				n--;
				cur1Node=cur1Node.next;
			}
			while (cur1Node!=cur2Node) {
				cur1Node=cur1Node.next;
				cur2Node=cur2Node.next;
			}
			return cur1Node;
		}else {
			cur1Node=loop1.next;
			while (cur1Node!=loop1) {
				if (cur1Node==loop2) {
					return loop1;
				}
				cur1Node=cur1Node.next;
			}
			return null;
		}
	}
	
	public static void main(String[] args) {
		// 1->2->3->4->5->6->7->null
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);

		// 0->9->8->6->7->null
		Node head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).value);

		// 1->2->3->4->5->6->7->4...
		head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);
		head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

		// 0->9->8->2...
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next; // 8->2
		System.out.println(getIntersectNode(head1, head2).value);

		// 0->9->8->6->4->5->6..
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).value);

	}
}
