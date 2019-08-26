package 二叉树问题;

import java.util.HashMap;
import java.util.Map;


public class 找到二叉树中符合搜索二叉树条件的最大拓扑结构 {
	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		
	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
//	拓扑贡献记录，记录当前节点的左子树与右子树的贡献节点
	public static class Record{
		public int l;
		public int r;
		public Record(int left,int right) {
			this.l=left;
			this.r=right;
		}
	}
	
	public static int bstTopSize(TreeNode head) {
		//记录当前节点的左子树与右子树的贡献节点
		Map<TreeNode, Record> map=new HashMap<TreeNode, Record>();
		return posOrder(head, map);
	}
	//利用后序遍历
	public static int posOrder(TreeNode head,Map<TreeNode, Record> map) {
		if (head==null) {
			return 0;
		}
		int ls=posOrder(head.left, map);
		int rs=posOrder(head.right, map);
		
		modifyMap(head.left, head.val, map, true);
		modifyMap(head.right, head.val, map, false);
		Record lr=map.get(head.left);
		Record rr=map.get(head.right);
		int lbst=lr==null?0:lr.l+lr.r+1;
		int rbst=rr==null?0:rr.l+rr.r+1;
		map.put(head,new Record(lbst,rbst));
		return Math.max(lbst+rbst+1, Math.max(ls, rs));
	}
	
	public static int modifyMap(TreeNode node,int v,Map<TreeNode, Record> m, boolean s) {
		if (node==null || !(m.containsKey(node))) {
			return 0;
		}
		Record r=m.get(node);
		if ((s&& node.val>v) || (!s && node.val<v)) {
			m.remove(node);
			return r.l+r.r+1;
		}else {
			int minus=modifyMap(s?node.right:node.left, v, m, s);
			if (s) {
				r.r=r.r-minus;
			}else {
				r.l=r.l-minus;
			}
			m.put(node, r);
			return minus;
		}
	}
}
