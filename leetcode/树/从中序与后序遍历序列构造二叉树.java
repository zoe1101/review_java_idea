package 树;

import 树.从前序与中序遍历序列构造二叉树.TreeNode;

public class 从中序与后序遍历序列构造二叉树 {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	return build(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);   
    }
	private TreeNode build(int[] inorder, int[] postorder, int inStart, int inEnd, int posStart) {
		if (inStart>inEnd) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[posStart]);
		int index = 0;
		for (int i = inStart; i <= inEnd; i++) {
			if (postorder[posStart] == inorder[i]) {
				index = i;
			}
		}
		root.left = build(inorder, postorder, inStart, index - 1, posStart - (inEnd - index) - 1);
		root.right = build(inorder, postorder, index + 1, inEnd, posStart - 1);
		return root;
	}
}
