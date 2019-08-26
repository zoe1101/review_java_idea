package 字符串;
/*
给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
如果不存在最后一个单词，请返回 0 。
说明：一个单词是指由字母组成，但不包含任何空格的字符串。

示例:
输入: "Hello World"
输出: 5

 */
public class 最后一个单词的长度 {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        if (s.equals("")) {
			return 0;
		}
        int index=Integer.MAX_VALUE;
        for (int i = s.length()-1; i >=0; i--) {
			if (s.charAt(i)==' ') {
				index=i;
				break;
			}
		}
        if (index==Integer.MAX_VALUE) {
			return s.length();
		}
        return s.length()-index-1;
    }
}
