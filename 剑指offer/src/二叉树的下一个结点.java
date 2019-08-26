package src;
/*
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class 二叉树的下一个结点 {
	public class TreeLinkNode {
	    int val;
	    TreeLinkNode left = null;
	    TreeLinkNode right = null;
	    TreeLinkNode next = null;

	    TreeLinkNode(int val) {
	        this.val = val;
	    }
	}
	
/*
1、如果该结点有右子树，则该结点的下一个结点为该结点的右子树的最左结点。
2、如果该结点没有右子树，则又分两种情况讨论：
情况一：如果该结点为该结点的父结点的左孩子，则该结点的父结点pNode.next则为下一个结点。
情况二：如果该结点为该结点的父结点的右孩子，则该结点的父结点的父结点的父结点，
 	    直到其中的一个父结点是这个父结点的左孩子，则该父结点的父结点为下一个结点。
 * 
 */
    public TreeLinkNode GetNext(TreeLinkNode pNode){
    	if (pNode==null) {
			return null;
		}
    	if(pNode.right!=null) {//如果该结点有右子树
    		pNode=pNode.right;
    		while (pNode.left!=null) {
				pNode=pNode.left;
			}
    		return pNode;
    	}
    	while (pNode.next!=null) {
			if (pNode.next.left==pNode) { //该结点为该结点的父结点的左孩子
				return pNode.next;
			}
			pNode=pNode.next;
		}
    	return null;  
    }
}
