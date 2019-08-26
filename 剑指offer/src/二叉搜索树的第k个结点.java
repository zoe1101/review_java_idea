package src;

import java.util.LinkedList;

import javax.swing.text.html.HTML.Tag;

/*
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 */
public class 二叉搜索树的第k个结点 {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
    
//    非递归中序遍历
    TreeNode KthNode1(TreeNode pRoot, int k) {
        if(pRoot==null||k<0){
            return null;
        }
        TreeNode curNode=pRoot; //指向当前节点
        TreeNode KNode=null;
        int count=0;
        LinkedList<TreeNode> stack=new LinkedList<>();
        //中序遍历二叉树
        while(!stack.isEmpty()||curNode!=null){
            while(curNode!=null){
                stack.push(curNode);
                curNode=curNode.left;
            }
            if(!stack.isEmpty()){
                curNode=stack.pop();
                count++;
                if(k==count){
                    KNode=curNode;
                    break;
                }
                curNode=curNode.right;
            }
        }
        return KNode;
    }
    
//	递归中序遍历实现
	int count=0;
    TreeNode KthNode(TreeNode pRoot, int k){
    	if (pRoot==null || k<0) {
			return null;
		}
    	TreeNode target=null;
    	if (pRoot.left!=null) {
    		target =KthNode(pRoot.left, k);
		}
    	count++;
    	if (target==null) {
			if (count==k) {
				target=pRoot;
				return target;
			}
		}
    	if (target==null && pRoot.right!=null) {
			target=KthNode(pRoot.right, k);
		}
    	return target;
    }
}
