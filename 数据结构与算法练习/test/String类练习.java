package test;

import java.util.*;


public class String类练习 {

	public static void main(String[] args) {
		String str1String=" HELLO WORLD!  ";
		
//		字符索引
		System.out.println(str1String.charAt(3));
//		字符串查找
		System.out.println(str1String.indexOf('W'));//从前往后找
		System.out.println(str1String.lastIndexOf('W'));//从后往前找
		
//	子串获取
		System.out.println(str1String.substring(4)); //从当前位置4截取到字符串结束
		System.out.println(str1String.substring(4,7));//截取[4,7)的字符串
		
//		去首尾空格
		System.out.println(str1String.trim());
//		字符串替换
		System.out.println(str1String.replace('E', 'e')); 
		
//		判断字符串的开始与结尾
		System.out.println(str1String.startsWith(" ")); //判断字符串是否已空格开头
		System.out.println(str1String.endsWith(" ")); //判断字符串是否已空格结尾
		
//		判断字符串是否相等
		String str2String=" HELLO WorLD!  ";
		System.out.println(str1String.equals(str2String));//区分大小写
		System.out.println(str1String.equalsIgnoreCase(str2String));//忽略大小写
//		字符串比较
		System.out.println(str1String.compareTo(str2String));
//		大小写转换
		System.out.println(str1String.toLowerCase());
		System.out.println(str2String.toUpperCase());
//		字符串分割
		System.out.println(str2String.split(" ",2));//切两次

//		格式化字符串
		System.out.println(String.format("%d",400/2));
		Date date=new Date();
		String string=String.format("%tY", date); //当前年份
		System.out.println(string);

//		StringBuilder
		StringBuilder sb= new StringBuilder("hello");
		sb.append('a');
		System.out.println(sb.toString());
		sb.insert(3,'a');
		System.out.println(sb.toString());
		sb.delete(2, 4);
		System.out.println(sb.toString());
	}

}
