package src;
/*
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */

/*
 当模式中的第二个字符不是“*”时：
1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
2、如果字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。

而当模式中的第二个字符是“*”时：
可以有3种匹配方式：
1、模式后移2字符，相当于x*被忽略；
2、字符串后移1字符，模式后移2字符，x*相当于只匹配一个字符；
3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；
 */
public class 正则表达式匹配 {
    //	递归法
    public static  boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return isValid(str, pattern) ? process(str, pattern, 0, 0) : false; //在输入有效的情况下进行递归判断

    }

    //从str的si位置开始，一直到str结束位置的子串，
// 即str[si...slen],是否能被pattern的pa位置开始一直到pattern结束位置的子串表示
    private static boolean process(char[] str, char[] pattern, int si, int pi) {
        if (pi == pattern.length) { //pi为结束位置，且si也为结束位置，则匹配成功
            return si == str.length;
        }
        //pi位置的下一个字符pattern[pi+1]不是‘*’，
        // 则关注str[si]与pattern[pi]是否匹配：pattern[pi]==str[si] || pattern[pi]=='.'
        // 并关注str的后续部分是否与pattern的后续匹配 ：process(str,pattern,si+1,pi+1)
        if (pi + 1 == pattern.length || pattern[pi + 1] != '*') {
            return si != str.length && (pattern[pi] == str[si] || pattern[pi] == '.'
                    && process(str, pattern, si + 1, pi + 1));
        }
        //pi位置的下一个字符pattern[pi+1]是‘*’，
        // str[si]与pattern[pi]不匹配，则让pattern[si..ei+1]部分为“”（空字符），即不匹配pi位置的字符。并考察后续是否匹配：process(str,pattern,si,pi+2)
        //str[si]与pattern[pi]匹配，即pattern[si..ei+1]部分(a*)如果能匹配str后续部分，则返回true

        while (si != str.length && (pattern[pi] == str[si] || pattern[pi] == '.')) {
            if (process(str, pattern, si, pi + 2)) {
                return true;
            }
            si++;
        }
        return process(str, pattern, si, pi + 2);
    }

    //判断输入字符串是否有效
    public static boolean isValid(char[] s, char[] e) {
        //源字符串不嗯呢该包含‘.’与‘*’
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '*' || s[i] == '.') {
                return false;
            }
        }
        //模式串首字符不能是‘*’，并且任意两个‘*’字符不能相邻
        for (int i = 0; i < e.length; i++) {
            if (e[i] == '*' && (i == 0 || e[i - 1] == '*')) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str="abc";
        String pattern="a.c*";
        System.out.println(match(str.toCharArray(),pattern.toCharArray()));
    }



}
