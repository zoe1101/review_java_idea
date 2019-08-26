package 树;
/*
给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。

示例 1:

给定二叉树 [3,9,20,null,null,15,7]

    3
   / \
  9  20
    /  \
   15   7
返回 true 。

 */

import 树.从前序与中序遍历序列构造二叉树.TreeNode;
public class 平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        if (root==null) {
			return true;
		}
        return Math.abs(depth(root.left)-depth(root.right))<=1 
        		&& isBalanced(root.left)
        		&& isBalanced(root.right);
    }
    //返回以节点root为根的树的高度
    private int depth(TreeNode root){
    	 if (root==null) {
    		 return 0;
    	 }
    	 return Math.max(depth(root.left), depth(root.right))+1;
    }
}
