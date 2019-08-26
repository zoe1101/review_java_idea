package 字符串;

import java.math.BigInteger;

/*
请你来实现一个 atoi 函数，使其能将字符串转换成整数。
首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
在任何情况下，若函数不能进行有效的转换时，请返回 0。

说明：
假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]。
如果数值超过这个范围，请返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。

示例 1:
输入: "42"
输出: 42
 */
public class 字符串转换整数 {
    public int myAtoi(String str) {
        String res="";
        str=str.trim(); //去除首尾空格
        if (str==null || str.length()==0) {
			return 0;
		}
        char c = str.charAt(0);
        int i = 1;
        if (c!='-' && c!='+' && (c<'0' || c>'9')) { //首个非空字符无效
			return 0;
		}
        res+=c;
        while (i<str.length() && str.charAt(i)>='0' && str.charAt(i)<='9') {
			res+=str.charAt(i);
			i++;
		}
        if (res.equals("-") || res.equals("+")) {
			return 0;
		}
        BigInteger b = new BigInteger(res); //防止值溢出，所以用BigInteger
        if (c=='-') {
			if (b.compareTo(new BigInteger("-2147483648"))==-1) {//负数小于最小值
				return Integer.MIN_VALUE;
			}
		}else if (b.compareTo(new BigInteger("2147483647"))==1) {//正数且大于最大值
			return Integer.MAX_VALUE;
		}
        return Integer.valueOf(res);

    }
}
