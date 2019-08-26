package 图;

import java.util.Stack;

//以二叉树为例

public class 深度优先遍历 {

	public static class ListNode {
		ListNode left;
        ListNode right;
        int val;
        public ListNode(int value){
            this.val=value;
        }
	}

	public static void depthTraversal(ListNode node) {
		if(node==null) {
			 System.out.print("empty tree");
             return;
		}
		Stack<ListNode> stack = new Stack<ListNode>();
	       stack.push(node); //先把根节点压入栈
	       while(!stack.isEmpty()){
	             ListNode rnode = stack.pop();
	             System.out.print(rnode.val);
	             if(rnode.right!=null){
	                   stack.push(rnode.right);
	             }
	             if(rnode.left!=null){
	                   stack.push(rnode.left);
	             }
	       }
	}
	    
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
