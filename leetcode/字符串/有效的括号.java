package 字符串;

import java.util.Stack;

import javax.naming.InitialContext;

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。
示例 1:

输入: "()[]{}"
输出: true
 */
//[ ( { 入栈 ,  ] ) } 出栈 . 出栈时比较是否对应,否则返回false
//循环完整个字符串之后 栈必须为空 否则false
public class 有效的括号 {

    public static boolean isValid(String s) {
    	Stack<Character> stack=new Stack<Character>();
    	for(int i=0;i<s.length();i++) {
    		char c=s.charAt(i);
    		if(c=='(' ||c=='[' ||c=='{') {//将有效括号压入栈
    			stack.push(c);
    		}else { 
    			if(!stack.isEmpty()) {
	    			char topchar=stack.pop(); //栈顶元素
	    			if(c!=')' && topchar=='(') {
	    				return false;
	    			}else if(c!=']' && topchar=='[') {
	    				return false;
	    			}else if(c!='}' && topchar=='{') {
	    				return false;
	    			}
    			}else {
	    			return false;
	    		}
			}
		}
    	if(!stack.isEmpty()){
    		return false;
    	}
    	return true;
    }

	public static void main(String[] args) {
		String string="((())){}{}";
		System.out.println(isValid(string));
	}

}
