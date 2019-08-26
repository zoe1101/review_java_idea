package 字符串;
/*
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
 */
public class 最长回文子串 {
	
	//使用Manacher算法
	/**
	 * @param s
	 * @return
	 */
	public static String longestPalindrome(String s) {
		if (s==null ||s.length()==0) {
			return "";
		}
		String charArr=manacherstring(s);
		int[] pArr=new int[charArr.length()];  //记录以每个元素为中心的最大回文半径
		int pR=0;  //已遍历负的字符中最大的回文半径, 最大回文子串的右边界
		int index=0; //最近一次更新pR时，回文中心的位置, 最大回文子串的中心
		int maxlen=0; //记录最长的回文子串长度
		int resCenter = 0; 
		for(int i=1;i<charArr.length()-1;i++) {
			pArr[i]=pR>i?Math.min(pArr[2*index-i], pR-i):1;
			while (i+pArr[i]<charArr.length()-1&& i-pArr[i]>=0) {
				if(charArr.charAt(i+pArr[i])==charArr.charAt(i-pArr[i])) {
					pArr[i]++;
				}else {
					break;
				}
			}
			if(i+pArr[i]>pR) { //如果新计算的最右侧端点大于pR,则更新pR和index
				pR=i+pArr[i];
				index=i;
			}
			if(maxlen<pArr[i]) {
				maxlen=pArr[i];
				resCenter=i;
			}
		}
		System.out.println(index+" "+maxlen);
		return s.substring((resCenter-maxlen)/2,(resCenter+maxlen)/2-1);
	}
	
	//构造Manacher序列
	public static String manacherstring(String str) {
		StringBuilder res = new StringBuilder("$#");
		char[] charArr=str.toCharArray();
		for(int i=0;i<charArr.length;i++) {//统一扩展，解决奇偶差异性问题
			res.append(charArr[i]);
			res.append('#');
		}
		res.append('@');
		return res.toString();
		
	}
	
	//动态规划
    public static String longestPalindrome1(String s) {
        int len=s.length();
        if(len<=1) {
        	return s;
        }
        int start=0; //记录最大回文子串的起始位置
        int maxlen=1; //回文字符串的长度
        boolean dp[][]=new boolean[len][len];
        for(int i=0;i<len;i++) { //中心对脚线为true，因为是自己比自己
        	dp[i][i]=true;
        }
        
//        分为两种情况：
//        1、三个字母构成字串，然后在旁边各加两个字母再判断是否为回文
//        2、两个字母构成字串，然后在旁边各加两个字母再判断是否为回文
      //2的长度
        for(int i=0;i<len-1;i++) {
        	if(s.charAt(i)==s.charAt(i+1)) {
        		dp[i][i+1]=true;
        		start=i;
        		maxlen=2;
        	}
        }
        //3的长度和更多长度
        for(int i=2;i<len;i++) { // 枚举子串的长度
        	for(int j=0;j<len-i;j++) { // 枚举子串起始位置
        		if(s.charAt(j)==s.charAt(j+i) && dp[j+1][i+j-1]==true) {
        			if(i>maxlen-1) {//如果比最大值大再更改起始位置和最大长度
        				start=j;  
        				maxlen=i+1;
        			}
        			//不管大不大我们都要去更改dp数组，好告诉这一段是回文的
        			dp[i][j]=true;
        		}
        	}
        }
        return s.substring(start,start+maxlen);
        
    }

	public static void main(String[] args) {
		String string="abbada";
		System.out.println(longestPalindrome(string));
	}

}
