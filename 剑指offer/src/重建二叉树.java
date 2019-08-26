package src;

/*
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */

public class 重建二叉树 {
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int value) {
			this.val =value;
		}
		
	}
	
    /**
     * @param pre  前序遍历
     * @param in    中序遍历
     * @return    二叉树根节点
     */
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre==null || in==null || pre.length!=in.length) return null;
        return construct(pre, 0, pre.length-1, in, 0, in.length-1);
    }
    /**
      * @param pre    前序遍历
      * @param ps    前序遍历的开始位置
      * @param pe    前序遍历的结束位置
      * @param in    中序遍历
      * @param is    中序遍历的开始位置
      * @param ie    中序遍历的结束位置
      * @return        树的根节点
     */
    public static TreeNode construct(int[] pre, int ps, int pe, int[] in, int is, int ie) {
    	if(ps > pe) return null;
        
        // 取前序遍历的第一个数字就是根节点
        int value = pre[ps];
        // 在中序遍历中中寻找根节点
        int index =is;
        while(index <= ie && value != in[index]) {
            index ++;
        }
        // 如果在整个中序遍历的数组中没有找到，说明输入的参数是不合法的，抛出异常 
        if(index > ie) 
            throw new RuntimeException("Invalid Iuput!");
        
        // 创建当前根节点，并为根节点赋值
        TreeNode node = new TreeNode(value);
        // 递归调用构建当前节点的左子树 
        node.left = construct(pre, ps+1, ps+index-is, in, is, index-1);
        // 递归调用构建当前节点的右子树
        node.right = construct(pre, ps+index-is+1, pe, in, index+1, ie);
        
        return node;
    	
    }

	public static void printTree(TreeNode root) {
        if(root != null) {
            printTree(root.left);
            System.out.println(root.val + " ");
            printTree(root.right);
        }
    }
    
    public static void main(String[] args) {
       int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
       int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
       TreeNode node = reConstructBinaryTree(pre, in);
       printTree(node);
       
   }
}
