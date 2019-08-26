package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*
给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
 */
public class 二叉树的层次遍历 {
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
   }
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> resList=new ArrayList<List<Integer>>();
    	if (root==null) {
			return resList;
		}
    	
    	Queue<TreeNode> queue=new LinkedList<TreeNode>();
    	queue.add(root);
    	while (!queue.isEmpty()) {
			int size=queue.size();
			List<Integer> one=new ArrayList<Integer>();
			while (size-->0) {
				TreeNode curNode=queue.poll();
				one.add(curNode.val);
				if (curNode.left!=null) {
					queue.add(curNode.left);
				}
				if (curNode.right!=null) {
					queue.add(curNode.right);
				}
			}
			resList.add(one);
		}
    	return resList;
        
    }
}
