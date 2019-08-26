package 字符串;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/*
给定一个字符串，判断该字符串中是否可以通过重新排列组合，形成一个回文字符串。

示例 1：
输入: 
"code"
输出: false

示例 2：
输入: 
"aab"
输出: true
 */
public class 回文排列 {
/*
分字符串的个数是奇偶的情况来讨论，如果是偶数的话，由于回文字符串的特性，
每个字母出现的次数一定是偶数次，当字符串是奇数长度时，只有一个字母出现的次数是奇数，其余均为偶数，
那么利用这个特性我们就可以解题，我们建立每个字母和其出现次数的映射，
然后我们遍历 HashMap，统计出现次数为奇数的字母的个数，那么只有两种情况是回文数，
第一种是没有出现次数为奇数的字母，再一个就是字符串长度为奇数，且只有一个出现次数为奇数的字母
 */
	public static boolean canPermutePalindrome(String s) {
		int len=s.length();
		char[] str=s.toCharArray();
		HashMap<Character, Integer> map=new HashMap<Character, Integer>();
		for (char c:str) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		int oddcount=0;
		for (Entry<Character, Integer> entry:map.entrySet()) {
			int count=entry.getValue();
			if (count%2==1) {
				oddcount++;
			}
		}
		return oddcount==0 || (len%2==1 && oddcount==1);
	}
	public static void main(String[] args) {
		String s="add";
		System.out.println(canPermutePalindrome(s));
	}
}
