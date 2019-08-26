package 字符串;
//给定字符串str1和str2,求str1的子串中含有str2所有字符的最小子串长度)
public class 最小包含子串的长度 {
	public static int minLength(String str1,String str2) {
		if (str1==null ||str2==null || str1.length()<str2.length()) {
			return 0;
		}
		char[] chas1=str1.toCharArray();
		char[] chas2=str2.toCharArray();
		int[] map=new int[256]; //使用一个表记录str2中每一个字符出现的次数。
		for (int i = 0; i < chas2.length; i++) {
			map[chas2[i]]++;
		}
//		left，right表示str1子串str1[left…right]的两边界下标
		int left=0;
		int right=0;
//		match表示在子串str1[left…right]中目前一共欠str2多少个字符。
		int match=chas2.length;
		int minLen=Integer.MAX_VALUE; //记录整个遍历过程中出现的最小的子串长度。
		
		//遍历str1，先向右扩张right，当遇到str2中的字符时，将map中相应的值 -1，同时match也 -1；
		//如果遇到的不是str2中的字符，将(str1[right]，-1)记录到map中
		while (right!=chas1.length) {
			map[chas1[right]]--; //str2中有的就是map[chas1[right]]-1,没有的就是0-1;都是map[chas1[right]]-1
			if (map[chas1[right]]>=0) {
				match--;
			}
			//当match == 0时，说明str1[left…right]已经包含了str2中的所有字符，
			//但是此时的子串长度不一定是该子串的最小长度.
			//所以接下来还有一个向右扩张left的过程。 
			if (match==0) {
				//向右扩张left,如果map[str1[left]] < 0，说明此时如果把这个字符捡起来，
				//str1[left…right]中也不会欠str2字符，所以捡起该字符。
				while (chas1[left]<0) {
					map[chas1[left++]]++;
				}
				//如果map[str1[left]] == 0，说明一旦捡起该字符，那么str1[left…right]必然会欠str2一个字符，
				//所以此时left扩张终止，此时left到right的值便是一个最小子串。 
				minLen=Math.min(minLen, right-left+1);
				match++;
				map[chas1[left++]]++;
			}
			right++;
		}
		return minLen==Integer.MAX_VALUE?0:minLen;
	}

}
