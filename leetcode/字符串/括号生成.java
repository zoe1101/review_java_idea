package 字符串;

import java.awt.List;
import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;

import javax.naming.InitialContext;

/*
给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
例如，给出 n = 3，生成结果为：
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
//解题思路: 回溯法
//先写n个左括号，然后就写右括号，每当完成一组之后，就吧字符串存起来。
//然后再倒退步骤到写第n-1个左括号，然后写右括号，在写左括号，再全写右括号。
//依次回溯递归，每完成一趟就回到能再改变的位置。
public class 括号生成 {
    public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> list=new ArrayList<String>();
        String string=new String();
        generate(list,string,n,n);
        return list;
        
    }
    public static void generate(ArrayList<String> list,String str,int left,int right) {
    	//判断剩余左右括号数是否都为0
    	if(left==0 && right==0) { //所有括号都放置好了
    		list.add(str); //这时只要把上层递归传递来的已经保存好的括号字符串str添加到list中。
    		return;
    	}
    	if(left>0) {//还有剩余的左括号能排
    		generate(list,str+'(',left-1,right); //在原有排好的序列上的添加'('，再递归。
    	}
    	if(right>left) { //还有剩余的右括号能排,且剩余未添加的右括号不能数目必须比剩余左括号的多，保证括号的成对有效
    		generate(list,str+')',left,right-1); //在原有排好的序列上的添加')'，再递归。
    	}
		
	}

	public static void main(String[] args) {
		int n=3;
		System.out.println(generateParenthesis(n));

	}

}
