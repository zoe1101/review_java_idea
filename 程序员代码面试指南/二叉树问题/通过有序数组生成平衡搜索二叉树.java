package 二叉树问题;

import 二叉树问题.二叉树遍历.Node;

public class 通过有序数组生成平衡搜索二叉树 {
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node(int data) {
			this.value=data;
		}
	}
	public static Node generateTree(int[] sortArr) {
		if(sortArr==null) return null;
		return generate(sortArr,0,sortArr.length-1);
	
	}
	//选取有序数组的中间值为头结点，左边的用于构建左子树，右边的用于构建右子树
	public static Node generate(int[] sortArr,int start,int end) {
		if(start>end) return null;
		int mid=(start+end)/2;
		Node head=new Node(sortArr[mid]);
		head.left=generate(sortArr,start,end-1);
		head.right=generate(sortArr,start+1,end);
		return head;
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
