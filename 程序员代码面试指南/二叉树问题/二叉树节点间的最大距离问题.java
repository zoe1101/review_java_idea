package 二叉树问题;
import 二叉树问题.判断t1树是否包含t2树全部的拓扑结构.Node;
/*
二叉树中的结点间距离：从结点A出发到达B，每个结点只能走一次，AB路径上的结点数就是AB间距离。
由于从一个结点出发时，只有两种方向可走：
向上经过父节点到达它的兄弟子树；
向下到达它自己的左右子树；
 */

/*
以h为根的二叉树的结点间最大距离的可能情况：
    1：为左子树的结点间最大距离；
    2：为右子树的结点间最大距离；
    3：为经过h的左子树最深叶结点到右子树最深叶结点的路径长，
       即：h的左子树最大深度+h的右子树最大深度+1。
 */
public class 二叉树节点间的最大距离问题 {
	public static class ReturnType {
		public int maxDistance;
		public int height;
		public ReturnType(int maxdis,int h) {
			this.maxDistance=maxdis;
			this.height=h;
		}
	}
	
	public static ReturnType process(Node head) {
		if (head==null) {
			return new ReturnType(0,0);
		}
		ReturnType leftData=process(head.left);
		ReturnType rightData=process(head.right);
		int height=Math.max(leftData.height, rightData.height)+1;
		int maxDistance=Math.max(leftData.height+rightData.height+1,
				Math.max(leftData.maxDistance, rightData.maxDistance));
		return new ReturnType(maxDistance, height);
	}
	public static int getMaxDistance(Node head) {
		return process(head).maxDistance;
	}
}
