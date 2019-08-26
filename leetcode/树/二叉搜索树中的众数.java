package 树;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。

假定 BST 有如下定义：

结点左子树中所含结点的值小于等于当前结点的值
结点右子树中所含结点的值大于等于当前结点的值
左子树和右子树都是二叉搜索树
例如：
给定 BST [1,null,2,2],

   1
    \
     2
    /
   2
返回[2].

 */
import 树.从前序与中序遍历序列构造二叉树.TreeNode;
public class 二叉搜索树中的众数 {
	List<Integer> res = new ArrayList<>();
	TreeNode pre;
	int curTimes=1,maxTimes=1;
    public int[] findMode(TreeNode root) {
    	if (root==null) {
			return new int[] {};
		}
    	inorder(root);
    	int[] ans=new int[res.size()]; 
    	for (int i = 0; i <res.size(); i++) {
    		ans[i]=res.get(i);
		}
    	return ans;
    }
    private void inorder(TreeNode root) {
    	if (root==null) {
			return ;
		}
    	inorder(root.left);
    	if (pre!=null) {
			if (pre.val==root.val) {
				curTimes++;
			}else {
				curTimes=1;
			}
		}
    	if (curTimes==maxTimes) {
			res.add(root.val);
		}
    	if (curTimes>maxTimes) {
			res.clear();
			res.add(root.val);
			maxTimes=curTimes;
		}
    	pre=root;
    	inorder(root.right);
    }
}
