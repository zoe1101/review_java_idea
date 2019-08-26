package 树;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的后序遍历 {
	 public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
    }
	List<Integer> resList=new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
		if (root==null) {
			return resList;
		}
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		resList.add(root.val);
		return resList;
	        
    }
}
