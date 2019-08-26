package src;
/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @author zoe
 *
 */
public class 二叉搜索树与双向链表 {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	/*
	在搜索二叉树中，左子结点的值总是小于父结点的值，右子结点的值总大于父结点的值，
	因此我们在转换成排序双向链表时，原先指向左子结点的指针调整为链表中前一个结点的指针，
	原先指向右子结点的指针调整为链表中指向后一个结点指针。 
	
	中序遍历树中每一个结点
	当遍历到根节点时，应将它与其左子树中最大结点和其右子树中最小的结点相连。
	而此时，根节点的左子树已经是一个排序的链表了，并且链表最后一个结点是左子树中最大的，将其与根节点相连。
	遍历右子树时，将它与右子树中最小的结点相连。
	 */
    TreeNode pCurNode=null; //定义链表当前结点
    TreeNode pHead = null; //定义链表头部的结点
  //中序递归遍历修改链表指针即可实现
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null) {
        	return null;
        }
        Convert(pRootOfTree.left); //左子树
        if(pCurNode==null) {//根节点
        	pCurNode=pRootOfTree;
        	pHead=pRootOfTree;
        }else {
        	pCurNode.right=pRootOfTree; 
        	pRootOfTree.left=pCurNode; 
        	pCurNode=pRootOfTree;
        }
        Convert(pRootOfTree.right); 
        return pHead;
    }
}
