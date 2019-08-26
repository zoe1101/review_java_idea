package 字符串;

import java.util.HashMap;
import java.util.Map;

/*
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

案例:

s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.
 */
public class 字符串中的第一个唯一字符 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map=new HashMap<>();
        char[] chas=s.toCharArray();
        for (char c:chas) {
        	map.put(c, map.getOrDefault(c, 0) + 1);
		}
        for (char i = 0; i < chas.length; i++) {
			if (map.get(chas[i])==1) {
				return i;
			}
		}
        return -1;
        
    }
}
