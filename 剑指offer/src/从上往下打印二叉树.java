package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 层序遍历二叉树
 * @author zoe
 *
 */
public class 从上往下打印二叉树 {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	// 根据层序遍历的特点，我们很容易想到使用队列，利用广度优先遍历的方式，进行遍历
	
//	非递归实现
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    	//创建一个list用来接收需要打印的节点的val
        ArrayList<Integer> list= new ArrayList<Integer>();
        if(root==null) {
        	return list;
        }
        ArrayList<TreeNode> queue=new ArrayList<TreeNode>(); //创建一个queue来辅助打印节点的顺序
        queue.add(root);//首先将二叉树的根节点传入到辅助队列中
      
        while (queue.size()!=0) {//循环结束的条件队列为空
			TreeNode tmp=queue.remove(0);//ArrayList 的remove是删除该节点并将该节点返回
			if(tmp.left!=null) {
				queue.add(tmp.left);
			}
			if(tmp.right!=null) {
				queue.add(tmp.right);
			}
			list.add(tmp.val);
		}
        return list;
    }
}
