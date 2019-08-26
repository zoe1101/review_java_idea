package Math;
/*
给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

示例 1:

输入: n = 12
输出: 3 
解释: 12 = 4 + 4 + 4.
示例 2:

输入: n = 13
输出: 2
解释: 13 = 4 + 9.

 */

import java.util.Arrays;


public class 完全平方数 {
	/*
	四平方定理： 任何一个正整数都可以表示成不超过四个整数的平方之和。
	推论：满足四数平方和定理的数n（四个整数的情况），必定满足 n=4^a(8b+7)
	 */
    public int numSquares(int n) {
        while (n%4==0) {
			n/=4;
		}
        if (n%8==7) {
			return 4;
		}
        for(int a=0;a*a<=n;a++) {
            if(n==a*a) {
                return 1;
            }
        }
        for (int a = 0; a*a <= n; a++) {
			int b=(int)Math.sqrt(n-a*a);
			if (a*a+b*b==n &&a>=0&&b>=0) {
				return 2;
			}
		}
        return 3;
    }
    
    /*动态规划法：
     * 对一个数字n而言，组成的它的完全平方数的最少个数可以根据它减去i*i（这里i*i<n）
     * 后对应的那个数的最少完全平方数加一，通过改变i的值最终取得最小值。
    */
    public int numSquares2(int n) {
    	int [] dp=new int[n+1];
    	Arrays.fill(dp, Integer.MAX_VALUE);
    	dp[0]=0;
    	for (int i = 0; i <=n; i++) {
    		int j=1;
			while(i-j*j>=0) {
				dp[i] = Math.min(dp[i-j*j]+1, dp[i]);
				j++;
			}
		}
    	return dp[n];
    }
}
