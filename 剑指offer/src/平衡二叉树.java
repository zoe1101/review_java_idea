package src;

import java.util.prefs.BackingStoreException;

//输入一棵二叉树,判断该二叉树是否是平衡二叉树。
public class 平衡二叉树 {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	
	//后序遍历,左-->右-->根,这样一来，可以“一边遍历，一边判断”,
    //且如果前期就判断为false,那么后面就不用判断了。
    private boolean isBalanced=true;
    public boolean IsBalanced_Solution2(TreeNode root) {
    	treeDepth(root);
    	return isBalanced;
 
    } 
	 //树的深度
    public int treeDepth(TreeNode root) {
        if (root==null) {
			return 0;
		}
        int left=treeDepth(root.left); //左子树的深度
        int right=treeDepth(root.right); //右子树的深度
        if(Math.abs(left-right)>1) {
        	isBalanced=false;
        }
        return left>right?left+1:right+1;
    }
    
    
	//依次从根节点开始,判断所有节点的左右子树是否平衡
	//但这样一来,排在底层的节点可能要被多次重复遍历,所以此方法复杂度高
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root==null){ 
        	return true;
        }
        int left = treeDepth(root.left);  
        int right = treeDepth(root.right);  
        int diff = left - right;  
        if(diff > 1 || diff <-1)  
            return false;  
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.left); 	
    }
    
    
    
    
    
}
