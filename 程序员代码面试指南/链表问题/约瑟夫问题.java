package 链表问题;
//N个人围成一圈，从第一个人开始报数，报到m的人出圈，剩下的人继续从1开始报数，报到m的人出圈；如此往复，直到所有人出圈。

public class 约瑟夫问题 {
	public static class Node { //单链表
		public int value;
		public Node next;
		public Node(int data) {
			this.value=data;
		}
	}
	
//	时间复杂度: O(n*m)
	public static Node josephusKill1(Node head,int m) {
		if(head==null || head.next==head || m<1) return head;
		Node lastNode=head;
		while (lastNode.next!=head) {
			lastNode=lastNode.next;
		}
		int count=0;
		while (head!=lastNode) {
			if(++count==m) {//报数到m时，就删除当前报数为m的节点
				lastNode.next=head.next;
			}else {
				lastNode=lastNode.next;
			}
			head=head.next;
		}
		return head;
	}
	
	//递归求解, 时间复杂度:O(n)
	public static Node josephusKill2(Node head,int m) {
		if(head==null || head.next==head || m<1) return head;
		Node curNode=head.next;
		int temp=1;
		while (curNode!=head) {
			temp++;
			curNode=curNode.next;
		}
		temp=getLive(temp,m); //存活结点位置
		while (--temp!=0) { //找到存活节点
			head=head.next;
		}
		head.next=head;//构造环形
		return head;
	}
	public static int getLive(int i,int m) {
		if(i==1) {
			return 1;
		}
		return (getLive(i-1, m)+m-1)%i+1;
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
