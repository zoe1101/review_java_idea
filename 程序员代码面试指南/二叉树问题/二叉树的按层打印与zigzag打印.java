package 二叉树问题;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的按层打印与zigzag打印 {
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		
	    public Node(int val) {
	        this.value = val;
	    }
	}
//	按层打印
	public static void printByLevel(Node head) {
		if (head==null) {
			return;
		}
		Queue<Node> queue=new LinkedList<Node>();
		int level=1; //当前行
		Node last=head; //正在打印的当前行的最后节点
		Node nlast=null;//下一行的最后节点
		queue.offer(head);
		System.out.print("Level "+(level++)+" : ");
		while (!queue.isEmpty()) {
			head=queue.poll();
			System.out.print(head.value+" ");
			if (head.left!=null) {
				queue.offer(head.left);
				nlast=head.left;
			}
			if (head.right!=null) {
				queue.offer(head.right);
				nlast=head.right;
			}
			if (head==last&&!queue.isEmpty()) { //该换行了
				System.out.print("\nLevel "+(level++)+" :");
				last=nlast;
			}
		}
		System.out.println();
	}
	
//	zigzag打印
	public static void printByZigZag(Node head) {
		if (head==null) {
			return;
		}
		Deque<Node> deque=new LinkedList<Node>();
		int level=1;
		boolean lr=true; //从左到右的方向
		Node last=head;
		Node nlast=null;
		deque.offerFirst(head);
		printLevelAndOrientation(level++, lr);
		while (!deque.isEmpty()) {
			if (lr) {//从左到右的方向
				head=deque.pollFirst();
				if (head.left!=null) {
					nlast=nlast==null?head.left:nlast;
					deque.offerLast(head.left);
				}
				if (head.right!=null) {
					nlast=nlast==null?head.right:nlast;
					deque.offerLast(head.right);
				}
			}else {//从右到左
				head=deque.pollLast();
				if (head.right!=null) {
					nlast=nlast==null?head.right:nlast;
					deque.offerFirst(head.right);
				}
				if (head.left!=null) {
					nlast=nlast==null?head.left:nlast;
					deque.offerFirst(head.left);
				}
			}
			System.out.print(head.value+" ");
			if (head==last && !deque.isEmpty()) {
				lr=!lr;
				last=nlast;
				nlast=null;
				System.out.println();
				printLevelAndOrientation(level++,lr);
			}
		}
		System.out.println();
	}
	

	public static void printLevelAndOrientation(int level,boolean lr) {
		System.out.print("Level "+level+" from ");
		System.out.print(lr? "left to right: ": "right to left: ");
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.right.left = new Node(5);
		head.right.right = new Node(6);
		head.right.left.left = new Node(7);
		head.right.left.right = new Node(8);

		System.out.println("===============");
		printByLevel(head);

		System.out.println("===============");
		printByZigZag(head);

	}
}
