package 字符串;
/*
给定一个字符串，逐个翻转字符串中的每个单词。

示例 1：

输入: "the sky is blue"
输出: "blue is sky the"
示例 2：

输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。

说明:
无空格字符构成一个单词。
输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class 翻转字符串里的单词 {
	//分词逆序
    public String reverseWords(String s) {
    	StringBuffer stringBuffer=new StringBuffer();
    	if (s==null || s.trim().equals("")) {
			return "";
		}
        String[] str=s.trim().split(" +"); //"+"代表一个或多个的意思，这里分割是按照一个或多个空格切割。
        for (int i = str.length-1; i >=0; i--) {
			if (i==0) {
				stringBuffer.append(str[i]);
			}else {
				stringBuffer.append(str[i]+" ");
			}
		}
        return stringBuffer.toString();

    }
}
