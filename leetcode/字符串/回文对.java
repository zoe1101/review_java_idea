package 字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， 
words[i] + words[j] ，可拼接成回文串。

示例 1:

输入: ["abcd","dcba","lls","s","sssll"]
输出: [[0,1],[1,0],[3,2],[2,4]] 
解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
示例 2:

输入: ["bat","tab","cat"]
输出: [[0,1],[1,0]] 
解释: 可拼接成的回文串为 ["battab","tabbat"]

 */
public class 回文对 {
    public List<List<Integer>> palindromePairs(String[] words) {
    	List<List<Integer>> res=new ArrayList<>();
    	Map<String, Integer> map=new HashMap<>();
//    	用哈希表来建立每个单词和其位置的映射
    	for(int i=0;i<words.length;i++){
    		map.put(words[i], i);
    	}
    	
    	for(int i=0;i<words.length;i++) { //遍历单词集
    		int l=0;
    		int r=0;
    		while(l<=r){
    			String s=words[i].substring(l, r);  //取出在角标间的字符串
    			//在字典中寻找该字符串对应的反转字符串，得到其下标
    			Integer j=map.get(new StringBuilder(s).reverse().toString());
    			
    			//如果能找到转置，其不是单词本身，剩下部分自回文
    			if( j!=null && i!=j && 
    				isPalindrome(words[i].substring(l==0?r:0,l==0?words[i].length():l)))
    				//刚开始是要把匹配的部分加在右侧；之后再加到左侧。用到数组转List
    				res.add(Arrays.asList(l==0?new Integer[]{i,j}:new Integer[]{j,i}));
    			//优先加r，r加到最大再加l，l也达到最大才停止
    			if(r<words[i].length())
    				++r;
    			else
    				++l;
    		}    				
    	}
    	return res;
    }

	private boolean isPalindrome(String s) {
		int left=0;
		int right=s.length()-1;
		while (left<right) {
			if (s.charAt(left)!=s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
    		
}
