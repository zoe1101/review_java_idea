package 字符串;
/*
 编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:
输入: ["flower","flow","flight"]
输出: "fl"
 */
public class 最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
    	if (strs==null || strs.length==0) {
			return "";
		}
    	if (strs.length == 1){
            return strs[0];
        }
    	StringBuilder sb = new StringBuilder();
    	int len=strs[0].length();
    	//把第一个字符串当做基准字符串，然后与其他的字符串依次比较
    	for (int i = 0; i <len; i++) { 
    		char cur = strs[0].charAt(i);
    		for (int j = 1; j < strs.length; j++) {
    			if (strs[j].length()<=i ||strs[j].charAt(i) != cur) {
                    return sb.toString();
                }
    			if (strs[j].charAt(i) == cur && j == strs.length - 1) {
                    sb.append(cur);
                }
    				
			}
		}
    	return sb.toString();
	}

}
