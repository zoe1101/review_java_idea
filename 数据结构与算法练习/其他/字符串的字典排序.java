package 其他;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
给定n个字符串，对n个字符串按照字典排序。
 */
public class 字符串的字典排序 {
	public static ArrayList<String> sortedStrings(String[] strs) {
		ArrayList<String> list=new  ArrayList<String>();
		if (strs==null) {
			return list;
		}
		for (int i = 0; i < strs.length; i++) {
			list.add(strs[i]);
		}
		Collections.sort(list, new Comparator<String>() {
			public int compare(String o1, String o2) {
				char[] chas1=o1.toCharArray();
				char[] chas2=o2.toCharArray();
				int i=0;
				while (i<chas1.length && i<chas2.length) {
					if (chas1[i]<chas2[i]) {
						return -1;
					}else if (chas1[i]>chas2[i]) {
						return 1;
					}else {
						i++;
					}
				}
				if (i==chas1.length) { //o1到头了,o2大
					return -1;
				}
				if (i==chas2.length) { //o2到头了,o1大
					return 1;
				}
				return 0; //相等
			}
		});
		return list;
	}
	public static void main(String[] args) {
		String[] strs= {"acb","bca","cab","abc","bac"};
		System.out.println(sortedStrings(strs));
	}
}
