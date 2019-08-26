package 字符串;

import java.util.Map;
import java.util.Stack;

import 字节跳动后端316.main1;

/*
给定一个仅包含小写字母的字符串，去除字符串中重复的字母，使得每个字母只出现一次。
需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。

示例 1:
输入: "bcabc"
输出: "abc"

示例 2:
输入: "cbacdcbc"
输出: "acdb"

 */
public class 去除重复字母 {
    public static String removeDuplicateLetters(String s) {
        if (s==null || s.length()<2) {
			return s;
		}
        char[] chas=s.toCharArray();
        int[] map=new int[26]; //计算26字母数量
        boolean[] visited = new boolean[26];//标记字母是否已经入栈
        for (int i = 0; i < chas.length; i++) {
			map[chas[i]-'a']++;
		}
        Stack<Character> stack = new Stack<>();
        int index = 0;//最终字符的长度
        for (int count : map) {
            if (count > 0) index++;
        }
        char[] res = new char[index];
        for (int i = 0; i < chas.length; i++) {
            //有小字符的且满足其前面的字符在小字符后还有同样字符的，则出栈
            while (!stack.isEmpty() && chas[i] < stack.peek() 
            		&& map[stack.peek() - 'a'] > 1 && !visited[chas[i] - 'a']) {
                Character pop = stack.pop();
                visited[pop - 'a'] = false;
                map[pop - 'a']--;
            }
            if (visited[chas[i] - 'a']) {
            	map[chas[i] - 'a']--;//重复的字符根据游标往后移动，数量减一
                continue;
            }
            stack.push(chas[i]);
            visited[chas[i] - 'a'] = true;
        }

        while (!stack.isEmpty()) {
            res[--index] = stack.pop();
        }
        return String.valueOf(res);
    }
    public static void main(String[] args) {
		String string="bcabc";
		System.out.println(removeDuplicateLetters(string));
	}
}
