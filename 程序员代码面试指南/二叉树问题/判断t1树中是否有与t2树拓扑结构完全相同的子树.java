package 二叉树问题;

import 二叉树问题.判断t1树是否包含t2树全部的拓扑结构.Node;

//t2是否是t1的子树
public class 判断t1树中是否有与t2树拓扑结构完全相同的子树 {
//现将t1和t2序列化，然后运用子串匹配算法实现
	public static boolean isSunTree(Node t1,Node t2) {
		String t1String=serialByPre(t1);
		String t2String=serialByPre(t2);
		return getIndexOf(t1String, t2String)!=-1;
	}
	public static String serialByPre(Node head) {
		if (head==null) {
			return "#!";
		}
		String res=head.value+"!";
		res+=serialByPre(head.left);
		res+=serialByPre(head.right);
		return res;
	}
	//KMP算法：查找子串位置
	public static int getIndexOf(String s, String m) {
		if (s==null || m==null || m.length()==0 || s.length()==0) {
			return -1;
		}
		char[] ss=s.toCharArray();
		char[] ms=m.toCharArray();
		int i=0;
		int j=0;
		int[] next=getNextArray(ms);
		while (i<ss.length && j<ms.length) {
			if (ss[i]==ms[j]) {
				i++;
				j++;
			}else if (next[j]==-1) {
				i++;
			}else {
				j=next[j];
			}
		}
		return j==ms.length?i-j:-1;
	}
	public static int[] getNextArray(char[] ms) {
		if (ms.length==1) {
			return new int[] {-1};
		}
		int[] next=new int[ms.length];
		next[0]=-1;
		next[1]=0;
		int pos=2;
		int cn=0;
		while (pos<next.length) {
			if (ms[pos-1]==ms[cn]) {
				next[pos++]=++cn;
			}else if (cn>0) {
				cn=next[cn];
			}else {
				next[pos++]=0;
			}
		}
		return next;
	}
}
