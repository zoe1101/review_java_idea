package 字符串;
/*\
给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
*****注意:
假设字符串的长度不会超过 1010。

输入:
"abccccdd"
输出:
7
解释:
我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class 构造最长回文串 {
    public static int longestPalindrome(String s) {
         //由于一个字母出现偶数次，那么必定可以构成回文字符串中的元素(两边平均分配)
		//如果一个字母出现奇数次，只能取偶数次填充回文串 奇数次 - 1
        //最后可以在回文串的中间放入一个单个字符

        int[] charcount=new int[58]; ////大小字母一共56个
        for(char c:s.toCharArray()) {
        	charcount[c-'A']++; //字符计数
        }
        int count=0; //最长回文串字符计数
        for(int t:charcount) {
        	count+=(t>>1<<1); //(t/2)*2
        }
        return count==s.length()?count:count+1;
    }

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
