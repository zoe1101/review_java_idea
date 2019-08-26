package 字符串;


/**判断是否是整体有效的括号字符串
 * 从左到右遍历string，如果遇到其他字符直接返回false
*         遇到'('时，left++
*         遇到')'时，left--
*         途中若left小于0直接返回false
*         最后比对left的长度是否为0 
 * @author zoe
 *
 */

public class 括号字符串的有效性和最长有效长度 {
	public static boolean isValid(String string) {
		if(string==null || string.length()==0) {
			return false;
		}
		char[] chas=string.toCharArray();
		int left=0;
		for(int i=0;i<chas.length;i++) {
			if(chas[i]!='(' && chas[i] !=')') { //只要有非()出现就返回false
				return false;
			}
			if(chas[i]==')' && --left<0) { //到目前为止,(比)少,返回false
				return false;
			}
			if(chas[i]=='(') {
				left++;
			}
		}
		return left==0; //如果(与)一样多，返回true，不然返回false
	}
//有效的括号字符子串的最大长度
	public static int maxLength(String str) {
		if (str == null || str.equals("")) {
			return 0;
		}
		char[] chas = str.toCharArray();
		int[] dp = new int[chas.length];
		int pre = 0;
		int res = 0;
		for (int i = 1; i < chas.length; i++) {
			if (chas[i] == ')') {
				pre = i - dp[i - 1] - 1; //应该和chas[i]匹配的左括号的索引位置
				if (pre >= 0 && chas[pre] == '(') { //成功配对
					dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
				}
			}
			res = Math.max(res, dp[i]);
		}
		return res;
	}
	public static void main(String[] args) {
		String str1 = "((())())";
		System.out.println(isValid(str1));
		System.out.println(maxLength(str1));

		String str2 = "(())(()(()))";
		System.out.println(isValid(str2));
		System.out.println(maxLength(str2));

		String str3 = "()(()()(";
		System.out.println(isValid(str3));
		System.out.println(maxLength(str3));

	}

}
