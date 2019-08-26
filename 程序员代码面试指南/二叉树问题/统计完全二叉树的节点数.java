package 二叉树问题;


public class 统计完全二叉树的节点数 {
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node(int val) {
			this.value=val;
		}
	}
	public static int nodeNum(Node head) {
		if (head==null) {
			return 0;
		}
		return bs(head, 1, mostLeftLevel(head, 1));
	}
	public static int bs(Node node,int layer,int height) {
		if (layer==height) {
			return layer;
		}
		if (mostLeftLevel(node.right,layer+1)==height) {//发现当前节点到达最后一层
			//当前节点的整个左子树都是满二叉树，且陈述为height-layer,对应节点2^(height-layer)
		    //bs(node.right, layer+1, height)：当前节点右子树的节点个数
			return (layer<<(height-layer)+bs(node.right, layer+1, height));
		}else {//发现当前节点没有到达最后一层
			//layer<<(height-layer-1)：当前节点的整个右子树为满二叉树，节点个数2^(height-layer-1)
			//bs(node.left, layer+1, height)：当前节点的左子树的节点数
			return (layer<<(height-layer-1)+bs(node.left, layer+1, height));
		}
		
	}
	//找到右子树的最左节点
	public static int mostLeftLevel(Node node,int level) {
		while (node!=null) {
			level++;
			node=node.left;
		}
		return level-1;
	}
}
