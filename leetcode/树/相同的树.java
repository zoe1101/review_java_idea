package 树;

import 树.恢复二叉搜索树.TreeNode;

/*
给定两个二叉树，编写一个函数来检验它们是否相同。
如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

输入:       1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

输出: true
 */
public class 相同的树 {
	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null) {
			return true;
		}
        if (p!=null && q!=null && p.val==q.val) {
        	return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
		}else {
	        return false;
		}
    }
}
