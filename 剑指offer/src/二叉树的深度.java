package src;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * @author zoe
 *
 */
public class 二叉树的深度 {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	 //递归
    public int TreeDepth(TreeNode root) {
        if (root==null) {
			return 0;
		}
        int left=TreeDepth(root.left); //左子树的深度
        int right=TreeDepth(root.right); //右子树的深度
        return left>right?left+1:right+1;
    }
    
    //非递归,广度优先遍历/层序遍历
    public int TreeDepth2(TreeNode root) {
    	if (root==null) {
			return 0;
		}
    	int depth=0;
    	Queue<TreeNode> queue=new LinkedList<TreeNode>();
    	queue.offer(root); //先把根节点加进去
    	while (!queue.isEmpty()) {
			int size=queue.size();
			TreeNode curNode=null;
			for(int i=0;i<size;i++) {
				curNode=queue.poll();
				if(curNode.left!=null) {
					queue.offer(curNode.left);
				}
				if(curNode.right!=null) {
					queue.offer(curNode.right);
				}
			}
			depth++;
		}
    	return depth;
    }
}
