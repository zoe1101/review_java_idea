package 树;
import 树.验证二叉搜索树.TreeNode;
/*
翻转一棵二叉树。

示例：

输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1

 */
public class 翻转二叉树 {
	
	//BFS
    public TreeNode invertTree(TreeNode root) {
        if (root==null) {
			return null;
		}
        //交换当前节点左右子节点
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        //继续以左右子节点为父节点进行子节点的反转
        root.left=invertTree(root.left);
        root.right=invertTree(root.right);
        return root;
    }
}
