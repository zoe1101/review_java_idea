package src;

/**
 * 求链表的中间节点，如果长度为奇数，返回中间节点；如果长度为偶数，返回中间两个节点的任意一个
 * @author ZOE
 * @date 2019/8/9 16:27
 */
public class 链表的中间节点 {
    public static  class ListNode{
        public int val;
        public ListNode next;
        public ListNode(int val){
            this.val=val;
        }
    }
    //快慢指针
    public static ListNode getMiddumNode(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;
        while (fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(6);
        System.out.println(getMiddumNode(head).val);
    }
}
