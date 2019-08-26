package 树;

import 树.验证二叉搜索树.TreeNode;

/*
二叉搜索树中的两个节点被错误地交换。
请在不改变其结构的情况下，恢复这棵树。

输入: [1,3,null,null,2]

   1
  /
 3
  \
   2

输出: [3,1,null,null,2]

   3
  /
 1
  \
   2

 */
public class 恢复二叉搜索树 {
	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	//如果对两个节点交换了顺序,那一定有两个地方是不满足前一个元素 < 当前元素 < 后一个元素的
	 TreeNode t1, t2, pre; //错误元素记录
    public void recoverTree(TreeNode root) {
		 inOrder(root);//对错误的二叉树进行中序遍历
		 //将两个错误元素值进行交换
		 int temp = t1.val;
	     t1.val = t2.val;
	     t2.val = temp;
    	 
    }
	private void inOrder(TreeNode root) {
		if (root==null) {
			return;
		}
		inOrder(root.left);
		if (pre!=null && pre.val>root.val) {
			if (t1==null) {
				t1=pre;
			}
			t2=root;
		}
		pre = root;
        inOrder(root.right);
	}
}
