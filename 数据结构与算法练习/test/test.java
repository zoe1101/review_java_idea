package test;
import java.util.*;
public class test {  //类声明

	public static void main(String[] args) {   //main方法声明
		Scanner stdinScanner=new Scanner(System.in); //键盘输入
		Random random=new Random(); //随机数
		final double PI=3.1415926;  //无法修改的变量
		
//		int[] arr= new int[5];  //数组声明
		int[] arr= new int[] {1,2,3,4,5};  //数组声明并赋值
		String string="hello world";
		char[] char_arr=string.toCharArray(); //字符串转数组
		String string2=new String(char_arr); //数组转字符串
		System.out.println(string2);
		System.out.println(arr);
		
		int x=stdinScanner.nextInt();  //声明并赋值
		String string3=stdinScanner.nextLine(); //读入一行字符串
		int r=random.nextInt(100); //100以内的随机数
		System.out.println(x);
		// TODO 自动生成的方法存根
		System.out.println("2+4=6"+"32");

	}

}
