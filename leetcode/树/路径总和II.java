package 树;
import java.util.ArrayList;
import java.util.List;

/*
给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

说明: 叶子节点是指没有子节点的节点。

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]

 */
//回溯算法
import 树.从前序与中序遍历序列构造二叉树.TreeNode;
public class 路径总和II {
	List<List<Integer>> res= new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	if(root==null) {
            return res;
    	}
    	List<Integer> tmp = new ArrayList<>();
    	findPath(root,sum,tmp);
    	return res;
    }
	private void findPath(TreeNode root, int sum, List<Integer> tmp) {
		if (root==null) {
			return ;
		}
		if(root.left==null&&root.right==null&&sum==root.val){
			tmp.add(root.val);
			res.add(new ArrayList<Integer>(tmp));
			tmp.remove(tmp.size()-1);
			return ;
		}
		tmp.add(root.val);
		findPath(root.left, sum-root.val, tmp);
		findPath(root.right, sum-root.val, tmp);
		tmp.remove(tmp.size()-1);
	}
}
