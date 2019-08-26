package 字符串;

import java.util.Stack;

////解题思路，就是遍历字符数组，遇到左括号，左括号索引放入左括号栈，遇到*号，索引放入star栈。
//当遇到右括号的时候，这就先优先从左括号出栈，如果左括号栈空了，再从star栈出栈.否则返回false。
//最后，判断星号能否代替右括号。
public class 有效的括号字符串 {
	public static boolean checkValidString(String s) {
		if(s.isEmpty()) return true;
		int count_left=0,count_star=0,count_right=0;
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if(c=='(') {
				count_left++;
			}else if(c=='*') {
				count_star++;
			}else {
				if(count_left>0) {//先用右括号匹配左括号
					count_left--;
				}else if(count_star>0) {//再用右括号匹配星号
					count_star--;
				}else {//如果左括号和星号也用完了,直接返回false，右括号有多的
					return false;
				}
			}
		}
		count_left=0;
		count_star=0;
		for(int i=s.length()-1;i>=0;i--) {
			char c=s.charAt(i);
			if (c==')') {//右括号
				count_right++;
			}else if(c=='*') { //星号
				count_star++; 
			}else { //左括号
				if(count_right>0) {//左括号匹配右括号
					count_right--;
				}else if(count_star>0) { //右括号匹配星号
					count_star--;
				}else { //如果右括号和星号也用完了,直接返回false，左括号还有多的
					return false;
				}
			}
			
		}
		return true;
	}
	public static boolean checkValidString1(String s) {
		 if(s==null||s.length()==0)
	            return true;
	   Stack<Character> leftParenthesis=new Stack<Character>(); //用来存放左括号
	   Stack<Character> starParenthesis=new Stack<Character>(); //用来存放星号
	   for(int i=0;i<s.length();i++) {
		   char c=s.charAt(i);
		   if(c=='(') {//左括号
			   leftParenthesis.push(c);
		   }else if(c=='*'){//星号
			   starParenthesis.push(c);
		   }else { //右括号
			   if(!leftParenthesis.isEmpty()) { //左括号栈有存货
				   leftParenthesis.pop();
			   }else { //左括号空了，开始从star栈找
				   if(!starParenthesis.isEmpty()) {//*号栈必须出栈了，用来代表左括号 
//					   starParenthesis.pop();
				   }else {//如果*栈也空了,直接返回false
					   return false;
				   }
			   }
		   }
	   }
	   //遍历完字符数组后，需要判断左括号栈，和*栈了。针对*（这中情况,左括号在*号的右边
	   while (!leftParenthesis.isEmpty() && !starParenthesis.isEmpty()) {//判断星号能否代替右括号。
		   if(leftParenthesis.peek()>starParenthesis.peek()) { //peek()函数返回栈顶的元素，但不弹出该栈顶元素。
			   return false;
		   }
		   leftParenthesis.pop();
		   starParenthesis.pop();
	   }
	   //最后只需要判断左括号是否有剩余。毕竟最后如果剩下的都是***,那都是有效括号空字符
	   return leftParenthesis.isEmpty();
	}

	public static void main(String[] args) {
		String string="(*()";
		System.out.println(checkValidString(string));
	}

}
