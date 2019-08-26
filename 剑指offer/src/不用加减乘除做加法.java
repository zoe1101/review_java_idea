package src;
/*
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
//位运算求解
public class 不用加减乘除做加法 {
    public int Add(int num1,int num2) {
        while (num2!=0) {//进位值为0时退出循环
			int temp=num1^num2;// 两个二进制相加相当于异或,不考虑进位
			num2 = (num1 & num2) << 1;// 求进位相当于与操作,再左移一位
			num1=temp;
		}
       return num1;
    }
}
