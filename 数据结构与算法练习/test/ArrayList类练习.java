package test;

import java.util.ArrayList;
import java.util.Arrays;

//ArrayList 是一个数组队列，相当于 动态数组.与数组相比，它的容量能动态增长。
public class ArrayList类练习 {

	public static void main(String[] args) {
		
		ArrayList list=new ArrayList();
		list.add(1);
		list.add(2);
		list.add(15);
		list.add("string");
		System.out.println("反转后排序: " + list);

	}

}
