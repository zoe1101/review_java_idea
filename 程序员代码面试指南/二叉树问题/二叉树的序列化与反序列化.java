package 二叉树问题;

import java.util.LinkedList;
import java.util.Queue;
public class 二叉树的序列化与反序列化 {
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		
	    public TreeNode(int val) {
	        this.val = val;
	    }

	}
	//	先序遍历
	//	"!":节点结束标志
	//	"#!":空节点
	  public static String SerializeByPre(TreeNode root) {
	        if (root==null) {
				return "#!";
			}
	        String res=root.val+"!";
	        res+=SerializeByPre(root.left);
	        res+=SerializeByPre(root.right);
	        return res;
	  }
	  
	  public static TreeNode DeserializeByPre(String str) {
	       String[] valStrings=str.split("!");
	       Queue<String> queue=new LinkedList<String>();
	       for(int i=0;i<valStrings.length;i++) {
	    	   queue.offer(valStrings[i]);
	       }
	       return reconPreOrder(queue);
	       
	  }
    public static TreeNode reconPreOrder(Queue<String> queue) {
    	String value=queue.poll();
    	if(value.equals("#")){
    		return null;
    	}
    	TreeNode head=new TreeNode(Integer.valueOf(value));
    	head.left=reconPreOrder(queue);
    	head.right=reconPreOrder(queue);
		return head;
	}
    
//    层次遍历实现，需要用队列结构
    public static String SerializeByLevel(TreeNode root) { //序列化
		if (root==null) {
			return "#!";
		}
		String res=root.val+"!";
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			root=queue.poll();
			if(root.left!=null) {
				res+=root.left.val+"!";
				queue.offer(root.left);
			}else {
				res+="#!";
			}
			if (root.right!=null) {
				res+=root.right.val+"!";
				queue.offer(root.right);
			}else {
				res+="#!";
			}
		}
		return res;
	}
    public static TreeNode DeserializeByLevel(String str) {
    	String[] values=str.split("!");
    	int index=0;
    	TreeNode root=generateNodeByString(values[index++]);
    	Queue<TreeNode> queue=new LinkedList<TreeNode>();
    	if (root!=null) {
			queue.offer(root);
		}
    	TreeNode node=null;
    	while (!queue.isEmpty()) {
			node=queue.poll();
			node.left=generateNodeByString(values[index++]);
			node.right=generateNodeByString(values[index++]);
			if (node.left!=null) {
				queue.offer(node.left);
			}
			if (node.right!=null) {
				queue.offer(node.right);
			}
		}
		return root;
	}
    public static TreeNode generateNodeByString(String val) {
		if(val.equals("#")) {
			return null;
		}
		return new TreeNode(Integer.valueOf(val));
	}
}
