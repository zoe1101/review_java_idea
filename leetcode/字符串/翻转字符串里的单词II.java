package 字符串;
/*
Given an input string , reverse the string word by word. 

Example:

Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
Note: 

A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces.
The words are always separated by a single space.
Follow up: Could you do it in-place without allocating extra space?
 */
public class 翻转字符串里的单词II {
//	1）将字符串整个翻转一遍；
//	2）将字符串的每个单词识别出来，并翻转一遍。
	public void reverseWords(String[] s) {
		int length = s.length;
        if (length == 0) {
            return;
        }
        reverse(s, 0, length-1);
        int start = 0, end = 0;
        while (start<=end) {
			end=start;
			while (end+1<length && s[end+1]!=" ") {
				end++;
			}
			reverse(s, start, end);
			start=end+2;
		}
        
	}
	public void reverse(String[] s,int start,int end) {
		String temp;
		while (start<end) {
			temp=s[start];
			s[start]=s[end];
			s[end]=temp;
			start++;
			end--;
		}
	}

}
