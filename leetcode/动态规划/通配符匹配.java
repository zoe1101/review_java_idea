package 动态规划;
/*
给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
'?' 可以匹配任何单个字符。
'*' 可以匹配任意字符串（包括空字符串）。
两个字符串完全匹配才算匹配成功。

说明:
s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
示例 1:

输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。

 */

//动态规划
public class 通配符匹配 {
    public boolean isMatch(String s, String p) {
        if ((s==null && p==null) || (s.length()==0 && p.length()==0)) {
			return true;
		}
        char[] str=s.toCharArray();
        char[] exp=p.toCharArray();
        boolean[][] dp = new boolean[str.length + 1][exp.length + 1];
        dp[0][0]=true;
     // 开始初始化填充,如果匹配的串s是空的的话，只有模式是*才能匹配
        for (int i = 0; i < exp.length; i++) {
			if (dp[0][i] && exp[i]=='*') {
				dp[0][i+1]=true;
			}
		}
        
        for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < exp.length; j++) {
				if (exp[j]=='*') {
					dp[i+1][j+1]=dp[i][j+1] || dp[i+1][j];
				}else if (exp[j]=='?' || exp[j]==str[i]) {
					dp[i+1][j+1]=dp[i][j];
				}
			}
		}
        return dp[str.length][exp.length];
    }
}
