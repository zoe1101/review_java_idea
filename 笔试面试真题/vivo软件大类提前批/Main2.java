package vivo软件大类提前批;

//一个单向链表，输入m,n，要求在第m和第n区间之内的元素倒序存储并输出此链表。
//链表的部分反转
public class Main2 {
	public static class Node{
		public int value;
		public Node next;
		public Node(int val) {
			this.value=val;
		}
	}
	public static Node Solution(Node root,int m,int n) {
		if (root==null || root.next==null) {
			return root;
		}
		int len=0;
		Node newroot=root;  //新头
		Node mpre=null; //m的前一个节点
		Node npos=null; //n的后一个节点
		while (newroot!=null) { 
			len++;
			//找到m的前一个节点与n的后一个节点
			mpre=len==m-1?newroot:mpre;
			npos=len==n+1?newroot:npos;
			newroot=newroot.next;
		}
		if (m>n || m<0 || n>len-1) {
			return newroot;
		}
		newroot=mpre==null?root:mpre.next; //需要反转部分的头结点
		Node curnode=newroot.next;
		newroot.next=npos; //反转结束位置的下一个节点
		Node next=null;
		//【m,n】之间的反转
		while (curnode!=npos) {
			next=curnode.next; //当前节点的下一个节点
			curnode.next=newroot; //将当前节点的下一个节点指向其前一个节点
			newroot=curnode; //当前节点的前一个节点变为当前节点
			curnode=next; //更新当前节点
		}
		if (mpre!=null) {
			mpre.next=newroot;
			return root;
		}
		return newroot;
		
	}

}
