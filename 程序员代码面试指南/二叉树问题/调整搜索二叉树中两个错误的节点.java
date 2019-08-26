package 二叉树问题;

import java.util.Stack;

public class 调整搜索二叉树中两个错误的节点 {
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node(int val) {
			this.value=val;
		}
	}
	//找到错误节点
//	利用中序遍历思想
	public static Node[] getTwoErrNodes(Node head) {
		Node[] errNodes=new Node[2];
		if (head==null) {
			return errNodes;
		}
		Stack<Node> stack=new Stack<Node>();
		Node preNode=null;
		while (!stack.isEmpty() || head!=null) {
			if (head!=null) {
				stack.push(head);
				head=head.left;
			}else {
				head=stack.pop();
				if (preNode!=null && preNode.value>head.value) {
					errNodes[0]=errNodes[0]==null?preNode:errNodes[0];
					errNodes[1]=head;
				}
				preNode=head;
				head=head.right;
			}
		}
		return errNodes;
	}
	
	//调整搜索二叉树为正确的，需要先找到错误节点的父节点
	public static Node recoverTree(Node head) {
		Node[] errs = getTwoErrNodes(head);
		Node[] parents = getTwoErrParents(head, errs[0], errs[1]);
		Node e1 = errs[0];
		Node e1P = parents[0];
		Node e1L = e1.left;
		Node e1R = e1.right;
		Node e2 = errs[1];
		Node e2P = parents[1];
		Node e2L = e2.left;
		Node e2R = e2.right;
		if (e1 == head) {
			if (e1 == e2P) { // 情况一
				e1.left = e2L;
				e1.right = e2R;
				e2.right = e1;
				e2.left = e1L;
			} else if (e2P.left == e2) { // 情况二
				e2P.left = e1;
				e2.left = e1L;
				e2.right = e1R;
				e1.left = e2L;
				e1.right = e2R;
			} else { // 情况三
				e2P.right = e1;
				e2.left = e1L;
				e2.right = e1R;
				e1.left = e2L;
				e1.right = e2R;
			}
			head = e2;
		} else if (e2 == head) {
			if (e2 == e1P) { // 情况四
				e2.left = e1L;
				e2.right = e1R;
				e1.left = e2;
				e1.right = e2R;
			} else if (e1P.left == e1) { // 情况五
				e1P.left = e2;
				e1.left = e2L;
				e1.right = e2R;
				e2.left = e1L;
				e2.right = e1R;
			} else { // 情况六
				e1P.right = e2;
				e1.left = e2L;
				e1.right = e2R;
				e2.left = e1L;
				e2.right = e1R;
			}
			head = e1;
		} else {
			if (e1 == e2P) {
				if (e1P.left == e1) { // 情况七
					e1P.left = e2;
					e1.left = e2L;
					e1.right = e2R;
					e2.left = e1L;
					e2.right = e1;
				} else { // 情况八
					e1P.right = e2;
					e1.left = e2L;
					e1.right = e2R;
					e2.left = e1L;
					e2.right = e1;
				}
			} else if (e2 == e1P) {
				if (e2P.left == e2) { // 情况九
					e2P.left = e1;
					e2.left = e1L;
					e2.right = e1R;
					e1.left = e2;
					e1.right = e2R;
				} else { // 情况十
					e2P.right = e1;
					e2.left = e1L;
					e2.right = e1R;
					e1.left = e2;
					e1.right = e2R;
				}
			} else {
				if (e1P.left == e1) {
					if (e2P.left == e2) { // 情况十一
						e1.left = e2L;
						e1.right = e2R;
						e2.left = e1L;
						e2.right = e1R;
						e1P.left = e2;
						e2P.left = e1;
					} else { // 情况十二
						e1.left = e2L;
						e1.right = e2R;
						e2.left = e1L;
						e2.right = e1R;
						e1P.left = e2;
						e2P.right = e1;
					}
				} else {
					if (e2P.left == e2) { // 情况十三
						e1.left = e2L;
						e1.right = e2R;
						e2.left = e1L;
						e2.right = e1R;
						e1P.right = e2;
						e2P.left = e1;
					} else { // 情况十四
						e1.left = e2L;
						e1.right = e2R;
						e2.left = e1L;
						e2.right = e1R;
						e1P.right = e2;
						e2P.right = e1;
					}
				}
			}
		}
		return head;
	}
	public static Node[] getTwoErrParents(Node head,Node e1,Node e2) {
		Node[] parentNodes=new Node[2];
		if (head==null) {
			return parentNodes;
		}
		Stack<Node> stack=new Stack<调整搜索二叉树中两个错误的节点.Node>();
		while (!stack.isEmpty() ||head!=null) {
			if (head!=null) {
				stack.push(head);
				head=head.left;
			}else {
				head=stack.pop();
				if (head.left==e1 || head.right==e1) {
					parentNodes[0]=head;
				}
				if (head.left==e2 || head.right==e2) {
					parentNodes[1]=head;
				}
				head=head.right;
			}
		}
		return parentNodes;
	}
	
}
