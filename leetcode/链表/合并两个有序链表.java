package 链表;
/*
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 * @author zoe
 *
 */
public class 合并两个有序链表 {
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if (l1==null || l2==null) {
			return l1!=null?l1:l2;
		}
    	ListNode head = new ListNode(0);
        ListNode res = head;
        while (l1!=null && l2!=null) {
			if (l1.val<l2.val) {
				head.next=l1;
				l1=l1.next;
			}else {
				head.next=l2;
				l2=l2.next;
			}
			head=head.next;
		}
        if (l1!=null) {
			head.next=l1;
		}
        if (l2!=null) {
			head.next=l2;
		}
        return res.next;
        
    }
    //递归实现
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
    	if (l1==null || l2==null) {
			return l1!=null?l1:l2;
		}
	    ListNode head = null;//declare head as new Node,use to return.
	    if (l1.val <= l2.val){
	        head = l1;
	        head.next = mergeTwoLists2(l1.next, l2);
	    } else {
	        head = l2;
	        head.next = mergeTwoLists2(l1, l2.next);
	    }
	    return head;
    }
}
