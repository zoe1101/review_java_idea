package 位运算;

import javax.management.RuntimeErrorException;

public class 只用位运算不用算术运算符实现正数的加减乘除运算 {
	//加法
	public static int add(int a,int b) {
		int sum=a;
		while (b!=0) {
			sum=a^b;
			b=(a&b)<<1;
			a=sum;
		}
		return sum;
	}
	//求减数的补码
	public static int negNum(int b) {
		return add(~b, 1);
	}
	//减法
	public static int minus(int a,int b) {
		return add(a, negNum(b));
	}
	
	//乘法
	public static int multi(int a,int b) {
		int res=0;
		while (b!=0) {
			if((b&1)!=0) {
				res=add(res, a);
			}
			a<<=1;
			b>>=1;
		}
		return res;
	}
	//负数判定
	public static boolean isNeg(int n) {
		return n<0;
	}
	
	public static int div(int a,int b) {
		int x=isNeg(a)?negNum(a):a;
		int y=isNeg(b)?negNum(b):b;
		int res=0;
		for(int i=31;i>=0;i=minus(i, 1)) {
			if((x>>i)>=y) { //确保x>=y
				res|=(1<<i);
				x=minus(x, y<<i);
			}
		}
		return isNeg(a)^isNeg(b)?negNum(res):res;
	}
	//除法
	public static int divide(int a,int b) {
		if(b==0) {
			throw new RuntimeException("除数为0");
		}
		if(a==Integer.MIN_VALUE && b==Integer.MIN_VALUE) {
			return 1;
		}else if(b==Integer.MIN_VALUE){
			return 0;
		}else if (a==Integer.MIN_VALUE) {
			int res=div(add(a, 1), b); //res=(a+1)/b的结果
			//rest=(a-c*b)/b为修正值
			return add(res, div(minus(a, multi(res, b)),b));  //res+rest
			
		}else {
			return div(a, b);
		}
	}

}
