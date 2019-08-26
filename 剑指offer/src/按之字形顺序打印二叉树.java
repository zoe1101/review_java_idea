package src;

import java.util.ArrayList;
import java.util.Stack;


/*
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，
 * 其他行以此类推。
 */
public class 按之字形顺序打印二叉树 {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	//在层次遍历的基础上进行z字型打印
//	奇数行从左到右，跟BFS的遍历顺序一样，而偶数行从右到左，跟BFS的遍历顺序相反。
//	因此我们不能直接采用队列，可以通过两个栈来实现，
//	一个实现先进先出，即入栈顺序为右子节点、左子节点；
//	一个实现后进先出，即入栈顺序为左子节点、右子节点。
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    	ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
    	if (pRoot==null) {
			return result;
		}
    	Stack<TreeNode> stack1=new Stack<TreeNode>(); //从左到右
    	Stack<TreeNode> stack2=new Stack<TreeNode>(); //从右到左
    	
    	ArrayList<Integer> list = new ArrayList<Integer>(); //每一层的结果
    	list.add(pRoot.val);
    	result.add(list);
    	
    	stack1.push(pRoot);
    	
    	while (stack1.isEmpty() || stack2.isEmpty()) { 
			if (stack1.isEmpty() && stack2.isEmpty()) { //遍历完了
				break;
			}
			ArrayList<Integer> temp = new ArrayList<Integer>();
			if (stack2.isEmpty()) {
				while (!stack1.isEmpty()) {
					if (stack1.peek().right!=null) {
						temp.add(stack1.peek().right.val);
						stack2.push(stack1.peek().right);
					}
					if (stack1.peek().left != null) {
						temp.add(stack1.peek().left.val);
                        stack2.push(stack1.peek().left);
					}
					stack1.pop();
				}
			}else {
                while (!stack2.isEmpty()) {
                    if (stack2.peek().left != null) {
                        temp.add(stack2.peek().left.val);
                        stack1.push(stack2.peek().left);
                    }
                    if (stack2.peek().right != null) {
                        temp.add(stack2.peek().right.val);
                        stack1.push(stack2.peek().right);
                    }
                    stack2.pop();
                }
            }
            if (temp.size() > 0) {
                result.add(temp);
            }
        }
        return result;
    }
}
