package 二叉树问题;

public class 找到一个节点的前驱结点 {
	public static class Node{
		public int value;
		public Node left;
		public Node right;
		public Node parent;
		public Node(int val) {
			this.value=val;
		}
	}
	public static Node getPreNode(Node node) {
		if (node==null) {
			return node;
		}
		if (node.left!=null) {
			return getRightMost(node.left);
		}else {
			Node parent=node.parent;
			while (parent!=null && parent.right!=node) {
				node=parent;
				parent=node.parent;
			}
			return parent;
		}
	}
	private static Node getRightMost(Node node) {
		if (node==null) {
			return node;
		}
		while (node.right!=null) {
			node=node.right;
		}
		return node;
	}
	
	public static void main(String[] args){
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node( 4 );
        node.left.right = new Node(5);
        node.right.left = new Node( 6 );
        node.right.right = new Node( 7 );
        node.left.left.left = new Node(11);
        node.left.right.right = new Node( 8 );
        node.right.left.right = new Node(9);
        node.right.right.right = new Node(10);
 
        node.parent = null;
        node.left.parent = node;
        node.right.parent = node;
        node.left.left.parent = node.left;
        node.left.right.parent = node.left;
        node.right.left.parent = node.right;
        node.right.right.parent = node.right;
        node.left.left.left.parent = node.left.left;
        node.left.right.right.parent = node.left.right;
        node.right.left.right.parent = node.right.left;
        node.right.right.right.parent = node.right.right;
 
        System.out.println(getPreNode(node.left.right.right).value);
        System.out.println(getPreNode(node.right.left).value);
    }
}
