package 树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层次遍历如下：
[
  [3],
  [20,9],
  [15,7]
]
 *
 */
public class 二叉树的锯齿形层次遍历 {
//利用广度优先遍历
	public class TreeNode {
	   int val;
	   TreeNode left;
	   TreeNode right;
	   TreeNode(int x) { val = x; }
	}
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> resList=new ArrayList<List<Integer>>();
    	if (root==null) {
			return resList;
		}
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int index = 1; //奇偶判断
        while (!queue.isEmpty()) {
            int size = queue.size(); //每一行的元素个数
            List<Integer> one = new ArrayList<>();
            while (size-- > 0) {
                TreeNode curNode = queue.poll();
                one.add(curNode.val);
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            if (index % 2 == 0) { //偶数行需要逆转
                Collections.reverse(one);
            }
            index++;
            resList.add(one);
        }
        return resList;
    }
}
