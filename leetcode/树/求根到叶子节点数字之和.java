package 树;
import 树.从前序与中序遍历序列构造二叉树.TreeNode;
/*
给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。

例如，从根到叶子节点路径 1->2->3 代表数字 123。

计算从根到叶子节点生成的所有数字之和。

说明: 叶子节点是指没有子节点的节点。

示例 1:

输入: [1,2,3]
    1
   / \
  2   3
输出: 25
解释:
从根到叶子节点路径 1->2 代表数字 12.
从根到叶子节点路径 1->3 代表数字 13.
因此，数字总和 = 12 + 13 = 25.

 */

public class 求根到叶子节点数字之和 {
    public int sumNumbers(TreeNode root) {
        return addNums(0,root);
    }

	private int addNums(int cursum, TreeNode root) {
		if(root==null) {
			return 0;
		}
		if (root.right==null && root.left==null) {
			return cursum*10+root.val;
		}
		return addNums(cursum*10+root.val, root.left)+addNums(cursum*10+root.val, root.right);
	}
}
