package 二叉树问题;

import javax.security.auth.x500.X500Principal;

public class 找到二叉树中的最大搜索二叉树 {
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		
	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	
	private static class returnType{
		public TreeNode maxBSTHead;
		public int maxBSTSize;
		public int min;
		public int max;
		public returnType(TreeNode maxBSTHead,int maxBSTSize,int min,int max) {
			this.maxBSTHead=maxBSTHead;
			this.maxBSTSize=maxBSTSize;
			this.min=min;
			this.max=max;
		}
	}
	
	public static TreeNode getMaxBST(TreeNode head) {
		return process(head).maxBSTHead;
	}
	public static returnType process(TreeNode x) {
		if (x==null) {
			return new returnType(null,0, Integer.MAX_VALUE,Integer.MIN_VALUE);
		}
		returnType leftdata=process(x.left);
		returnType rightdata=process(x.right);
		int min=Math.min(x.val, Math.min(leftdata.min, rightdata.min));
		int max=Math.max(x.val, Math.max(leftdata.max, rightdata.max));
		int maxBSTSize=Math.max(leftdata.maxBSTSize, rightdata.maxBSTSize);
		TreeNode maxBSTHead=leftdata.maxBSTSize>=rightdata.maxBSTSize?
				leftdata.maxBSTHead:rightdata.maxBSTHead;
		if (leftdata.maxBSTHead==x.left && rightdata.maxBSTHead==x.right 
				&& x.val>leftdata.max && x.val<rightdata.min) {
			maxBSTSize=leftdata.maxBSTSize+rightdata.maxBSTSize+1;
			maxBSTHead=x;
		}
		return new returnType(maxBSTHead, maxBSTSize, min, max);
	}
}
