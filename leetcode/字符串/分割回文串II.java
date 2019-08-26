package 字符串;
/*
 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
返回符合要求的最少分割次数。

示例:
输入: "aab"
输出: 1
解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。

 */

// 动态规划
public class 分割回文串II {
	/*
	 先判断是否是回文串
	 */
    public int minCut(String s) {
    	int n = s.length();
    	boolean[][] judge = new boolean[n][n];
    	int[] dp = new int[n]; // dp[i]表示s中第i个字符到第（n-1）个字符所构成的子串的最小分割次数
		for (int i = n - 1; i >= 0; i--) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = i; j < n; j++) {
		/*在[i, n - 1]范围内寻找切点j，使得满足s中[i, j]范围的子串是一个回文串，
		 * 在所有的切点j中寻找总的最少的切分次数。即1 + dp[j + 1]的最小值，
		 * 如果j + 1越界，即j已经是s中第n - 1个字符，那么说明s中[i, j]范围内的整个子串就是一个回文串。
		 * 该最小值就是dp[i]的值。
		 */
				if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || judge[i + 1][j - 1])) {
					judge[i][j] = true;
					if (j + 1 < n) {
						dp[i] = Math.min(dp[i], 1 + dp[j + 1]);
					}else{ //本身回文
						dp[i] = 0;
					}
				}
			}
		}
		return dp[0];

    }
}
