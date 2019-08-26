package 二叉树问题;
import 二叉树问题.判断t1树是否包含t2树全部的拓扑结构.Node;
public class 根据后续数组重建搜索二叉树 {
	//判断数组是否是搜索二叉树的后序遍历结果
	public static boolean isPostArray(int[] arr) {
		if (arr==null || arr.length==0) {
			return false;
		}
		return isPost(arr, 0, arr.length-1);
	}
	public static boolean isPost(int[] arr,int start,int end) {
		if (start==end) {
			return true;
		}
		int less=-1;//小于最后一个元素的位置指向，记录的是最后一个的位置
		int more=end; //大于最后一个元素的位置指向，记录的是第一个的位置
		for (int i = start; i < end; i++) {
			if (arr[end]>arr[i]) { //当前元素小于最后一个元素
				less=i;
			}else {
				more=more==end?i:more;//只记录第一个的位置
			}	
		}
		if (less==-1 || more==end) {
			return isPost(arr, start, end-1);
		}
		if (less!=more-1) {//小于的最后一个位置应该与大于的第一个位置相邻
			return false;
		}
		//小于部分与大于部分继续判断
		return isPost(arr, start, less)&& isPost(arr, more, end-1);
	}
	
	//利用后续数组重建搜索二叉树
	public static Node postArrayToBST(int[] postArr) {
		if (postArr==null) {
			return null;
		}
		return posToBST(postArr, 0, postArr.length-1);
	}
	public static Node posToBST(int[] posArr,int start,int end) {
		if (start>end) {
			return null;
		}
		Node head=new Node(posArr[end]);
		int less=-1;
		int more=end;
		for (int i = start; i < end; i++) {
			if (posArr[i]<posArr[end]) {
				less=i;
			}else {
				more=more==end?i:more;
			}
		}
		head.left=posToBST(posArr, start, less);
		head.right=posToBST(posArr, more, end-1);
		return head;
	}

}
