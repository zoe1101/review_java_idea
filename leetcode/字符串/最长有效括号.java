package 字符串;

import java.util.Stack;

/*
给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。


输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"

输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"
 */

//利用栈+动态规划的思想实现
public class 最长有效括号 {
    public int longestValidParentheses(String s) {
    	if (s==null || s.equals("")) {
			return 0;
		}
    	char[] chas=s.toCharArray();
    	int len=chas.length;
    	Stack<Integer> stack=new Stack<Integer>();
    	int max=0;
    	int start=0;
    	for (int i = 0; i < len; i++) {
			if (chas[i]=='(') { //遇左括号(，压栈(栈中元素为当前位置所处的下标)
				stack.push(i);
			}else {
				if (stack.isEmpty()) { //栈中没有与之对应的左括号，从下一个位置开始重新计算
					start=i+1;
				}else {
					stack.pop();
					if (stack.isEmpty()) { //栈中只有一个左括号了，弹出后计算有效长度
						max=Math.max(i-start+1, max);
					}else { //不止一个括号
						max=Math.max(i-stack.peek(), max);
					}
				}
			}
		}
    	return max;
    }
}
