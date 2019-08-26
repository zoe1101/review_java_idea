package 字符串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Given a string, we can "shift" each of its letter to its successive letter, 
for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, 
group all strings that belong to the same shifting sequence.

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
A solution is:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
 */
public class 移位字符串分组 {
/*
同的移位string，拥有相同的移位距离，比如abc, bcd, xyz 都是移位了1个距离。
根据这个特性，我们可以把bcd 和 xyz 恢复到 abc。

利用HashMap，把最原始的 归位string 当作key，把可以恢复到 原始的归位string
的 所有strings（List）当作value 存入map。
 */
	 public List<List<String>> groupStrings(String[] strings) {
	     List<List<String>> res = new ArrayList<>();
	     HashMap<String, List<String>> map = new HashMap<>();
	     
	     // store original string as key; (List) strings come from same original one as value
	     for(String str: strings){
	         int offset = str.charAt(0) - 'a'; //首字母离字母a的距离，一定是正数
	         String key = "";
	         for(int i=0; i<str.length(); i++){
	        	//判定当前字母是什么
	             char c = (char) (str.charAt(i) - offset); 
	             if(c < 'a') { //
	                 c += 26;
	             }
	             key += c;
	         }
	          
	         if(!map.containsKey(key)) {
	             map.put(key, new ArrayList<String>());
	         }
	         map.get(key).add(str);
	         
	     }
	     
	     // add each key's value into res
	     for(String key: map.keySet())
	     {
	         res.add(map.get(key));
	     }
	     
	     return res;
	 }
}
