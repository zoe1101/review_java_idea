package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class 序列化二叉树 {
	public class TreeNode {
		public int val;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }

	}
//	先序遍历
//	"!":节点结束标志
//	"#!":空节点
  String Serialize(TreeNode root) {
        if (root==null) {
			return "#!";
		}
        String res=root.val+"!";
        res+=Serialize(root.left);
        res+=Serialize(root.right);
        return res;
  }
    TreeNode Deserialize(String str) {
       String[] valStrings=str.split("!");
       Queue<String> queue=new LinkedList<String>();
       for(int i=0;i<valStrings.length;i++) {
    	   queue.offer(valStrings[i]);
       }
       return reconPreOrder(queue);
       
  }
    public TreeNode reconPreOrder(Queue<String> queue) {
    	String value=queue.poll();
    	if(value.equals("#")){
    		return null;
    	}
    	TreeNode head=new TreeNode(Integer.valueOf(value));
    	head.left=reconPreOrder(queue);
    	head.right=reconPreOrder(queue);
		return head;
	}
}
