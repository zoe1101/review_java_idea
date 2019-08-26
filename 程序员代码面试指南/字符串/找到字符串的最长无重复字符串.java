package 字符串;

public class 找到字符串的最长无重复字符串 {
	//利用哈希表实现
	public static int maxUnique(String str) {
		if (str==null || str.length()==0) {
			return 0;
		}
		char[] chas=str.toCharArray();
		int[] map=new int [256]; //256个ascii码在字符串中最近一次出现的位置
		for (int i = 0; i < chas.length; i++) {
			map[i]=-1;
		}
		int len=0; //最长无重复字符串的长度
		int pre=-1; //最长无重复字符串开始位置的前一个位置
		int cur=0; //当前无重复字符串的长度
		for (int i = 0; i < chas.length; i++) {
			pre=Math.max(pre, map[chas[i]]);
			cur=i-pre;
			len=Math.max(len, cur);
			map[chas[i]]=i;
		}
		return len;		
	}

}
