package 字符串;
/*
给定一个字符串 s1，我们可以把它递归地分割成两个非空子字符串，从而将其表示为二叉树。
下图是字符串 s1 = "great" 的一种可能的表示形式。

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
在扰乱这个字符串的过程中，我们可以挑选任何一个非叶节点，然后交换它的两个子节点。
例如，如果我们挑选非叶节点 "gr" ，交换它的两个子节点，将会产生扰乱字符串 "rgeat" 。

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
我们将 "rgeat” 称作 "great" 的一个扰乱字符串。
同样地，如果我们继续将其节点 "eat" 和 "at" 进行交换，将会产生另一个新的扰乱字符串 "rgtae" 。

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
我们将 "rgtae” 称作 "great" 的一个扰乱字符串。
给出两个长度相等的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。

示例 1:

输入: s1 = "great", s2 = "rgeat"
输出: true

 */
public class 扰乱字符串 {
    public boolean isScramble(String s1, String s2) {
    	if (s1.length()==0 && s2.length()==0) return true;
        if (s1.length()!=s2.length()) return false;
        return dfs(s1.toCharArray(), s2.toCharArray(), 0, 0, s1.length());
    }

	private boolean dfs(char[] s1, char[] s2, int start1, int start2, int len) {
		if (len==1) { //只有一个字符时
            return s1[start1]==s2[start2];
        }
		//存在多个字符,先判定字母出现次数是否一致
        if (!equals(s1, s2, start1, start2, len)) {
            return false;
        }
      //遍历每个切割位置
        for (int i=1; i<len; i++){
        	//S1 切割为两部分，然后进行若干步切割交换，最后判断两个子树分别是否能变成 S2 的两部分。
            if (dfs(s1, s2, start1, start2, i) && dfs(s1, s2, start1+i, start2+i, len-i)) return true;
            //S1 切割并且交换为两部分，然后进行若干步切割交换，最后判断两个子树是否能变成 S2 的两部分。
            if (dfs(s1, s2, start1, start2+len-i, i) && dfs(s1, s2, start1+i, start2, len-i)) return true;
        }
        return false;
	}
	//判断两个字符串每个字母出现的次数是否一致
	public boolean equals(char[] s1, char[] s2, int start1, int start2, int len){
        int[] charArr = new int[26];
        for (int i=0; i<len; i++) {
            charArr[s1[start1+i] - 'a']++;
            charArr[s2[start2+i] - 'a']--;
        }
      //如果两个字符串的字母出现不一致直接返回 false
        for (int item : charArr) {
            if (item != 0) return false;
        }
        return true;
    }
}
