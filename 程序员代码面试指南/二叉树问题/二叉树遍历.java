package 二叉树问题;

import java.util.Stack;

public class 二叉树遍历 {
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node(int data) {
			this.value=data;
		}
	}
	//递归先序遍历,根,左,右
	public static void preOrderRecur(Node head) {
		if(head==null) {
			return;
		}
		System.out.print(head.value+" ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}

	//非递归先序遍历,左,根,右
	public static void preOrderUnRecur(Node head) {
		while (head!=null) {
			Stack<Node> stack=new Stack<Node>();
			stack.push(head);
			while (!stack.isEmpty()) {
				head=stack.pop();
				System.out.print(head.value+" ");
				if(head.right!=null) {
					stack.push(head.right);
				}
				if(head.left!=null) {
					stack.push(head.left);
				}
			}
		}
		System.out.println();
	}
	
	//递归中序遍历,根,左,右
	public static void inOrderRecur(Node head) {
		if(head==null) {
			return;
		}
		inOrderRecur(head.left);
		System.out.print(head.value+" ");
		inOrderRecur(head.right);
	}
	

	//非递归中序遍历,根,左,右
	public static void inOrderUnRecur(Node head) {
		while(head!=null) {
			Stack<Node> stack=new Stack<Node>();
			while (!stack.isEmpty() || head!=null) {
				if(head!=null) {
					stack.push(head);
					head=head.left;
				}else {
					head=stack.pop();
					System.out.print(head.value+" ");
					head=head.right;
				}
			}
		}
		System.out.println();
	}
	
	//递归后序遍历,左,右,根
	public static void posOrderRecur(Node head) {
		if(head==null) {
			return;
		}
		posOrderRecur(head.left);
		posOrderRecur(head.right);
		System.out.print(head.value+" ");
	}
	
	//非递归后序遍历,左,右,根
		public static void posOrderUnRecur(Node head) {
			if(head!=null) {
				Stack<Node> stack=new Stack<Node>();
				stack.push(head); //head:最近一次弹出并打印的元素
				Node cNode=null; //栈顶元素
				while (!stack.isEmpty()) {
					cNode=stack.peek();
					if(cNode.left!=null && head!=cNode.left && head!=cNode.right){
						stack.push(cNode.left);
					}else if(cNode.right!=null && head!=cNode.right) {
						stack.push(cNode.right);
					}else {
						System.out.print(stack.pop().value+" ");
					}
				}
			}
			System.out.println();
		}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
