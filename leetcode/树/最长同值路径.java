package 树;
/*
给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。
 这条路径可以经过也可以不经过根节点。
注意：两个节点之间的路径长度由它们之间的边数表示。


输入:

              5
             / \
            4   5
           / \   \
          1   1   5
输出:
2

 */
import 树.从前序与中序遍历序列构造二叉树.TreeNode;
public class 最长同值路径 {
	private int maxL = 0;
    public int longestUnivaluePath(TreeNode root) {
    	if(root == null) return 0;
        getMaxL(root, root.val);
        return maxL;
    }
	private int getMaxL(TreeNode root, int val) {
		if (root==null) {
			return 0;
		}
		int left = getMaxL(root.left, root.val);
        int right = getMaxL(root.right, root.val);
        maxL = Math.max(maxL, left+right); // 路径长度为节点数减1所以此处不加1
        if(root.val == val) { // 和父节点值相同才返回以当前节点所能构成的最长通知路径长度, 否则返回0
            return Math.max(left, right) + 1;
        }
        return 0;
		
	}
}
