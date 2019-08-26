package 校招真题在线编程;

/**
 * 京东2018测试开发工程师笔试编程题
 *
 * 给定一个字符串s，请计算输出含有连续两个s作为子串的最短字符串。
 * 注意两个s可能有重叠部分。例如，"ababa"含有两个"aba"。
 *
 * 输入描述：
 * 输入包括一个字符串s，字符串长度length(1 ≤ length ≤ 50)，s中每个字符都是小写字母。
 *
 * 输出描述：
 * 输出一个字符串，即含有连续两个s作为子串的最短字符串。
 *
 *示例：
 * 输入
 * abracadabra
 * 输出
 * abracadabracada
 * @author ZOE
 * @date 2019/8/6 21:45
 */
public class 最短字符串 {
//    这个题目是关于KMP算法中求next数组的问题，我们只需求出字符串最后一个字符后一位的next值。
    public static String answer(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char[] chas = str.toCharArray();
        if (chas.length == 1) {
            return str + str;
        }
        if (chas.length == 2) {
            return chas[0] == chas[1] ? (str + String.valueOf(chas[0])) : (str + str);
        }
        int endNext = endNextLength(chas);
        return str + str.substring(endNext);
    }

    public static int endNextLength(char[] chas) {
        int[] next = new int[chas.length + 1];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < next.length) {
            if (chas[pos - 1] == chas[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next[next.length - 1];
    }

    public static void main(String[] args) {
//        String test1 = "a";
//        System.out.println(answer(test1));
//
//        String test2 = "aa";
//        System.out.println(answer(test2));
//
//        String test3 = "ab";
//        System.out.println(answer(test3));
//
//        String test4 = "abcdabcd";
//        System.out.println(answer(test4));

        String test5 = "abracadabra";
        System.out.println(answer(test5));

    }

}
