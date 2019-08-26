package 链表问题;

public class  删除链表的中间节点和a除b处的节点{
	public static class Node { //单链表
		public int value;
		public Node next;
		public Node(int data) {
			this.value=data;
		}
	}
	//删除中间节点
	public static Node removeMidNode(Node head) {
		if(head==null ||head.next==null) { //链表为空或只有一个节点
			return head;
		}
		if(head.next.next==null) {//链表有2个节点
			return head.next; //删除头结点
		}
		Node preNode=head; //有删除的节点的前一个节点
		Node curNode=head.next.next;
		while(curNode.next!=null && curNode.next.next!=null) {
			preNode=preNode.next;
			curNode=curNode.next.next;
		}
		preNode.next=preNode.next.next;
		return head;
	}
	//删除a/b的节点
	public static Node removeByRadio(Node head,int a,int b) {
		if(a<1 || a>b) {
			return head;
		}
		int n=0;
		Node curNode=head;
		while (curNode.next!=null) {
			n++;
			curNode=curNode.next;
		}
		n=(int) Math.ceil((double) n*a/(double) b); //需要删除哪个元素
		if(n==1) {
			head=head.next;
		}
		if(n>1) {
			curNode=head;
			while(--n!=1) {
				curNode=curNode.next;
			}
			curNode.next=curNode.next.next;
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
		Node head=new Node(1);
		head.next=new Node(2);
		head.next.next=new Node(3);
		head.next.next.next=new Node(4);
		head.next.next.next.next=new Node(5);
		printLinkedList(head);
		head = removeMidNode(head);
		printLinkedList(head);
		head = removeByRadio(head, 2, 5);
		printLinkedList(head);
		head = removeByRadio(head, 1, 3);
		printLinkedList(head);

	}

}
