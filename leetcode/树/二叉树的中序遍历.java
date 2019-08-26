package 树;

import java.util.ArrayList;
import java.util.List;

/*
给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
 */
public class 二叉树的中序遍历 {
	 public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
    }
	List<Integer> resList=new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
    	if (root==null) {
			return resList;
		}
    	inorderTraversal(root.left);
    	resList.add(root.val);
    	inorderTraversal(root.right);
    	return resList;
    }


}
