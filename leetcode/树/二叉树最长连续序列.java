package 树;
import 堆.MaxHeap;
/*
描述 
给一棵二叉树，找到最长连续路径的长度。 
这条路径是指 任何的节点序列中的起始节点到树中的任一节点都必须遵循 父-子 联系。
最长的连续路径必须是从父亲节点到孩子节点（不能逆序）。

样例 
举个例子：

   1
    \
     3
    / \
   2   4
        \
         5
1
2
3
4
5
6
7
最长的连续路径为 3-4-5，所以返回 3。

   2
    \
     3
    / 
   2    
  / 
 1
1
2
3
4
5
6
7
最长的连续路径为 2-3 ,而不是 3-2-1 ，所以返回 2。

 */
import 树.验证二叉搜索树.TreeNode;
public class 二叉树最长连续序列 {
	private int maxlen=0;
	public int longestConsecutive(TreeNode root) {
		longestConsecutive(root,0,0);
		return maxlen;
	}
	//递归遍历二叉树，递归函数传入父节点的值，以帮助子节点判断是否连续。
	private void longestConsecutive(TreeNode root, int preVal, int curlen) {
		if (root==null) {
			return;
		}
		if (root.val!=preVal+1) {
			curlen=1;
		}else {
			curlen++;
		}
		maxlen=Math.max(curlen, maxlen);
		longestConsecutive(root.left, root.val, curlen);
		longestConsecutive(root.right, root.val, curlen);
	}
}
