package 字符串;

public class 找到指定的新类型字符 {
	public static String pointNewChar(String str,int k) {
		if (str==null || str.length()==0 || k<0 || k>str.length()) {
			return "";
		}
		char[] chas=str.toCharArray();
		int upperNum=0; //从k-1位置到遇到小写字母前的大写字母的个数
		for (int i = k-1; i>=0; i--) {
			if (!(chas[i]>='A' && chas[i]<='Z')) { //不是大写字母
				break;
			}
			upperNum++;
		}
		//upperNum为奇数,则str[k-1..k]为指定的新类型字符串
		if ((upperNum&1)==1) { 
			return str.substring(k-1,k+1);
		}
		//upperNum为偶数且str[k]为大写字母，则str[k..k+1]为指定的新类型字符串
		if (chas[k]>='A' && chas[k]<='Z') { 
			return str.substring(k,k+2);
		}
		//upperNum为偶数且str[k]为小写字母，则str[k]为指定的新类型字符串
		return str.substring(k,k+1);
	}

}
