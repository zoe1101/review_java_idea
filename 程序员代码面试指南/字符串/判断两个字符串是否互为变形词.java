package 字符串;
/**
给定两个字符串s1,s2,如果s1和s2中出现的字符种类和字符次数一样多，则s1和s2互为变形词，实现函数判断两个字符串是否为变形词。

例
s1=”123”,s2=”321” ,return true;
s1=”123”,s2=”2113”,return false;

 * @author zoe
 *
 */
public class 判断两个字符串是否互为变形词 {
	public static boolean isDeformation(String s1,String s2) {
		if(s1==null || s2==null ||s1.length()!=s2.length()) {
			return false;
		}
		int[] map=new int[256]; //asscii编码在0-255范围内,将每一个字符进行计数
		char[] str1=s1.toCharArray();
		char[] str2=s2.toCharArray();
		for(int i=0;i<str1.length;i++) {
			map[str1[i]]++;
		}
		
		for(int i=0;i<str2.length;i++) {
			if(map[str2[i]]--==0) {
				return false;
			}
		}
		return true;
	}
	

	public static void main(String[] args) {
		String A = "abcabcabc";
		String B = "bcacbaacc";
		System.out.println(isDeformation(A, B));

	}

}
