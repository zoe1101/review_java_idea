package 二叉树问题;

import java.util.LinkedList;
import java.util.List;

public class 统计和生成所有不同的二叉树 {
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node(int val) {
			this.value=val;
		}
	}
	/*
	 * 动态规划：统计n个节点所能生成的所有不同的二叉树
	 */
	public static int numsTrees(int n) {
		if (n<2) {
			return 1;
		}
		int[] num=new int[n+1];
		num[0]=1;
		for (int i = 0; i < n+1; i++) {
			for (int j = 1; j <=i; j++) {
				num[i]+=num[j-1]*num[i-j];	//以i为头结点所能生成的搜索二叉树个数
				//num[j-1]：左子树的个数，num[i-j]：右子树的个数
			}
		}
		return num[n];
	}
	/*
	 * n个节点，可能有m个二叉树，返回m个二叉树的头结点
	 */
	public static List<Node> generateTrees(int n) {
		return generate(1, n); 
	}
	public static List<Node> generate(int start,int end) {
		List<Node> resList=new LinkedList<Node>();
		if (start>end) {//没有可以生成的节点了，即到了叶子节点
			resList.add(null);
		}
		Node head=null;
		for (int i = start; i <= end; i++) {  //以i为头结点
			head=new Node(i);
			List<Node> leftSubs=generate(start, i-1);//左子树
			List<Node> rightSubs=generate(i+1, end);//右子树
			//左右子树挨个枚举
			for(Node l:leftSubs) {
				for(Node r:rightSubs) {
					head.left=l;
					head.right=r;
					resList.add(cloneTree(head));
				}
			}
		}
		return resList;
	}
	public static Node cloneTree(Node head) {
		if (head==null) {
			return null;
		}
		Node res=new Node(head.value);
		res.left=cloneTree(head.left);
		res.right=cloneTree(head.right);
		return res;
	}
	// for test -- print tree
	public static void printTree(Node head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}

	public static void printInOrder(Node head, int height, String to, int len) {
		if (head == null) {
			return;
		}
		printInOrder(head.right, height + 1, "v", len);
		String val = to + head.value + to;
		int lenM = val.length();
		int lenL = (len - lenM) / 2;
		int lenR = len - lenM - lenL;
		val = getSpace(lenL) + val + getSpace(lenR);
		System.out.println(getSpace(height * len) + val);
		printInOrder(head.left, height + 1, "^", len);
	}

	public static String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}

	public static void main(String[] args) {
		int n = 4;
		System.out.println(numsTrees(n));
		List<Node> res = generateTrees(n);
		for (Node node : res) {
			printTree(node);
		}
	}
	
}
