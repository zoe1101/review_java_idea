package Math;
/*
给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。

示例 1:

输入: 16
输出: true
示例 2:

输入: 5
输出: false

 */
public class four的幂 {
	/*
4的幂一定是2的。
4的幂和2的幂一样，只会出现一位1。但是，4的1总是出现在奇数位。
	 */
    public boolean isPowerOfFour(int num) {
        if (num<=0) {
			return false;
		}
        //是2的幂，且1在奇数位上，
        if ((num&(num-1))==0 && num%3==1) {
			return true;
		}
        return false;
    }
    
    public boolean isPowerOfFour2(int num) {
        if(num<=0)
            return false;
        double i = Math.log10(num)/Math.log10(4);
        return i==(int)i;
    }
}
