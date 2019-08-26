package src;

/*
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class 删除链表中重复的结点 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode deleteDuplication(ListNode pHead){
        if (pHead == null) {
			return null;
		}
        ListNode first = new ListNode(-1); //注意备用头结点, 头结点可能被删除
        first.next = pHead;
        ListNode curNode = pHead;
        ListNode preNode = first;  //前节点,初始化为null
        
        while(curNode!=null && curNode.next!=null) {
            if(curNode.next.val==curNode.val){
                int val=curNode.val; //记录val用于判断后面节点是否重复
                while(curNode !=null && curNode.val==val){ //用于跳过相等的节点,用于删除
                    curNode=curNode.next;
                }
                preNode.next=curNode;//删除操作,前节点的next直接等于现在的节点, 把中间的节点直接跨过
            }else{
                preNode=curNode;
                curNode=curNode.next;
            }
        }
         return first.next; //返回表头
    }
}
