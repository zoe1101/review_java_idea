package 字符串;

import java.util.Arrays;

public class 判断字符数组中是否所有的字符都只出现过一次 {
	public static boolean isUnique1(char[] chars) {
		if(chars==null) {
			return true;
		}
		boolean[] map=new boolean[256];
		for(int i=0;i<chars.length;i++) {
			if(map[chars[i]]) {
				return false;
			}
			map[chars[i]]=true;
		}
		return true;
	}
	public static void main(String[] args) {
		String string="abx";
		char[] chars=string.toCharArray();
		System.out.println(isUnique1(chars));
		
	}
}
