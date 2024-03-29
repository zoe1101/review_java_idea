package 字符串;
/*
编写一个函数，以字符串作为输入，反转该字符串中的元音字母。

示例 1:

输入: "hello"
输出: "holle"
示例 2:

输入: "leetcode"
输出: "leotcede"
说明:
元音字母不包含字母"y"。

 */
public class 反转字符串中的元音字母 {
    public String reverseVowels(String s) {
    	if(s == null) return s;
    	char[] c = s.toCharArray();
        int low = 0, high = c.length-1;
        char temp;
        while(low <= high){
            while(low<=high && !isValid(c[low])) {
            	low++;
            }
            while(low<=high && !isValid(c[high])) { 
            	high--;
            }
            
            if(low<=high){
                temp = c[low];
                c[low] = c[high];
                c[high] = temp;
                low++;
                high--;
            }
        }
        return new String(c);
    }
    private boolean isValid(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u'
            || c=='A' || c=='E' || c=='I' || c=='O' || c=='U';
    }
}
