package 字符串;
/*
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

示例 1:

输入: "Let's take LeetCode contest"
输出: "s'teL ekat edoCteeL tsetnoc" 
注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class 反转字符串中的单词III {
    public String reverseWords(String s) {
        int len=s.length();
        if (len==0) {
			return "";
		}
        char[] chas=s.toCharArray();
        int start=0;
        for (int i = 0; i < len; i++) {
			if (i<len-1 && chas[i+1]==' ') {
				reverse(chas, start, i);
				start=i+2;
			}
			if (i==len-1) {
				reverse(chas, start, len-1);
			}
		}
        return String.valueOf(chas);
    }
    public void reverse(char[] s,int start,int end) {
		char temp;
		while (start<end) {
			temp=s[start];
			s[start]=s[end];
			s[end]=temp;
			start++;
			end--;
		}
	}
}
