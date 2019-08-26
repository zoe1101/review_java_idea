package test;

public class 包装类练习 {

	public static void main(String[] args) {
		Integer integer=new Integer(7);
		Integer integer2=new Integer("123");
		int myint=Integer.parseInt("123");  //数字字符串转为int
		System.out.println(integer);
		System.out.println(integer2);
		System.out.println(myint);
		System.out.println(integer.MAX_VALUE); //int类型可取的最大值
		System.out.println(integer.MIN_VALUE); //int类型可取的最小值
		System.out.println(integer.SIZE); //int值对应的二进制表示位数
	}

}
