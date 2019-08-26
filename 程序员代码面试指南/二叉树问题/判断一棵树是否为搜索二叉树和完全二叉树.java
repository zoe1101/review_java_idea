package 二叉树问题;
import java.util.LinkedList;
import java.util.Queue;
import 二叉树问题.判断t1树是否包含t2树全部的拓扑结构.Node;

public class 判断一棵树是否为搜索二叉树和完全二叉树 {
//	判断是否是搜索二叉树
	public static boolean isBST(Node head) {
		if (head==null) {
			return true;
		}
		boolean res=true;
		Node preNode=null; //当前节点的前一个节点
		Node cur1Node=head; //当前节点
		Node cur2Node=null; //前驱节点,当前节点左子树最右的节点
		while (cur1Node!=null) {
			cur2Node=cur1Node.left;
//			如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点。
			if (cur2Node!=null) {
				while (cur2Node.right!=null &&cur2Node.right!=cur1Node) {
					cur2Node=cur2Node.right;
				}
//				如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。当前节点更新为当前节点的左孩子。
				if (cur2Node.right==null) {
					cur2Node.right=cur1Node;
					cur1Node=cur1Node.left;
					continue;
				}
//				如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空（恢复树的形状）。
				else {
					cur2Node.right=null;
				}
			}
//			判断是否满足递增要求
			if (preNode!=null && preNode.value>cur1Node.value) {
				return false;
			}
			
//			如果当前节点的左孩子为空，则输出当前节点并将其右孩子作为当前节点。
			preNode=cur1Node;//节点更新
			cur1Node=cur1Node.right;
		}
		return res;
	}
//判断是否是完全二叉树
	public static boolean isCBT(Node head) {
		if (head==null) {
			return true;
		}
		Queue<Node> queue=new LinkedList<Node>();
		boolean leaf=false;
		Node leftNode=null;
		Node rightNode=null;
		queue.offer(head);
		while (!queue.isEmpty()) {
			head=queue.poll();
			leftNode=head.left;
			rightNode=head.right;
			//是叶子结点，但左孩子或右孩子不为空
			//左孩子节点为空，但右孩子不为空
			if ((leaf && (leftNode!=null || rightNode!=null)) || (leftNode==null && rightNode!=null)) {
				return false;
			}
			if (leftNode!=null) {
				queue.offer(leftNode);
			}
			if (rightNode!=null) {
				queue.offer(rightNode);
			}else {
				leaf=true;
			}
		}
		return true;
	}
}
