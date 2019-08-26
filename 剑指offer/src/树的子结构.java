package src;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @author zoe
 *
 */
public class 树的子结构 {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	/**
1、首先我们的思路应该是从二叉树A的根结点开始递归遍历整棵树，每访问到一个结点，都要检查当前结点是否已经是子树的开始结点，否则传入该结点的左右孩子继续检查
2、在判断当前结点是否已经是子树的开始结点时，首先判断结点值是否相等，相等的话再判断各自的左右孩子是否也对应相等（此时要注意，子树可以先为空，但二叉树A不能先为空）
	 * @param root1
	 * @param root2
	 * @return
	 */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null || root2==null) {
        	return false;
        }
      //要么当前结点已经是子树 要么当前结点的左孩子或右孩子存在子树;
        return IsSubtree(root1, root2) || IsSubtree(root1.left, root2) || IsSubtree(root1.right, root2); 
    }
    public boolean IsSubtree(TreeNode root1,TreeNode root2){
    	if(root2==null) {//说明已经完全匹配,先写这一句是为了应对root2走完root1没走完 与 root1，root2都做完的情况
    		return true;
    	}
    	if(root1==null) { //root1走完了还没有匹配上root2
    		return false;
    	}
    	if(root1.val==root2.val) {
    		return IsSubtree(root1.left, root2.left) &&IsSubtree(root1.right, root2.right);
    	}else {
    		return false;
    	}
    }
}
