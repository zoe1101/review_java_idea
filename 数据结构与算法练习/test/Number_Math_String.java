package test;

public class Number_Math_String {
public static void main(String[] args) {
	Integer x = 5;
    Integer y =Integer.valueOf(9);  //返回一个 Number 对象指定的内置数据类型
	System.out.println(x.longValue()); //将 Number 对象转换为xxx数据类型的值并返回。
	System.out.println(x.compareTo(3)); //将number对象与参数比较。
	System.out.println(x.equals(3)); // 判断number对象是否与参数相等。
	
	System.out.println(y); 
	System.out.println(Math.sin(Math.PI/2));
	System.out.println(Math.min(4,7)); 
	System.out.println(Math.max(4,7)); 
	System.out.println(Math.round(3.8)); 
	System.out.println(Math.floor(3.8)); 
	System.out.println(Math.ceil(3.8)); 
	
    char[] helloArray = { 'r', 'u', 'n', 'o', 'o', 'b'};
    String helloString = new String(helloArray);  
    System.out.println( helloString );
    System.out.println( "我的名字是 ".concat("Runoob"));  //字符串拼接
    System.out.println( "我的名字是 "+"Runoob"); //加号拼接隐式的改写成 stringbuilder，也就是说，单行时用加号拼接字符串没有任何性能损失。
    
    String str1="我的名字是 ";
    int res=str1.compareTo("Runoob");  //compareTo(String)方法中其实是从头开始，一个一个字符的比对原字符串和参数字符串中的字符，如果相同就下一个，直到字符出现不同（包括某一个字符串结束了）就计算这两个不同字符的ASCII码的差，作为返回值。（或是直到最后都相同就返回0）
    System.out.println(res);
	
}
}
