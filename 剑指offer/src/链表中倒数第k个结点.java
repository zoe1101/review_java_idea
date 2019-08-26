package src;


/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * @author zoe
 *为了能够只遍历一次就能找到倒数第k个节点，可以定义两个指针：
　　（1）第一个指针从链表的头指针开始遍历向前走k-1，第二个指针保持不动；
　　（2）从第k步开始，第二个指针也开始从链表的头指针开始遍历；
　　（3）由于两个指针的距离保持在k-1，当第一个（走在前面的）指针到达链表的尾结点时，第二个指针（走在后面的）指针正好是倒数第k个结点。
 */
public class 链表中倒数第k个结点 {
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
    public ListNode FindKthToTail(ListNode head,int k) {
    	if(head==null || k==0) {
    		return null;
    	}
    	ListNode ahead=head;
    	ListNode behind=null;
    	for(int i=0;i<k-1;i++) { //第一个指针先走k-1步
    		if(ahead.next!=null) {
    			ahead=ahead.next;
    		}else {
    			return null;
    		}
    	}
    	behind=head;
    	while (ahead.next!=null) {
			ahead=ahead.next;
			behind=behind.next;
		}
    	return behind;
    }
}
