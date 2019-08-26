package 树;
/*
Given a binary tree, collect a tree's nodes as if you were doing this: 
Collect and remove all leaves, repeat until the tree is empty.

Example:
Given binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Returns [4, 5, 3], [2], [1].

Explanation:
1. Removing the leaves [4, 5, 3] would result in this tree:

          1
         / 
        2          
2. Now removing the leaf [2] would result in this tree:

          1          
3. Now removing the leaf [1] would result in the empty tree:

          []         
Returns [4, 5, 3], [2], [1].
 */

import java.util.ArrayList;
import java.util.List;

import 树.验证二叉搜索树.TreeNode;
public class 寻找完全二叉树的叶子节点 {
	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> resLists=new ArrayList<>();
		height(root,resLists);
		return resLists;
	}
//计算当前node到leaf的距离为当前node的高度，相同高度的点放在同一个list里.
	private int height(TreeNode root, List<List<Integer>> resLists) {
		if (root==null) {
			return -1;
		}
		int h=Math.max(height(root.left, resLists), height(root.left, resLists))+1;
		if (resLists.size()<=h) {
			resLists.add(new ArrayList<Integer>());
		}
		resLists.get(h).add(root.val);
		return h;
	}
}
