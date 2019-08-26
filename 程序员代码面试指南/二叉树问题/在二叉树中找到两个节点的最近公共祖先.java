package 二叉树问题;
import 二叉树问题.判断t1树是否包含t2树全部的拓扑结构.Node;

public class 在二叉树中找到两个节点的最近公共祖先 {
//	在二叉树中找到两个节点的最近公共祖先
//  利用后续遍历实现，因为后序遍历是左右根的结构
	public static Node lowsetAncestor(Node head, Node o1,Node o2) {
		if (head==null || head==o1 || head==o2) {
			return head;
		}
		Node left=lowsetAncestor(head.left, o1, o2); //在左子树是否找到了o1，或o2
		Node right=lowsetAncestor(head.right, o1, o2);//在右子树是否找到了o1，或o2
		if (left!=null && right!=null) {
			return head;
		}
		return left!=null?left:right;
	}
}
