package 树;
/*
给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，
并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
一般来说，删除节点可分为两个步骤：

首先找到需要删除的节点；
如果找到了，删除它。
说明： 要求算法时间复杂度为 O(h)，h 为树的高度。

示例:
root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。

一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
    5
   / \
  4   6
 /     \
2       7

另一个正确答案是 [5,2,6,null,4,null,7]。
    5
   / \
  2   6
   \   \
    4   7

 */
import 树.从前序与中序遍历序列构造二叉树.TreeNode;
public class 删除二叉搜索树中的节点 {
	/*
采用递归删除 先找到节点，判断节点的左右根节点的情况：
如果待删节点的左孩子为空，就将右孩子返回给待删节点的父节点。
如果待删节点的右孩子为空，就将左孩子返回给待删节点的父节点。
如果都不为空，在待删节点的右子树中找到最小值节点，将此节点删下来，代替待删节点。
	 */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null) {
        	 return null;
		}
        if (key < root.val) {// 待删除节点在左子树中
        	root.left=deleteNode(root.left, key);
        	return root;
        }else if (key>root.val) { // 待删除节点在右子树中
			root.right=deleteNode(root.right, key);
			return root;
		}else{//root.val==key
	        if (root.left==null) {//如果待删节点的左孩子为空
				return root.right;// 返回右子树作为新的根
			}else if (root.right==null) {//如果待删节点的右孩子为空
				return root.left;// 返回左子树作为新的根
			}else {// 左右子树都存在，返回后继节点（右子树最左叶子）作为新的根,替换删除法
				TreeNode successor=findMin(root.right);
		        successor.right=deleteMin(root.right);
		        successor.left=root.left;
		        return successor;
			}
		}
        
    }

	private TreeNode deleteMin(TreeNode node) {
		if (node==null) {
			return null;
		}
        if (node.left==null) {
        	return node.right;
        }
        node.left=deleteMin(node.left);
        return node;
	}
//	右子树最左叶子节点
	private TreeNode findMin(TreeNode node) {
		if (node==null||node.left==null) {
			return node;
		}
        return findMin(node.left);
	}
}
