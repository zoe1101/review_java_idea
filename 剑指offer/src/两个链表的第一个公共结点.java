package src;

import java.util.Stack;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * @author zoe
 *如果两个链表存在公共结点，那么它们从公共结点开始一直到链表的结尾都是一样的
 */
public class 两个链表的第一个公共结点 {
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	//借用栈
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    	 Stack<ListNode> stack1=new Stack<ListNode>();
    	 Stack<ListNode> stack2=new Stack<ListNode>();
    	 while (pHead1!=null) {
			stack1.push(pHead1);
			pHead1=pHead1.next;
		}
      	 while (pHead2!=null) {
 			stack2.push(pHead2);
 			pHead2=pHead2.next;
 		}
      	 
      	 ListNode res=null;
      	 while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek()==stack2.peek()) {
			stack1.pop();
			res=stack2.pop();
		}
      	 return res;
    }
    
//先找出2个链表的长度,然后让长的先走两个链表的长度差,然后再一起走,直到找到第一个公共结点。
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
    	if(pHead1 == null || pHead2 == null) {
            return null;
    	}
    	int count1=0;
    	int count2=0;
    	ListNode p1=pHead1;
    	ListNode p2=pHead2;
    	while (p1!=null) {
			p1=p1.next;
			count1++;
		}
    	while (p2!=null) {
			p2=p2.next;
			count2++;
		}
    	if(count1>count2) {
    		int dif=count1-count2;
    		while (dif!=0) {
				pHead1=pHead1.next;
				dif--;
			}
    	}else {
    		int dif=count2-count1;
    		while (dif!=0) {
				pHead2=pHead2.next;
				dif--;
			}
		}
    	while (pHead1!=null &&pHead2!=null) {
			if(pHead1==pHead2) {
				return pHead1;
			}
			pHead1=pHead1.next;
			pHead2=pHead2.next;
		}
    	return null;
    }
}
