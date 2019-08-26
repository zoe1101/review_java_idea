package 字符串;
/*
给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。

输入: "abca"
输出: True
解释: 你可以删除c字符。
 */
//发现一个不对就再给两次机会, 一次机会给左边, 一次机会给右边, 两次机会都没把握就说明false
public class 验证回文字符串Ⅱ {
    public boolean validPalindrome(String s) {
        int left=0;
        int right=s.length()-1;
        while (left<right) {
        	if(s.charAt(left)==s.charAt(right)) {
    			left++;
    			right--;
    		}
        	else {
        		return validPalindrome(s, left+1, right) || validPalindrome(s, left, right-1);
		    }
        }
    	return true;
    }
    public boolean validPalindrome(String s, int left, int right) {
    	while(left<right) {
    		if(s.charAt(left)==s.charAt(right)) {
    			left++;
    			right--;
    		}
    		else {
    			return false;
    		}
    	}
    	return true;
    	
    }
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
