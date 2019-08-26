package Math;
/*
给定一个整数，编写一个函数来判断它是否是 2 的幂次方。

示例 1:

输入: 1
输出: true
解释: 20 = 1
 */
public class two的幂 {
	//2的幂次方在二进制下，只有1位是1，其余全是0。
    public boolean isPowerOfTwo(int n) {
        if (n<=0) {
			return false;
		}
        if ((n&(n-1))==0) { //n：1000，n-1:0111
			return true;
		}
        return false;
    }
}
