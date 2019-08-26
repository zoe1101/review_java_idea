package Math;
/*
给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
返回被除数 dividend 除以除数 divisor 得到的商。

示例 1:

输入: dividend = 10, divisor = 3
输出: 3
 */
//利用位运算
public class 两数相除 {
/*
 让被除数不断减去除数，直到不够减,每次减完后除数翻倍.
 */
    public int divide(int dividend, int divisor) {
        if (divisor==0) {
			return 0;
		}
        if (dividend==Integer.MIN_VALUE && divisor==-1) {
			return Integer.MAX_VALUE;
		}
        
        boolean negative=(dividend^divisor)<0; //用异或来计算是否符号相异
        long t = Math.abs((long) dividend);
        long d= Math.abs((long) divisor);
        int res=0;
//        a << b 相当于 a * 2^b，a >> b 相当于 a / 2^b
        for (int i = 31; i >=0; i--) {
			if ((t>>i)>=d) { //找出足够大的数2^i*divisor
				res+=1<<i;//将结果加上2^i
				t-=d<<i;//将被除数减去2^i*divisor
			}
		}
        return negative ? -res : res;//符号相异取反
    }
}
