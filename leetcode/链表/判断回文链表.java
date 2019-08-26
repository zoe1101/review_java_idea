package 链表;

import java.util.Stack;


/*
请判断一个链表是否为回文链表。

输入: 1->2->2->1
输出: true

用 O(n) 时间复杂度和 O(1) 空间复杂度
 */
//使用快慢指针找到链表的中点
public class 判断回文链表 {
	
//	利用快慢指针找到中间，然后将链表的后半部分反转，再依次进行比较.
	//这个要快一些
    public static boolean isPalindrome(ListNode head) {
        if(head==null ||head.next==null) return true;
        ListNode fast=head; //快指针
        ListNode slow=head;  //慢指针
        // 根据快慢指针，找到链表的中点
        while(fast.next!=null &&fast.next.next!=null) {
        	fast=fast.next.next; //一次移动两步
        	slow=slow.next;      //一次移动一步
        }
        fast=slow.next; //后半部分的第一个节点
        slow.next=null;
        ListNode right=null;
        while (fast!=null) { //链表后半部分反转
			right=fast.next; //right->保存下一个节点
			fast.next=slow; //下一个反转节点
			slow=fast; //慢指针移动
			fast=right;  //快指针移动
		}
        right=slow;
        fast=head;
        boolean res=true;
        
        while (slow!=null && fast!=null) { //判断是否是回文的
        	if(slow.val!=fast.val) {
        		return false;
        	}
        	fast=head.next; //从右到中部
        	slow=slow.next;	 //从左到中部	
		}
        slow=right.next;
        right.next=null;
        while (slow!=null) {//链表恢复
			fast=slow.next;
			slow.next=right;
			right=slow;
			slow=fast;
		}
        return res;
    }
    
    
    //利用栈把链表的前半段压栈，然后出栈与链表的后半段逐个比对。
    //找中间位置的方法是快慢指针。
    public static boolean isPalindrome2(ListNode head) {
    	if(head==null ||head.next==null) return true;
    	Stack<ListNode> stack=new Stack<ListNode>();
    	ListNode fast=head;
    	ListNode slow=head;
    	 //利用栈的思想
    	while (fast!=null && fast.next!=null ) {
			stack.push(slow);
			slow=slow.next;
			fast=fast.next.next;
		}
    	//如果为奇数个
    	if(fast!=null) {
    		slow=slow.next;
    	}
    	while(!stack.isEmpty()) {
    		if(stack.pop().val!=slow.val) {
    			return false;
    		}
    		slow=slow.next;
    	}
    	return true;
    }
    	
	public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        System.out.println(isPalindrome2(node1));
        System.out.println(isPalindrome(node1));
	}

}
