package 图;

import java.util.LinkedList;
import java.util.Queue;

public class 广度优先遍历 {
	public static class ListNode {
		ListNode left;
        ListNode right;
        int val;
        public ListNode(int value){
            this.val=value;
        }
	}
	public void levelOrderTraversal(ListNode node){
		if(node==null) {
			 System.out.print("empty tree");
            return;
		}
		
		Queue<ListNode> queue=new LinkedList<ListNode>();
		queue.add(node);
		if(!queue.isEmpty()) {
			ListNode popNode=queue.remove();
			System.out.print(popNode.val+"  ");
			if(popNode.left!=null) {
				queue.add(popNode.left);
			}
			if(popNode.right!=null) {
				queue.add(popNode.right);
			}
		}
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
