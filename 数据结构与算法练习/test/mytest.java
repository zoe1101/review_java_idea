package test;
import com.mysql.cj.util.LRUCache;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.*;
import java.util.Map.Entry;


import static 数组与矩阵问题.计算数组的小和.merge;


public class mytest{
	//二叉树结构
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }
	}
	//链表结构
	public static class ListNode {
	    int val;
	    ListNode next = null;
		ListNode(int val) {
	        this.val = val;
	    }
	}    
	//带有随即指针的链表结构
	public class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;

	    RandomListNode(int label) {
	        this.label = label;
	    }
	}
	//交换数组中的两个元素
	private static void swap(int[] chas, int i, int j) {
		int temp=chas[i];
		chas[i]=chas[j];
		chas[j]=temp;
		
	}





	public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        String[] strs=str.trim().split(" ");
        System.out.println(strs[strs.length-1].length());

	}
	
}
