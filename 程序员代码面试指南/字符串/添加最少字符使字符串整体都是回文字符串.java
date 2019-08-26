package 字符串;

public class 添加最少字符使字符串整体都是回文字符串 {
	public static String getPalindrome1(String str) {
		if (str==null ||str.length()<2) {
			return str;
		}
		char[] chas=str.toCharArray();
		int[][] dp=new int[chas.length][chas.length];
		for (int j = 1; j < dp.length; j++) {
			dp[j-1][j]=chas[j-1]==chas[j]?0:1;
			for (int i = j-2; i >=0; i--) {
				if (chas[i]==chas[j]) { //i，j位置相等，只需要计算中间位置的值
					dp[i][j]=dp[i+1][j-1];
				}else {//i，j位置不相等，可以先使[i,j-1]或[i+1,j]成为回文串，然后再取操作次数较少的那一个
					dp[i][j]=Math.min(dp[i][j-1], dp[i+1][j])+1;
				}
			}
		}
		int newlen=chas.length+dp[0][chas.length-1];
		char[] res=new char[newlen];
		int i=0;
		int j=chas.length-1;
		int resl=0;
		int resr=newlen-1;
		while (i<=j) {
			if (chas[i]==chas[j]) {
				res[resl++]=chas[i++];
				res[resr--]=chas[j--];
			}else if (dp[i][j-1]<dp[i+1][j]) { //选择了先使[i,j-1]成为回文串，再在i的左边添加chas[j]的值
				res[resl++]=chas[j];
				res[resr--]=chas[j--];
			}else {//选择了先使[i+1,j]成为回文串，再在j的右边添加chas[i]的值
				res[resl++]=chas[i];
				res[resr--]=chas[i++];
			}
		}
		return String.valueOf(res);
	}
	
	//进阶部分，剥洋葱过程
	public static String getPalindrome2(String str,String strlps) {
		if (str==null ||str.equals("")) {
			return "";
		}
		char[] chas=str.toCharArray();
		char[] lps=strlps.toCharArray();
		char[] res=new char[chas.length*2-lps.length];
		int chasl=0;
		int chasr=chas.length-1;
		int lpsl=0;
		int lpsr=lps.length-1;
		int resl=0; //res变换的起始位置
		int resr=res.length-1; //res变换的结束位置
		int tmpl=0;  //记录chas左边需要变动的起始位置
		int tmpr=0;  //记录chas右边需要变动的结束位置
		while (lpsl<=lpsr) {
			tmpl=chasl; 
			tmpr=chasr; 
			while (chas[chasl]!=lps[lpsl]) { //找到左边lps[lpsl]在chas中对应的位置
				chasl++;
			}
			while (chas[chasr]!=lps[lpsr]) {//找到右边lps[lpsr]在chas中对应的位置
				chasr--;
			}
			set(res, resl, resr, chas, tmpl, chasl, chasr, tmpr);
			resl+=chasl-tmpl+tmpr-chasr; 
			resr-=chasl-tmpl+tmpr-chasr; 
			//把lps[lps1]和lps[lpsr]对应的回文字符填入，lps指向移位
			res[resl++]=chas[chasl++]; 
			res[resr--]=chas[chasr--];
			lpsl++;
			lpsr--;
		}
		return String.valueOf(res);
		
	}
	/**
	 * 
	 * @param res
	 * @param resl
	 * @param resr
	 * @param chas
	 * @param ls:左边需要变动的起始位置
	 * @param le：左边需要变动的结束位置
	 * @param rs：右边需要变动的起始位置
	 * @param re：右边需要变动的结束位置
	 */
	public static void set(char[] res,int resl,int resr,char[] chas,int ls,int le,int rs,int re) {
		for (int i = ls; i < le; i++) { //左边正序放在res的左边，右边逆序放在res的右边
			res[resl++]=chas[i];
			res[resr--]=chas[i];
		}
		for (int i = re; i> rs; i--) { //左边逆序放在res的左边，右边正序放在res的右边
			res[resl++]=chas[i];
			res[resr--]=chas[i];
			
		}
	}
	
	public static void main(String[] args) {
		String str = "AB1CD2EFG3H43IJK2L1MN";
		System.out.println(getPalindrome1(str));

		String strlps = "1234321";
		System.out.println(getPalindrome2(str, strlps));

	}
}
