package 树;

import java.util.ArrayList;
import java.util.List;

/*
给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
示例 1:

输入:
    2
   / \
  1   3
输出: true
 */

public class 验证二叉搜索树 {
	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	//采用递归方法进行中序遍历，如果是二叉查找树，遍历结果应该是升序的。
    public boolean isValidBST(TreeNode root) {
        if (root==null) {
			return true;
		}
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        for (int i = 0; i < list.size(); i++) {
			if (i!=0) {
				if (list.get(i-1)>=list.get(i)) {
					return false;
				}
			}
		}
        return true;
    }
	private void inOrder(TreeNode root, List<Integer> list) {
		if (root==null) {
			return ;
		}
		inOrder(root.left, list);
		list.add(root.val);
		inOrder(root.right, list);
	}
}
