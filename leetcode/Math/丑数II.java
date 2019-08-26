package Math;
/*
 编写一个程序，找出第 n 个丑数。
丑数就是只包含质因数 2, 3, 5 的正整数。

示例:
输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。

说明:  
1 是丑数。
n 不超过1690。

 */

public class 丑数II {
	//利用三个指针
	  public int nthUglyNumber(int n) {
		  if (n<1) {
			return 0;
		}
		  if (n==1) {
			return 1;
		}
		  int[] dp=new int[n]; //按顺序保存丑数
		  dp[0]=1;
		  int p2=0;
		  int p3=0;
		  int p5=0;
		  for (int i = 1; i < n; i++) {
			int min=Math.min(dp[p2]*2, Math.min(dp[p3]*3, dp[p5]*5));
			if (min==dp[p2]*2) {
				p2++;
			}
			if (min==dp[p3]*3) {
				p3++;
			}
			if (min==dp[p5]*5) {
				p5++;
			}
			dp[i]=min;
		}
		  return dp[n-1];
	  }
}
