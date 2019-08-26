package src;
/*
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class 对称的二叉树 {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	
/*
根结点对应的值相等，原二叉树Root的左子树与其镜像二叉树Root'的右子树相同，
且原二叉树Root的右子树与其镜像二叉树Root'的左子树相同。如此递归下去。直到
① 如果Root和Root'均为空，则返回true；
② 如果Root为空或者Root'为空，则返回false；
③ 如果Root对应的值与Root'对应的值不相等，则返回false。

*/

    boolean isSymmetrical(TreeNode pRoot)
    {
        return judge(pRoot,pRoot);
    }
    
    public boolean judge(TreeNode pRoot,TreeNode root){
        if(pRoot== null && root == null){
            return true;
        }
        if(pRoot==null || root == null){
            return false;
        }
        if(pRoot.val != root.val)
            return false;
        return judge(pRoot.left,root.right) && judge(pRoot.right,root.left);
    }
}
