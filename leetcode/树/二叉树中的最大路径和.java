package 树;
/*
给定一个非空二叉树，返回其最大路径和。

本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。

示例 1:

输入: [1,2,3]

       1
      / \
     2   3

输出: 6

 */
import 树.从前序与中序遍历序列构造二叉树.TreeNode;
public class 二叉树中的最大路径和 {
    /**
    对于任意一个节点, 如果最大和路径包含该节点, 那么只可能是两种情况:
    1. 其左右子树中所构成的和路径值较大的那个加上该节点的值后向父节点回溯构成最大路径
    2. 左右子树都在最大路径中, 加上该节点的值构成了最终的最大路径
    **/
	private int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
    	getMax(root);
        return res;
    }
	private int getMax(TreeNode root) {
		if (root==null) {
			return 0;
		}
		int left=Math.max(0, getMax(root.left)); // 如果子树路径和为负则应当置0表示最大路径不包含子树
		int right=Math.max(0, getMax(root.right));
        //以当前节点为根节点,判断在该节点包含左右子树的路径和是否大于当前最大路径和
		res=Math.max(res, root.val+left+right);
        //当前节点作为父节点的一个子节点和父节点连接的话则需取【单端的最大值】返回
		return Math.max(left, right)+root.val;
		
	}
}
