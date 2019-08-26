package 二叉树问题;

import java.util.HashMap;

public class 通过先序和后序数组生成后续数组 {
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node(int val) {
			this.value=val;
		}
	}
	/*
	1）根据当前先序数组，设置后序数组最右边的值
	2）划分出左子树的先序、中序数组和右子树的先序、中序数组
	3）对右子树重复同样的过程
	4）对左子树重复同样的过程
	 */
	public static int[] getPosArray(int[] pre,int[] in) {
		if (pre==null ||in==null ||pre.length!=in.length) {
			return null;
		}
		int len=pre.length;
		int[] pos=new int[len]; //后序数组
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();//中序数组的值及其位置
		for (int i = 0; i < len; i++) {
			map.put(in[i], i);

		}
		setPos(pre, 0, len-1, in, 0, len-1, pos, len-1, map);
		return pos;
	}
	/**
	 * 从后往前进行后序数组的生成
	 * @param pre:先序数组
	 * @param pre_s：先序数组开始位置
	 * @param pre_e：先序数组结束位置
	 * @param in ：中序数组
	 * @param in_s：中序数组开始位置
	 * @param in_e：中序数组结束位置
	 * @param pos：后序数组
	 * @param pos_e：后序数组的最后一个位置，即当前需要填充的位置
	 * @param map
	 * @return ：返回后序数组该填的下一个位置
	 */
	public static int setPos(int[] pre,int pre_s,int pre_e,int[] in,int in_s,int in_e,
							 int[] pos,int pos_e,HashMap<Integer, Integer> map) {
		if (pre_s>pre_e) {
			return pos_e;
		}
		pos[pos_e--]=pre[pre_s];
		int i=map.get(pre[pre_s]); //在中序数组中找到头结点的位置
		pos_e=setPos(pre, pre_e-in_e+i+1, pre_e, in, i+1, in_e, pos, pos_e, map);//右子树
		return setPos(pre, pre_s+1, pre_s+i-in_s, in, in_s, i-1, pos, pos_e, map);//左子树

	}

	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] pre = { 1, 2, 4, 5, 3, 6, 7 };
		int[] in = { 4, 2, 5, 1, 6, 3, 7 };
		int[] pos = getPosArray(pre, in);
		printArray(pos);

	}
}
