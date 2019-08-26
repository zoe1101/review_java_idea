package 树;

//时间复杂度为O(N), 额外空间复杂度为O(1)
//利用的是线索二叉树思想
public class Morris遍历二叉树 {
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int val) {
			this.val=val;
		}
	}
	/**
	 * Morris序  , 存在重复打印的情况
	 * @param node
	 */
	public static void morrisTraversal(TreeNode node) {
		if(node==null) return;
		TreeNode curNode=node;
		TreeNode mostRightNode=null;
		while (curNode!=null) {
			mostRightNode=curNode.right;  
			if(mostRightNode!=null) {//当前节点有左子树
				//找到当前节点左子树的最右的节点
				while(mostRightNode.right!=null &&mostRightNode.right!=curNode) {
					mostRightNode=mostRightNode.right;
				}
				if(mostRightNode.right==null) {
					mostRightNode.right=curNode;
					curNode=curNode.left;
					continue; //回到最外层的while，继续判断curNode的情况
				}else { //最右的节点指向当前节点时
					mostRightNode.right=null;
				}
			}
			curNode=curNode.right; //当前节点没有左子树或其左子树最右节点的右指针指向当前节点时，则向右移动
		}
	}
    /** Morris 先序遍历二叉树(第一次发现节点就打印：①左子树的右孩子为空时打印 ②无左子树时打印)
	 * @param node
	 */
	public static void preorderMorrisTraversal(TreeNode node) {
		if(node==null) {
			System.out.println("树为空");
			return;
		}
		TreeNode cur=node;
		TreeNode mostRight=null;
		while (cur!=null) {
			mostRight=cur.left;
			if(mostRight!=null) {
				while (mostRight.right!=null & mostRight.right!=cur) {//找到左子树的最右节点
					mostRight=mostRight.right;
				}
				if(mostRight.right==null) { //最右点的右指针指向null
					mostRight.right=cur; //右指针指向当前节点
					System.out.print(cur.val + " ");
					cur=cur.left;  //当前node向左孩子移动
					continue; //回到最外层的while，继续判断curNode的情况
				}else { //最右点的右指针已经指向当前节点，让它指向null
					mostRight.right=null;
				}
			}else {
				System.out.print(cur.val + " ");
			}
			cur = cur.right;              //当前node向右孩子移动
		}
		System.out.println();
	}
	
	/**
	 * Morris中序遍历二叉树(node每次往右移之前打印节点)
	 * @param node
	 */
	public static void inorderMorrisTraversal(TreeNode node) {
		if(node==null) {
			System.out.println("树为空");
			return;
		}
		TreeNode cur=node;//当前节点
		TreeNode mostRight = null;//当前节点左子树最右的节点
		while (cur!=null) {
			mostRight=cur.left;
			if(mostRight!=null) { //有左子树
				while (mostRight.right!=null && mostRight.right!=cur) {//找到左子树的最右节点
					mostRight=mostRight.right;
				}
				if(mostRight.right==null) { //说明该左子树已处理完毕，恢复原指针
					mostRight.right=cur;
					cur=cur.left;
					continue;
				}else { //该节点的左子树已处理完毕,转向右子树
					mostRight.right=null;
				}
			}
			System.out.print(cur.val+" ");
			cur=cur.right;
		}
		System.out.println();
	}
	
	/**
	 *Morris后序遍历二叉树(当第二次回到node时，逆序打印左子树的右边界，在打印整树的右边界) 
	 * @param node
	 */
	public static void postorderMorrisTraversal(TreeNode node) {
		if(node==null) {
			System.out.println("树为空");
			return;
		}
		TreeNode cur=node;
		TreeNode mostRight=null;
		while (cur!=null){
			mostRight=cur.left;
			if(mostRight!=null) {
				while (mostRight.right!=null && mostRight.right!=cur) {
					mostRight=mostRight.right;
				}
				if(mostRight.right==null) {
					mostRight.right=cur;
					cur=cur.left;
					continue;
				}else {//第二次到达时
					mostRight.right=null;
					printEdge(cur.left);
				}
			}
			cur=cur.right;
		}
		printEdge(node);
		System.out.println();
	}
	
	public static void printEdge(TreeNode head) {
		TreeNode tail = reverseEdge(head);
		TreeNode cur = tail;
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.right;
		}
		reverseEdge(tail);
	}
	
	public static TreeNode reverseEdge(TreeNode from) {
		TreeNode pre = null;
		TreeNode next = null;
		while (from != null) {
			next = from.right;
			from.right = pre;
			pre = from;
			from = next;
		}
		return pre;
	}

	// print tree
		public static void printTree(TreeNode head) {
			System.out.println("Binary Tree:");
			printInOrder(head, 0, "H", 17);
			System.out.println();
		}
	 
		public static void printInOrder(TreeNode head, int height, String to, int len) {
			if (head == null) {
				return;
			}
			printInOrder(head.right, height + 1, "v", len);
			String val = to + head.val + to;
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
		TreeNode head = new TreeNode(4);
		head.left = new TreeNode(2);
		head.right = new TreeNode(6);
		head.left.left = new TreeNode(1);
		head.left.right = new TreeNode(3);
		head.right.left = new TreeNode(5);
		head.right.right = new TreeNode(7);
		printTree(head);
		preorderMorrisTraversal(head);
		inorderMorrisTraversal(head);
		postorderMorrisTraversal(head);
		printTree(head);
	}

}
