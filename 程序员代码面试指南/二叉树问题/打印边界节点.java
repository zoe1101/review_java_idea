package 二叉树问题;
/*
标准一：
　　1、头节点为边界节点；
　　2、叶节点为边界节点；
　　3、如果节点在其所在的层中是最左或者最右的，那么也是边界节点。

　　标准二：
　　1、头节点为边界节点；
　　2、叶节点为边界节点；
　　3、树左边界延伸下去的路径为边界节点；
　　4、树右边界延伸下去的路径为边界节点。
 */
public class 打印边界节点 {
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node(int val) {
			this.value=val;
		}
	}
	//标准一
	public static void printEdge1(Node head) {
		if(head==null) return;
		int height=getHeight(head, 0);
		Node[][] edgeMap=new Node[height][2]; //存放每层最左边与最右边的节点
		for (int i = 0; i < edgeMap.length; i++) {//打印左边界
			if(edgeMap[i][0]!=edgeMap[i][0]) {
				System.out.print(edgeMap[i][0].value+" ");
			}
		}
		//		打印叶子结点
		printLeafNotinMap(head, 0, edgeMap);
		for(int i=edgeMap.length-1;i>=0;i--) {
			if(edgeMap[i][0]!=edgeMap[i][0]) {
				System.out.print(edgeMap[i][1].value+" ");
			}
		}
		System.out.println();
	}
    //	得到树的高度
	public static int getHeight(Node head,int l) {
		if(head==null) return l;
		return Math.max(getHeight(head.left, l+1), getHeight(head.right, l+1));
	}
	public static void printLeafNotinMap(Node head,int l,Node[][] map) {
		if(head==null) return;
		if(head.left==null && head.right==null && head !=map[l][0] && head !=map[l][1]) {
			System.out.print(head.value+" ");
		}
		printLeafNotinMap(head.left,l+1,map);
		printLeafNotinMap(head.right,l+1,map);
	}
//	标准二
	public static void printEdge2(Node head) {
		if (head==null) {
			return;
		}
		System.out.print(head.value+" ");
//		找到第一个有两个孩子的节点，因为在这个节点之前只有一个孩子的节点肯定是边界节点，它们的孩子也是边界节点
		if(head.left!=null && head.right!=null) {
			printLeftEdge(head.left, true);//在左子树上找边界节点
			printLeftEdge(head.right, true); //在右子树上找边界节点
		}else {
			printEdge2(head.left!=null?head.left:head.right);
		}
		System.out.println();
	}
//	 打印头节点左子树上的边界节点
	public static void printLeftEdge(Node head,boolean printFlag) {
		if(head==null) return;
		if(printFlag || (head.left==null && head.right==null)) {
			System.out.print(head.value+" ");
		}
		printLeftEdge(head.left,printFlag);
//		如果某个节点有左兄弟，那么它以及它的子树中只有叶子节点才是边界节点
		printLeftEdge(head.right,printFlag && head.left==null?true:false);
	}
	
//	 打印头节点右子树上的边界节点
	public static void printRightEdge(Node head,boolean printFlag) {
		if(head==null) return;
//		 如果某个节点有右兄弟，则它以及它的子树中只有叶子节点是边界节点
		printLeftEdge(head.left,printFlag && head.right==null?true:false);
		printLeftEdge(head.right,printFlag);
		if(printFlag || (head.left==null && head.right==null)) {
			System.out.print(head.value+" ");
		}
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
