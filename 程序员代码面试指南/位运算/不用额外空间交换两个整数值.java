package 位运算;

//任何数自己和自己异或（XOR）后等于0.
public class 不用额外空间交换两个整数值 {

	public static void main(String[] args) {
		int a=4,b=3;
		a=a^b;
		b=a^b;
		a=a^b;
		System.out.println(a+"  "+b);
	}

}
