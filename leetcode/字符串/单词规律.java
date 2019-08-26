package 字符串;

import java.util.HashMap;
import java.util.Map;

import 字节跳动后端316.main1;

/*
给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。

这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中
的每个非空单词之间存在着双向连接的对应规律。

示例1:

输入: pattern = "abba", str = "dog cat cat dog"
输出: true

示例 2:

输入:pattern = "abba", str = "dog cat cat fish"
输出: false
 */
public class 单词规律 {
    public boolean wordPattern(String pattern, String str) {
    	 String[] book=new String[26];
    	 Map<String,Integer> map=new HashMap<>();
    	 String[] strings=str.split(" ");
    	 if (pattern.length()!=strings.length) {
			return false;
		}
    	 for (int i=0;i<pattern.length();i++)
         {
    		 char c=pattern.charAt(i);
    		 if(book[c-'a']==null && !map.containsKey(strings[i]))
             {
                 book[c-'a']=strings[i];
                 map.put(strings[i],c-'a');
             }
             else if(book[c-'a']==null) {
            	 return false;
             }
             else if(!map.containsKey(strings[i])) {
            	 return false;
             }
             else if(c-'a'!=map.get(strings[i])) {
            	 return false;
             }
         }
         return true;
    			 
    }
}
