package 链表问题;

public class 链表划分 {
	public static class Node{
		public int val;
		public Node next;
		public Node(int val) {
			this.val=val;
		}
	}
	//不考虑先后顺序
	public static Node listPartition1(Node head,int pivot) {
		if (head==null) {
			return head;
		}
		Node curNode=head;
		int n=0;
		while (curNode!=null) {
			n++;
			curNode=curNode.next;
		}
		Node[] nodeArr=new Node[n];
		curNode=head;
		for (int i = 0; i <n; i++) {
			nodeArr[i]=curNode;
			curNode=curNode.next;
		}
		arrPartition(nodeArr, pivot);
		for (int i = 1; i < n; i++) {
			nodeArr[i-1].next=nodeArr[i];
		}
		nodeArr[n-1].next=null;
		return nodeArr[0];

	}
	
	//考虑先后顺序,分成三个链表
	public static Node listPartition2(Node head,int pivot) {
		Node smallhead=null; //用于标记链表是否为null
		Node smalltail=null;
		Node equalhead=null;
		Node equaltail=null;
		Node bighead=null;
		Node bigtail=null;
		Node nextnode=null;
		while (head!=null) {
			nextnode=head.next;
			head.next=null;
			if (head.val<pivot) {
				if (smallhead==null) {
					smallhead=head;
					smalltail=head;
				}else {
					smalltail.next=head;
					smalltail=head;
				}
			}else if (head.val==pivot) {
				if (equalhead==null) {
					equalhead=head;
					equaltail=head;
				}else {
					equaltail.next=head;
					equaltail=head;
				}
			}else {
				if (bighead==null) {
					bighead=head;
					bigtail=head;
				}else {
					bigtail.next=head;
					bigtail=head;
				}
			}
			head=nextnode;
		}
		//小于部分链表与等于部分的链表进行连接
		if (smalltail!=null) {
			smalltail.next=equalhead;
			equaltail=equaltail==null?smalltail:equaltail;
		}
		//等于部分链表与大于部分的链表进行连接
		if (equaltail!=null) {
			equaltail.next=bighead;
		}
		return smalltail!=null?smallhead:equalhead!=null?equalhead:bighead;
	}
	public static void arrPartition(Node[] nodeArr,int pivot) {
		int small=-1;
		int big=nodeArr.length;
		int index=0;
		while (index!=big) {
			if (nodeArr[index].val<pivot) {
				swap(nodeArr, ++small, index++);
			}else if (nodeArr[index].val==pivot) {
				index++;
			}else {
				swap(nodeArr, --big, index);
			}
		}
		
	}
	public static void swap(Node[] nodeArr,int a,int b) {
		Node tempNode=nodeArr[a];
		nodeArr[a]=nodeArr[b];
		nodeArr[b]=tempNode;
	}
	public static void printLinkedList(Node node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Node head1 = new Node(7);
		head1.next = new Node(9);
		head1.next.next = new Node(1);
		head1.next.next.next = new Node(8);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(2);
		head1.next.next.next.next.next.next = new Node(5);
		printLinkedList(head1);
		head1 = listPartition1(head1, 4);
		printLinkedList(head1);
		head1 = listPartition2(head1, 5);
		printLinkedList(head1);

	}

}
