package 链表;
/*
 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：
给定一个链表: 1->2->3->4->5, 和 n = 2.
当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class 删除链表的倒数第N个节点 {
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { 
	    	  this.val = x; 
    	  }
	}
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode curNode=head;
		while (curNode!=null) {
			n--;
			curNode=curNode.next;
		}
		//目标是找到第N-n个节点
		//一次遍历后，n=n-N, N：链表长度
		if (n==0) { //要删除的是第一个节点
			head=head.next;
		}
		if (n<0) {
			curNode=head;
			while (++n!=0) {
				curNode=curNode.next;
			}
			curNode.next=curNode.next.next; //删除倒数第n个节点
		}
		return head;
	        
    }

}
