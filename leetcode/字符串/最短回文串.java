package 字符串;
/*
给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。
找到并返回可以用这种方式转换的最短回文串。

示例 1:
输入: "aacecaaa"
输出: "aaacecaaa"

示例 2:
输入: "abcd"
输出: "dcbabcd"

 */
public class 最短回文串 {
/*借助KMP数组找从头开始第一个不回文的位置，将其后面的字符逆序添加到开头即可
将原字符串s和其逆序字符串用“#”拼接在一起，利用KMP算法中next数组的求法求得拼接出的
新字符串的最长相同前后缀，就是原字符串s中最长的回文子串，该子串的左端点与字符串s的左端点重合。
*/
	public String shortestPalindrome(String s) {
		StringBuilder r = new StringBuilder(s).reverse();
		String str = s + "#" + r;
		int[] next = next(str);
		String prefix = r.substring(0, r.length() - next[str.length()]);
		return prefix + s;
    }
    //next数组
	private int[] next(String P) {
		int[] next = new int[P.length() + 1];
		next[0] = -1;
		int k = -1;
		int i = 1;
		while (i < next.length) {
			if (k == -1 || P.charAt(k) == P.charAt(i - 1)) {
				next[i++] = ++k;
			} else {
				k = next[k];
			}
		}
		return next;
	}

}
