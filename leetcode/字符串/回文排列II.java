package 字符串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
给定一个字符串s，返回所有回文排列(不重复)。如果没有回文排列，则返回空列表。

样例
样例1

输入: s = "aabb"
输出: ["abba","baab"]
样例2

输入: "abc"
输出: []
 */
//组合问题
public class 回文排列II {
	//分奇偶考虑，如果是奇数，那么还需要枚举中间的字符
	//接下来我们只需要给字符串左半部做排列即可
	//我们可以先对字典序小的字符做排列，再在前面字符排列结果基础上对下一类字符做排列
	public List<String> generatePalindromes(String s) {
        int odd = 0;
        String mid = "";
        List<String> res = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        
    
        // step 1. build character count map and count odds
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
            odd += map.get(c) % 2 != 0 ? 1 : -1;
        }
    
        // cannot form any palindromic string
        if (odd > 1) return res;
    
        // step 2. add half count of each character to list
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
    
            if (val % 2 != 0) mid += key;
    
            for (int i = 0; i < val / 2; i++) list.add(key);
        }
    
        // step 3. generate all the permutations
        getPerm(list, mid, new boolean[list.size()], new StringBuilder(), res);
    
        return res;
    }
    
    // generate all unique permutation from list
    void getPerm(List<Character> list, String mid, boolean[] used, StringBuilder sb, List<String> res) {
        if (sb.length() == list.size()) {
            // form the palindromic string
            res.add(sb.toString() + mid + sb.reverse().toString());
            sb.reverse();
            return;
        }
    
        for (int i = 0; i < list.size(); i++) {
            // avoid duplication
            if (i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1]) continue;
    
            if (!used[i]) {
                used[i] = true; sb.append(list.get(i));
                // recursion
                getPerm(list, mid, used, sb, res);
                // backtracking
                used[i] = false; sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
