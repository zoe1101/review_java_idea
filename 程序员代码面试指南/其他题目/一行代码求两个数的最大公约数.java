package 其他题目;

public class 一行代码求两个数的最大公约数 {
//	利用辗转相除法
	public static int gcd(int m,int n) {
		return n==0?m:gcd(n, m%n);
	}

}
