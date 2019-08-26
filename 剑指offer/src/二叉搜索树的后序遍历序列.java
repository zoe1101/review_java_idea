package src;
/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * @author zoe
 *
 *
 *二叉排序树后序遍历的性质：
 *序列最后一个数字是根节点，序列剩余部分分成两部分，前一部分是左子树，后一部分是右子树。
 */


public class 二叉搜索树的后序遍历序列 {
	
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null || sequence.length==0) {
        	return false;
        }
        return verifySquenceOfBST(sequence, 0,sequence.length-1); //递归实现
    }
    
    public boolean verifySquenceOfBST(int[] sequence,int start,int end){
    	if(start>=end) return true;
    	int root=sequence[end];
    	
    	// 划分左右子树,并判断左右子树和根节点的关系
    	int i=start;
    	while (sequence[i]<root) { //左子树
			i++; 
		}
    	int j=i;
    	while (j<end) {//右子树
			if(sequence[j]<root) { //一旦右子树中出现比根节点小的数,表明无法构成二叉搜索树
				return false;
			}
			j++;
		}
    	
    	boolean left=verifySquenceOfBST(sequence, start, i-1);// 判断左子树是不是二叉搜索树
    	boolean right=verifySquenceOfBST(sequence, i, end-1); //判断右子树是不是二叉搜索树
    	return left&&right;
    }
}
