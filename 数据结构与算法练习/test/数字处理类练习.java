package test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Random;

//数字格式化、Math类、随机数生成
public class 数字处理类练习 {

	public static void main(String[] args) {
		DecimalFormat myFormat1=new DecimalFormat("###,###,###"); //设置数字格式化形式
		DecimalFormat myFormat2=new DecimalFormat("#.###%"); //设置数字格式化形式
		DecimalFormat myFormat3=new DecimalFormat("0.00\u2030"); //千分数形式
		System.out.println(myFormat1.format(123456789));
		System.out.println(myFormat2.format(0.1234));
		System.out.println(myFormat3.format(0.1234));
		myFormat1.setGroupingSize(4);//设置数字分组值为4
		System.out.println(myFormat1.format(123456789));
		myFormat1.setGroupingUsed(false); //不允许分组
		System.out.println(myFormat1.format(123456789));
		
//		Math类
		System.out.println(Math.PI+" "+Math.E);
		System.out.println(Math.log10(100));
		System.out.println(Math.cbrt(3)); //立方根
		System.out.println(Math.pow(2, 3));//2的3次方
		System.out.println(Math.round(3.4)); //四舍五入,返回long
		System.out.println(Math.rint(3.5)); //也是四舍五入，但返回的还是double
		
		
//	随机数
		System.out.println(Math.random()); //默认[0,1)的数
		System.out.println(Math.random()*5); 
		System.out.println((char)('a'+Math.random()*('z'-'a'+1)));  //随机字符生成
		
		Random random=new Random();
		System.out.println(random.nextInt(10)); //生成一个10以内的int型的数
		System.out.println(random.nextGaussian()); //生成一个服从高斯分布的数
		
//		大数字预算
		BigInteger bigInteger=new BigInteger("5"); //参数是一String形式存在的
		System.out.println(bigInteger); 
		System.out.println(bigInteger.add(new BigInteger("4"))); //加法
		System.out.println(bigInteger.divideAndRemainder(new BigInteger("4"))[0]); //除法取商
		System.out.println(bigInteger.divideAndRemainder(new BigInteger("4"))[1]); //除法取余数
		System.out.println(bigInteger.negate()); //取反
		
		BigDecimal bigDecimal=new BigDecimal(4.22);//参数以double形式存在的
	}

}
