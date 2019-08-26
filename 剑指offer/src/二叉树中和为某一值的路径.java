package src;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 注意: 在返回值的list中，数组长度大的数组靠前
 * @author zoe
 *
 */

public class 二叉树中和为某一值的路径 {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	//使用前序遍历的方式访问节点
	/*
	 * 首先就是要把当前结点（首先是根结点）添加到路径里，同时target 减去当前结点的值；
	 * 然后，如果当前结点为叶节点并且和也达到给定值，就把这个路径添加到列表，否则就一直遍历下去；
	 * 最后，遍历到叶节点之后，返回上层结点之前，一定要把最后一个结点从路径中删除
	 * 
	把符合条件的路径添加到列表中的时候，因为add添加的是引用，如果不是每次都new一个path的话，最终list保存到的只是最后一个path
	 */
  	 ArrayList<Integer> path = new ArrayList<Integer>();
	 ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
    	 if(root==null) return list;
    	//每访问到一个结点的时候，都把当前的结点添加到路径中去，并调整target的值
    	 path.add(root.val);
    	 target-=root.val;
    	 //已到叶节点并且和为target，则把当前路径添加到输出列表里
         //因为add添加的是引用，如果不new一个的话，最终list保存到的只是最后一个path
    	 if(target==0 && root.left==null && root.right==null) {
    		 list.add(new ArrayList<Integer>(path));
    	 }
    	 //否则继续遍历
    	 FindPath(root.left, target);
    	 FindPath(root.right, target);
    	 
    	//已到叶节点之后会跳过两个递归函数到这里,此时要把最后一个结点从路径中删除,才能返回上层结点
    	 path.remove(path.size()-1);
    	 return list;
    }
}
