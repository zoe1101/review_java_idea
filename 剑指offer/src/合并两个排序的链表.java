package src;
/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @author zoe
 *
 */
public class 合并两个排序的链表 {
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
    public ListNode Merge(ListNode head1,ListNode head2) {
        if(head1==null || head2==null) {
        	return head1==null?head2:head1;
        }
//      先比较1，2的头结点中值的大小，将小的值的结点（比如为链表1头结点）作为合并后的链表（链表3）的头结点。
        ListNode head=head1.val<head2.val?head1:head2;
        ListNode cur1=head==head1?head1:head2; 
        ListNode cur2=head==head1?head2:head1; 
        ListNode pre=null;
        ListNode next=null;
        while (cur1!=null && cur2!=null) {
			if(cur1.val<=cur2.val) {
				pre=cur1;
				cur1=cur1.next;
			}else {
				next=cur2.next;
				pre.next=cur2;
				cur2.next=cur1;
				pre=cur2;
				cur2=next;
			}
		}
        pre.next=cur1==null?cur2:cur1;  //如果链表1先走完，把链表二剩余部分拼在head后面
        return head;
    }
}
