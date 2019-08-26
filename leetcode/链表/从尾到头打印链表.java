package 链表;

import java.util.ArrayList;
import java.util.Stack;

/*
 从尾到头打印链表

输入描述：输入为链表的表头
输出描述：输出为需要打印的“新链表”的表头
 */

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
public class 从尾到头打印链表 {
    public static void  main(String[] args){
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        l1.next=l2;
        l2.next=l3;
        for(int i:printListFromTailToHead(l1)){
            System.out.print(i+ " ");
        }

    }
    
    //选择ArrayList是因为查询效率高
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);  //入栈
            listNode = listNode.next;
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop()); //出栈
        }
        return list;
    }
}