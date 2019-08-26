package 字符串;
/*
给定一个正整数，返回它在 Excel 表中相对应的列名称。

例如，

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
示例 1:
输入: 1
输出: "A"

示例 2:
输入: 28
输出: "AB"

 */
public class Excel表列名称 {
    public String convertToTitle(int n) {
    	if (n <= 0) {
            return "";
        }
        StringBuilder str = new StringBuilder();
        while (n > 0) {
            n--;
            str.append((char) (n % 26 + 'A'));
            n =n/26;
        }
        return str.reverse().toString();
    }
}
