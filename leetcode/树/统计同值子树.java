package 树;
/*
 Given a binary tree, count the number of uni-value subtrees.
A Uni-value subtree means all nodes of the subtree have the same value.

For example:
Given binary tree,

              5
             / \
            1   5
           / \   \
          5   5   5
return 4.

给一个二叉树，求唯一值子树的个数。唯一值子树的所有节点具有相同值。
 */

import 树.验证二叉搜索树.TreeNode;
public class 统计同值子树 {
	public int countUnivalSubtrees(TreeNode root) {
        int count =0;
        isUnivalSubtrees(root,count);
        return count;
    }
     
    private boolean isUnivalSubtrees(TreeNode root, int count) {
        if(root == null) return true;
        if(isUnivalSubtrees(root.left, count) && isUnivalSubtrees(root.right, count)) {
            if(root.left != null && root.left.val != root.val ||
        	   root.right != null && root.right.val != root.val) {
                return false;
            }
            count++;
            return true;
        }
        return false;
    }
}
