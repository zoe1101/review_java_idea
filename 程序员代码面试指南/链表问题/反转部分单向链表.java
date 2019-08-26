package 链表问题;


public class 反转部分单向链表 {
	public static class Node { //单链表
		public int value;
		public Node next;
		public Node(int data) {
			this.value=data;
		}
	}
	//将[from,to]部分反转
	public static Node reversePart(Node head,int from,int to) {
		int len=0;
		Node node1=head;
		Node fpreNode=null;
		Node tnextNode=null;
		while (head!=null) {
			len++;
			fpreNode= len==from-1 ? node1:fpreNode; //如果在len++的过程中，找到了from前一个，那就将pre定为此时累加到的这个节点
			tnextNode= len==to+1 ? node1:tnextNode; //如果在len++过程中找到了to后面的一个，就赋值为当前点，否则均为null
			node1=node1.next;
		}
		if(from<to || from<1 ||to >len) { //不符合反转条件
			return head;
		}
		node1= fpreNode==null ? head:fpreNode.next; //看是否需要换头,当fpreNode==null时,头结点要换,就是从原头开始换
		Node node2=node1.next; 
		Node next=null;
		while(node2!=tnextNode) {//反转部分
			next=node2.next;
			node2.next=node1;
			node1=node2;
			node2=next;
		}
		if(fpreNode!=null) {  //如果fpreNode存在的时候，接到fpreNode（from-1）后面
			fpreNode.next=node1;
			return head;
		}
		return node1; //否则不用拼接，直接是倒转之后的新头结点
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
