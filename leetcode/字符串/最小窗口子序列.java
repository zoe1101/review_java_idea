package 字符串;
/*
Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.
If there is no such window in S that covers all characters in T, return the empty string "". 
If there are multiple such minimum-length windows, return the one with the left-most starting index.

Example 1:
Input: 
S = "abcdebdde", T = "bde"
Output: "bcde"
Explanation: 
"bcde" is the answer because it occurs before "bdde" which has the same length.
"deb" is not a smaller window because the elements of T in the window must occur in order.
 

Note:
All the strings in the input will only contain lowercase letters.
The length of S will be in the range [1, 20000].
The length of T will be in the range [1, 100].
 */
public class 最小窗口子序列 {
	/*
 首先找到能满足满足T中第一个字符T[0]的S中的字符下标存入dp[0][j]，也就是满足第一个字符要求一定是从这些找到的
 字符开始的。然后在开始找第二个字符T[1]，扫到的字符dp[j]存有index，说明可以从这里记录的index开始，
 找到等于T[1]的S[j]就把之前那个index存进来，说明从这个index到j满足T[0..1]，一直循环，直到T中的i个字符找完。
 如果此时dp[i][j]中有index，说明S[index, j]满足条件，如有多个输出最先找到的。
	 */
	public String minWindow(String S, String T) {
		// 二维数组dp[i][j]表示T[0...i]在S中找到的最大起始下标index，也就是S[index, j]满足目前T[0...i]
        int[][] dp = new int[T.length()][S.length()];
        for(int i = 0; i < T.length(); i++) {
            for(int j = 0; j < S.length(); j++) {
                dp[i][j] = -1;
            }
        }
        
        for(int j = 0; j < S.length(); j++) {
            dp[0][j] = (S.charAt(j) == T.charAt(0)) ? j : -1;
        }
        
        for(int i = 1; i < T.length(); i++) {
            int last = -1;
            for(int j = 0; j < S.length(); j++) {
                if(last >= 0 && S.charAt(j) == T.charAt(i)) {
                    dp[i][j] = last;
                }
                if(dp[i - 1][j] >= 0) {
                    last = dp[i - 1][j];
                }
            }
        }
        
        int start = -1;
        int length = Integer.MAX_VALUE;
        
        for(int j = 0; j < S.length(); j++) {
            if(dp[T.length() - 1][j] >= 0 && (j - dp[T.length() - 1][j] + 1 < length)) {
                start = dp[T.length() - 1][j];
                length = j - dp[T.length() - 1][j] + 1;
            }
        }
        
        return (start == -1) ? "" : S.substring(start, start + length);
    }
}
