package 树;

import 树.二叉树的最大深度.TreeNode;

/*
给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明: 叶子节点是指没有子节点的节点。

示例:

给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回它的最小深度  2.

 */
public class 二叉树的最小深度 {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
    public int minDepth(TreeNode root) {
        if (root==null) {
			return 0;
		}
        int leftmin=minDepth(root.left);
        int rightmin=minDepth(root.right);
        
        return (leftmin!=0 && rightmin!=0) ? 1+Math.min(leftmin,rightmin):1+leftmin+rightmin;
    }
}
