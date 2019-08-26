package 树;

import java.util.HashMap;
import java.util.Map;

/*
在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。


输入：root = [1,2,3,4], x = 4, y = 3
输出：false

输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
输出：true
 */
public class 二叉树的堂兄弟节点 {
	public class TreeNode {
		   int val;
		   TreeNode left;
		   TreeNode right;
		   TreeNode(int x) { val = x; }
		}
	
	//利用哈希表存储当前节点的父节点和所在层次
	Map<Integer,Integer> parentMap = new HashMap<>();
    Map<Integer,Integer> levelMap = new HashMap<>();
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root==null ||(root.left==null && root.right==null)) {
			return false;
		}
        helper(root,null,1,x,y);
        return parentMap.get(x)!=parentMap.get(y) && levelMap.get(x)==levelMap.get(y);
    }
	private void helper(TreeNode root, TreeNode parent, int level, int x, int y) {
		if (root==null) {
			return ;
		}
		if (parent!=null && (root.val==x || root.val==y)) {
			parentMap.put(root.val,parent.val);
			levelMap.put(root.val, level);
		}
		helper(root.left, root, level+1, x, y);
		helper(root.right, root, level+1, x, y);
		
	}
}
