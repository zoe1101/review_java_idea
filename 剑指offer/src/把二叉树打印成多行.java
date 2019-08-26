package src;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * 
 * 层次结构打印:队列实现
 * 需要两个变量，一个start记录当前层已经打印的节点个数，一个end记录前当层所有的节点个数，
 * 当 start == end 时，表示当前层遍历完了，就可以开始下一层遍历。
 */

public class 把二叉树打印成多行 {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
    	ArrayList<ArrayList<Integer> > res = new ArrayList<ArrayList<Integer> >();
    	if (pRoot==null) {
    		return res;
		}
    	ArrayList<Integer> temp=new ArrayList<Integer>();
    	Queue<TreeNode> layer=new LinkedList<TreeNode>(); //按层存节点
    	layer.offer(pRoot); //第一层,一个节点
    	int start=0, end=1;
    	while (!layer.isEmpty()) {
			TreeNode node=layer.poll();
			temp.add(node.val);
			start++;
			//在当前层的节点弹出过程中，将下一层的节点进行入队操作
			if (node.left!=null) {
				layer.add(node.left);
			}
			if (node.right!=null) {
				layer.add(node.right);
			}
			//当前层节点弹出完了，对当前层暂存列表temp,位置指向start，end重置
			if(start==end) {
				start=0;
				res.add(temp);
				temp=new ArrayList<Integer>();
				end=layer.size();
			}
		}
    	return res;
    }
}
