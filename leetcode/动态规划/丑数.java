package 动态规划;
/*
编写一个程序判断给定的数是否为丑数。

丑数就是只包含质因数 2, 3, 5 的正整数。

示例 1:

输入: 6
输出: true
解释: 6 = 2 × 3

 */
public class 丑数 {
    public boolean isUgly(int num) {
        if (num<=1) {
			return num==1?true:false;
		}
        while (num>1) {
			int t=num;
			while (t%2==0) {
				t/=2;
			}
			while (t%3==0) {
				t/=3;
			}
			while (t%5==0) {
				t/=5;
			}
			if (t==num) {
				return false;
			}
			num=t;
		}
        return true;
    }
}
