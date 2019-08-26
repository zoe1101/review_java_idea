package 字符串;

import java.util.HashMap;
import java.util.Map;

import test.hashmap;

/*
给定一个字符串，请你找出其中不含有重复字符的 最长子串的长度。

示例 1:
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

挑战：O(n) 时间 
 */
//如果要实现O(n) 时间，必须一次遍历字符串。 
//用HashMap<字符，位置>储存每个字符的位置，用temp记录当前字符串长度。
public class 无重复字符的最长子串 {
	//hash
    public static int lengthOfLongestSubstring(String s) {
    	Map<Character, Integer> posMap=new HashMap<Character, Integer>();
    	char[] ss=s.toCharArray();
    	int max=0;
		int temp=0;  //记录当前字符串长度
    	for(int i=0;i<s.length();i++) { //字符串遍历, i是当前字符位置
    		if(!posMap.containsKey(ss[i])) { //未出现重复字符
    			posMap.put(ss[i], i);
    			temp++;
    		}else { //出现重复字符
    			
    			if(posMap.get(ss[i]) + temp < i){ //字符上一次出现位置不在当前字符串内
                    temp++;                
                }else {
	    			max=Math.max(max, temp);
	    			temp=i-posMap.get(ss[i]);  
                }
    			posMap.put(ss[i], i); //更换key所对应的值
    		}
    	}
    	 max=Math.max(max, temp);
    	 return max;

    }
	public static void main(String[] args) {
		String s= "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s));

	}
   

}
