package src;
/*
输入一个链表，反转链表后，输出新链表的表头。
 */
//防止链表断开。故我们需要定义3个指针，分别指向当前遍历到的结点、它的前一个结点及后一个结点。
//故反转结束后，新链表的头的结点就是原来链表的尾部结点。尾部结点为m_pNext为null的结点。
public class 反转链表 {
	public static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
	//熟悉这种
	public static ListNode ReverseList(ListNode head) {
		if (head==null || head.next==null) {
			return head;
		}
		ListNode pre=null;
		ListNode next=null;
		while (head!=null) {
			next=head.next;
			head.next=pre;
			pre=head;
			head=next;
		}
		return pre;
	}

	public static ListNode ReverseList2(ListNode head) {
		ListNode curNode=head;//当前节点
		ListNode preNode=null;//前一个节点
		ListNode reverseNode=null;//反转过后的单链表存储头结点
		while(curNode!=null) {
			ListNode nextNode=curNode.next;//后一个节点
			if(nextNode==null) {
				reverseNode=curNode;
			}
			curNode.next=preNode; //修改curNode的指针域指向preNode
			preNode=curNode; //将curNode结点复制给preNode
			curNode=nextNode;  //将curNode的下一个结点复制给curNode

		}
		return reverseNode;
	}
	//递归写法
	public static ListNode ReverseList1(ListNode head) {
		if(head==null || head.next==null) { //如果没有结点或者只有一个结点直接返回head
			return head;
		}

		ListNode nextNode=head.next; //保存当前结点的下一结点
		head.next=null;
		ListNode reverseNode=ReverseList1(nextNode); //递归结束时reverseHead一定是新链表的头结点
		nextNode.next=head;
		return reverseNode;
	}

}
