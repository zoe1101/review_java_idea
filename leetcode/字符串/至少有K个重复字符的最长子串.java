package 字符串;
/*
找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。
输出 T 的长度。

示例 1:
输入:
s = "aaabb", k = 3
输出:
3
最长子串为 "aaa" ，其中 'a' 重复了 3 次。

示例 2:
输入:
s = "ababbc", k = 2
输出:
5
最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。

 */

/*
算法思想 : 分治法, 递归
使用一个数组来存储字符串中每个字符的个数, 遍历找出其中个数小于 k 的字符，
根据这些字符对字符串进行分隔，递归求解分隔以后的更小的子问题。
 */
public class 至少有K个重复字符的最长子串 {
	public int res = 0;
    public int longestSubstring(String s, int k) {
    	getlongest(s, k);
    	return res;
    }
	private void getlongest(String s, int k) { // 分治
		int len = s.length();
    	if(len == 0) return;
    	int[] count = new int[26];//记录每个字符个数 
    	for(char c : s.toCharArray()) {
    		count[c-'a']++;
    	}
    	int l = 0;
    	boolean greater = true;
    	for(int i = 0; i < len; i++) {//个数 < k, 分隔，递归求解子问题 
    		if(count[s.charAt(i) - 'a'] != 0 && count[s.charAt(i) - 'a'] < k) {	// 分隔处理	
				if(i > l) {
					getlongest(s.substring(l, i), k);
				}
				greater = false;
				l = i + 1;
    		}
    	}
    	
    	if(!greater && len > l) {
    		getlongest(s.substring(l, len), k);
    	}
    	if(greater) {	//该字符串满足条件 
    		res = Math.max(res, len);
    	}
	}
}
