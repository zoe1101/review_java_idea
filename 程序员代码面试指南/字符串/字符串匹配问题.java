package 字符串;

//相当于正则化匹配
/**
 * 判断源字符串与匹配字符串的格式是否有效
 * @author zoe
 *
 */
public class 字符串匹配问题 {
	public static boolean isValid(char[] str,char[] e) {
		for(int i=0;i<str.length;i++) {
			if(str[i]=='*' || str[i]=='.') {
				return false;
			}
		}
		for(int i=0;i<e.length;i++) {
			if(e[i]=='*' && (i==0 || e[i-1]=='*')) { //星号在第一个位置或者连续两个星号是无效的
				return false;
			}
		}
		return true;
	}
//方法1：递归法
	public static boolean isMatch(String str, String exp) {
		if(str==null || exp==null) {
			return false;
		}
		char[] s=str.toCharArray();
		char[] e=str.toCharArray();
		return isValid(s, e)?process(s,e,0,0):false;
	}
	/**
	 * 从源字符串str的si位置开始，一直到str.length的子串，是否能被从匹配表达式的ei位置开始一直到exp.length的子串所匹配。
	 * @param s
	 * @param e
	 * @param si
	 * @param ei
	 * @return
	 */
	public static boolean process(char[] s,char[] e, int si,int ei) {
		if(ei==e.length) {//当ei是结束位置，si也是结束位置时，返回true，可以匹配
			return si==s.length;
		}
		
		if(ei+1==e.length || e[ei+1]!='*') {
			return si!=s.length && (e[ei]==s[si] || e[ei]=='.') && process(s, e, si+1, ei+1);
		}
		while (si!=s.length &e[ei]==s[si] || e[ei]=='.') {
			if(process(s, e, si, ei+2)) {
				return true;
			}
			si++;
		}
		return process(s, e, si, ei+2);
	}


//方法2：动态规划
	public static boolean isMatchDP(String str, String exp) {
		if (str == null || exp == null) {
			return false;
		}
		char[] s = str.toCharArray();
		char[] e = exp.toCharArray();
		if (!isValid(s, e)) {
			return false;
		}
		boolean[][] dp = initDPMap(s, e);
		for (int i = s.length - 1; i > -1; i--) {
			for (int j = e.length - 2; j > -1; j--) {
				if (e[j + 1] != '*') {
					dp[i][j] = (s[i] == e[j] || e[j] == '.')
							&& dp[i + 1][j + 1];
				} else {
					int si = i;
					while (si != s.length && (s[si] == e[j] || e[j] == '.')) {
						if (dp[si][j + 2]) {
							dp[i][j] = true;
							break;
						}
						si++;
					}
					if (dp[i][j] != true) {
						dp[i][j] = dp[si][j + 2];
					}
				}
			}
		}
		return dp[0][0];
	}

	public static boolean[][] initDPMap(char[] s, char[] e) {
		int slen = s.length;
		int elen = e.length;
		boolean[][] dp = new boolean[slen + 1][elen + 1];
		dp[slen][elen] = true;
		for (int j = elen - 2; j > -1; j = j - 2) {
			if (e[j] != '*' && e[j + 1] == '*') {
				dp[slen][j] = true;
			} else {
				break;
			}
		}
		if (slen > 0 && elen > 0) {
			if ((e[elen - 1] == '.' || s[slen - 1] == e[elen - 1])) {
				dp[slen - 1][elen - 1] = true;
			}
		}
		return dp;
	}

	public static void main(String[] args) {
		String str = "abcccdefg";
		String exp = "ab.*d.*e.*";
		System.out.println(isMatch(str, exp));
		System.out.println(isMatchDP(str, exp));

	}

}
