package 字符串;
/**
 *旋转词的定义为两个字符串组成字符相同，只是字符排序不同。比如字符串abcd旋转词为bcda,cdab,dabc三个。
 * @author zoe
 *
 */
public class 判断两个字符串是否互为旋转词 {
	public static boolean isRotation(String s1,String s2) {
		if(s1==null ||s2==null ||s1.length()!=s2.length()) {
			return false;
		}
		String b2=s2+s2;
		return getIndexOf(b2,s1)!=-1; 
	}
	
	/**
	 * KMP算法，返回m在s中的开始位置，不包含时返回-1
	 * @param s:字符串
	 * @param m：匹配串
	 * @return
	 */
	public static int getIndexOf(String s, String m) {
		if (s.length() < m.length()) {
			return -1;
		}
		char[] ss = s.toCharArray();
		char[] ms = m.toCharArray();
		int si = 0;
		int mi = 0;
		int[] next = getNextArray(ms);
		while (si < ss.length && mi < ms.length) {
			if (ss[si] == ms[mi]) {
				si++;
				mi++;
			} else if (next[mi] == -1) {
				si++;
			} else {
				mi = next[mi];
			}
		}
		return mi == ms.length ? si - mi : -1;
	}

	public static int[] getNextArray(char[] ms) {
		if (ms.length == 1) {
			return new int[] { -1 };
		}
		int[] next = new int[ms.length];
		next[0] = -1;
		next[1] = 0;
		int pos = 2;
		int cn = 0;
		while (pos < next.length) {
			if (ms[pos - 1] == ms[cn]) {
				next[pos++] = ++cn;
			} else if (cn > 0) {
				cn = next[cn];
			} else {
				next[pos++] = 0;
			}
		}
		return next;
	}

	public static void main(String[] args) {
		String str1 = "yunzuocheng";
		String str2 = "zuochengyun";
		System.out.println(isRotation(str1, str2));
	}
		
}
