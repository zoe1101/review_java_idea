package src;
//给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
public class 链表中环的入口结点 {
	 public class ListNode {
		    int val;
		    ListNode next = null;
	
		    ListNode(int val) {
		        this.val = val;
		    }
		}
	 
	 //借助快慢指针
//1、设置快慢指针，假如有环，他们最后一定相遇。
//2、两个指针分别从链表头和相遇点继续出发，每次走一步，最后一定在环入口相遇。
    public ListNode EntryNodeOfLoop(ListNode pHead){
    	ListNode fast=pHead;
    	ListNode slow=pHead;
    	while (fast!=null && fast.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow) { //相遇了
				break;
			}
		}
    	if (fast==null || fast.next==null) {
			return null;
		}
    	slow=pHead;
    	while (fast!=slow) { //找到环入口
			fast=fast.next;
			slow=slow.next;
		}
    	return slow;
    }
}
