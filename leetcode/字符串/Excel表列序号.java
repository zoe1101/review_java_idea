package 字符串;
/*
给定一个Excel表格中的列名称，返回其相应的列序号。

例如，

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
示例 1:

输入: "A"
输出: 1
示例 2:

输入: "AB"
输出: 28

 */
public class Excel表列序号 {
    public int titleToNumber(String s) {
        if (s.length()==1) {
			return s.charAt(0)-'A'+1;
		}
        char[] chas=s.toCharArray();
        
        int len=chas.length;
        int res=chas[len-1]-'A'+1;
        for (int i = len-2; i >=0; i--) {
        	int cur=chas[i]-'A'+1;
			res+=cur*Math.pow(26, len-i-1);
		}
        return res;
    }
}
