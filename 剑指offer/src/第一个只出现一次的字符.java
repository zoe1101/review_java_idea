package src;

import java.util.Arrays;
import java.util.HashMap;

/*
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 
 * 如果没有则返回 -1（需要区分大小写）.
 */
public class 第一个只出现一次的字符 {
    public static int FirstNotRepeatingChar(String str) {
    	char[] chas=str.toCharArray();
    	int[] hastTable=new int[58]; //大小写字母共58个

    	//统计字符出现的次数，存在hastTable中
    	for (int i = 0; i < chas.length; i++)
        {
            hastTable[chas[i]-'A']++;
        }
    	//按顺序进行遍历,将出现的此处为1的字符打印出来
        for (int i = 0; i < chas.length; i++)
        {
            if (hastTable[chas[i]-'A'] == 1)
            {
                return i;
            }
        }
        return -1;
    }
    
    //用哈希表的方式用来统计字符出现的字数，时间复杂度O(n)
    private int printFirstLetter2(String str) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
             if (hashMap.containsKey(str.charAt(i))){
                 int value = hashMap.get(str.charAt(i));
                 hashMap.put(str.charAt(i), value+1);
             }else {
                 hashMap.put(str.charAt(i), 1);
             }
        }

        for (int i = 0; i < str.length(); i++) {
            if (hashMap.get(str.charAt(i)) == 1){
            	return i;
            }
        }
        return -1;

    }
    public static void main(String[] args) {
	    String string="abbaccdeff";
	    System.out.println(FirstNotRepeatingChar(string));

	}

}
