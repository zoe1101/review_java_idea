package Math;
/*
给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。

说明：不要使用任何内置的库函数，如sqrt。

示例 1：

输入：16
输出：True
示例 2：

输入：14
输出：False
 */
public class 有效的完全平方数 {
    public boolean isPerfectSquare(int num) {
    	if (num==1) {
			return true;
		}
        int left=0;
        int right=num<46340?num:46340;
        // 46340 * 46340 = 2147395600
        // 46341 * 46341 = 2147488281
        // 2147395600 < 2147483647 < 2147488281
        while (left<=right) {
        	int mid=(left+right)/2;
			if (mid*mid==num) {
				return true;
			}else if (mid*mid<num) {
				left=mid+1;
			}else {
				right=mid-1;
			}
		}
        return false;
    }
}
