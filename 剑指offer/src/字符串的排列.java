package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如:输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * @author zoe
 *
 *
 * 全排列的思想，先确定第i个，然后与后序元素的全排列进行拼接
 */
public class 字符串的排列 {
    public ArrayList<String> Permutation(String str) {
    	ArrayList<String> res = new ArrayList<String>();
        if(str==null || str.length()==0) {
        	return res;
        }
        char[] chas=str.toCharArray();
        findPermutation(res, chas, 0);
        Collections.sort(res);//Collections的sort方法，对传入的list进行排序，直接改变原list，无返回值。
        return res;
        
    }
  //对chas[i~length-1]范围内的字符数组完成全排列，并将结果加入res中
    public void findPermutation(ArrayList<String> res, char[] chas, int i) {
    	if(i==chas.length) {
    		res.add(new String(chas));
    		return;
    	}
    	HashSet<Character> set=new HashSet<Character>();
    	 //从【i~length-1】中枚举确定i位置的字符
    	//abc
    	for(int j=i;j<chas.length;j++) {
    		//如果以前未被选过
    		if(!set.contains(chas[j])) {
    			set.add(chas[j]);
    			swap(chas, i, j); //交换
    			//确定好i位置，对chas[i+1~length-1]范围内的字符数组完成全排列
    			findPermutation(res, chas, i+1);
    			swap(chas, i, j); //恢复原数组,abc
    		}
    	}
    }
    public void swap(char[] chas, int i, int j) {
        char temp = chas[i];
        chas[i] = chas[j];
        chas[j] = temp;
    }
}
