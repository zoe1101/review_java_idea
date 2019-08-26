package 字符串;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import test.hashmap;

/*
给定一个非空字符串，其中包含字母顺序打乱的英文单词表示的数字0-9。按升序输出原始的数字。

注意:

输入只包含小写英文字母。
输入保证合法并可以转换为原始的数字，这意味着像 "abc" 或 "zerone" 的输入是不允许的。
输入字符串的长度小于 50,000。
示例 1:

输入: "owoztneoer"
输出: "012" (zeroonetwo)
示例 2:

输入: "fviefuro"
输出: "45" (fourfive)

 */
public class 从英文中重建数字 {
/*
 *一些单词是比较特殊的，可以通过统计特定字母的出现个数来统计单词数，
先对每个字母进行频度统计，然后遍历字母符号数组，依次从原字母频度统计列表中减掉该单词中字母频度最小
的字母频度数，并多次拼接字符串。最后，对得到的结果进行排序即可。
注意，删除单词有比较严格的顺序，首先删除eight因为只有eight有g,同理依次删除six、zero、two,删除完two之后就
可以删除three了，因为two删完，有t字母的只有three了，之后的顺序也是按照同样的方式进行推理。
 */
    public static String originalDigits(String s) {
    	 int[] nums={0,2,4,6,1,5,3,7,8,9};
         char[] indicates={'z', 'w', 'u', 'x', 'o', 'f', 'r', 'v', 'h', 'e'};
         String[] strs={"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
         char[] chas=s.toCharArray();
         Map<Character, Integer> charMap=new HashMap<Character, Integer>();
         for(char c : chas) {
        	 charMap.put(c, charMap.getOrDefault(c, 0)+1);
         }
 
         StringBuilder sb=new StringBuilder();
         for(int i=0; i<nums.length; i++){ //遍历数字
             if(charMap.containsKey(indicates[i]) && charMap.get(indicates[i]) != 0){
                 int count = charMap.get(indicates[i]); //字母出现次数
                 for(char c : strs[nums[i]].toCharArray()){
                	 if (charMap.containsKey(c)) {
                		 charMap.put(c, charMap.get(c)-count);
					}
                 }
                 for (int j = 0; j < count; j++) {
                	 sb.append('0'+nums[i]);
				}
             }
         }
         Arrays.sort(sb.toString().toCharArray());
         return sb.toString();
    }
    public static void main(String[] args) {
		String string="owoztneoer";
		System.out.println(originalDigits(string));
		
	}
}
