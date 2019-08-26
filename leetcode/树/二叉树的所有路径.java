package 树;
import java.util.ArrayList;
import java.util.List;

import 树.验证二叉搜索树.TreeNode;
/*
给定一个二叉树，返回所有从根节点到叶子节点的路径。
说明: 叶子节点是指没有子节点的节点。

示例:
输入:

   1
 /   \
2     3
 \
  5

输出: ["1->2->5", "1->3"]
解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3

 */
public class 二叉树的所有路径 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<String>();
        if (root==null) {
			return res;
		}
        process(root,res,"");
        return res;
    }

	private void process(TreeNode root, List<String> res,String str) {
		if (root==null) {
			return ;
		}
		String s=str+String.valueOf(root.val)+"->";
		if (root.left==null && root.right==null) {
			res.add(s.substring(0,s.length()-2)); //s.length()-2)是为了删除最后的“->”
		}
		process(root.left, res, s);
		process(root.right, res, s);
	}
}
