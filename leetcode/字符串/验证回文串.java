package 字符串;
/*
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
说明：本题中，我们将空字符串定义为有效的回文串。

输入: "A man, a plan, a canal: Panama"
输出: true
 */
public class 验证回文串 {
    public static boolean isPalindrome(String s) {
        if(s.length()<=1) return true;
        int n=s.length();
        s=s.toLowerCase();
        StringBuffer stringBuffer=new StringBuffer(n);
        for(char c:s.toCharArray()) {
        	if((c>='0' &&c<='9') ||(c>='a' && c<='z')) {
        		stringBuffer.append(c);
        	}
        }
        return stringBuffer.toString().equals(stringBuffer.reverse().toString());
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
