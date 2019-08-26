package 字符串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
给出数字到字母的映射如下（与电话按键相同）。注意 1不对应任何字母。
输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

 */
//排列问题
//解题思路: 回溯算法,递归求解
public class 电话号码的字母组合 {
    public static ArrayList<String> letterCombinations(String digits) {
    	ArrayList<String> list=new ArrayList<String>();
    	if (digits.length()==0) {
    		return list;
    	}
    	String string=new String();
    	backtracking(list, string, digits,0 );
    	return list;
    }
    
    public static void backtracking(ArrayList<String> list,String string,String digits,int flag) {
    	 String[] numberstring = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    	 if(flag>=digits.length()) { //排完了
    		 list.add(string);
    		 return;
    	 }
    	 String chars=numberstring[digits.charAt(flag)-'0']; //当前数字
    	 for(int i=0;i<chars.length();i++) {   //遍历一个数字对应的所有字母
    		 backtracking(list, string+chars.charAt(i), digits, flag+1);//遍历下一个数字对应的所有字母
    	 }//排列问题
    	 
	}
    

	public static void main(String[] args) {

		String digits="34";
		System.out.println(letterCombinations(digits));

	}

}
