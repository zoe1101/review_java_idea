package 字符串;

import java.util.ArrayList;
import java.util.List;

/*
给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
返回 s 所有可能的分割方案。

示例:
输入: "aab"
输出:
[
  ["aa","b"],
  ["a","a","b"]
]

 */
//回溯法
public class 分割回文串 {
	List<List<String>> res=new ArrayList<>();
    public List<List<String>> partition(String s) {
        process(0,s,new ArrayList<>());
        return res;
    }
    public void process(int start,String s,List<String> tmp){
        if(start==s.length()){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int end=start+1;end<=s.length();end++){
            String candi=s.substring(start,end);
            if(!isPal(candi)){ //不是回文
                continue;
            }
            //如果是回文字符串，就查找剩余的回文字符串
            tmp.add(candi);
            process(end,s,tmp);
            tmp.remove(tmp.size()-1);
        }
    }
    public boolean isPal(String s){
        int left=0;
        int right=s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        
        }
        return true;
    }
}
