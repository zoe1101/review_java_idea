package src;

import java.util.*;

/**
 * @author ZOE
 * @date 2019/8/4 19:38
 */
//树不是二叉树，也没有指向父节点的引用。
public class 树中两个节点的最低公共祖先 {
    public static class TreeNode{
        public  int value;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val){
            this.value=val;
        }
    }
    public static TreeNode getLowestCommonParent(TreeNode root,TreeNode p,TreeNode q) {
        if (root==null || p==root|| q==root){ //如果p==root或者q==root，说明找到了p和q
            return root;
        }
        //找左子树中是否存在p或q,存在时返回p或q或者p,q的祖先结点，不存在时返回null
        TreeNode left=getLowestCommonParent(root.left,p,q);
        //找右子树中是否存在p或q
        TreeNode right=getLowestCommonParent(root.right,p,q);
        if (left!=null && right!=null)  //left和right分别有p或q,则其父结点root为p,q的最低公共祖先
            return root;
        else
            return left!=null ? left : right; //left同时有p,q,则left为公共祖先，（若left为空，则right为公共祖先）
    }
}
