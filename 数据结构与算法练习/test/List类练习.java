package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;

public class List类练习 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		List<String> list1=new ArrayList<>();
		list1.add("I");
		list1.add("Love");
		list1.add("China");
		list1.add("!");
		list1.add("!");
		list1.add("!");
		list1.remove(4);
		list1.remove("!");
		String itString=list1.get(2);
		System.out.println(itString);
		System.out.println("list1中是否包含I："+list1.contains("I"));  //判断list中是否包含某元素
		list1.set(2, "hate"); //元素替换
		printList(list1);
		list1.add(2, "like");   //在原有基础上插入
		printList(list1); 
		//查看（判断）元素的索引
		System.out.println(list1.indexOf("!"));  //从前往后第一个
		System.out.println(list1.lastIndexOf("!")); //从后往前第一个
		//利用list中索引位置重新生成一个新的list（截取集合）
		List<String> list2=list1.subList(2, 4); //[2,4)
		printList(list2); 
		
		System.out.println(list1.isEmpty());  //判断list是否为空；
		System.out.println(list1.toString());  //将集合转换为字符串；
		System.out.println(list1.toArray());  //将集合转换为数组；
		list1.add("T");
		list1.add("I");
		list1.add("T");
		printList(list1);
		//去重复；
		List<String> list3= new ArrayList<String>();
		for(String s:list1) {
			if(Collections.frequency(list3, s)<1) { //如果s未在list3中
				list3.add(s); 
			}
		}
		printList(list3);
		
	}
	public static void printList(List<String> list1) {
		 for (int i = 0; i < list1.size(); i++) {
		        System.out.println(list1.get(i));  //.get(index)
	}
    }

}
