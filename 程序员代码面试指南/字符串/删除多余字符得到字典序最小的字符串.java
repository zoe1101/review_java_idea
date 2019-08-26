package 字符串;

public class 删除多余字符得到字典序最小的字符串 {
	public static String removeDuplicateLetters(String s) {
		char[] str=s.toCharArray();
		int[] map=new int[26]; //对26个字母进行字频统计
		for (int i = 0; i < str.length; i++) {
			map[str[i]-'a']++;
		}
		char[] res=new char[26];
		int index=0; //当前字符的在字典中的索引位置
		//在str[i..r]中找到最小的字符最为当前字符
		int l=0;
		int r=0;
		while (r!=str.length) {
			if (map[str[r]-'a']==-1 || --map[str[r]-'a']>0) {
				r++;
			}else {
				int pick=-1;
				for (int i = l; i <= r; i++) {
					if (map[str[i]='a']!=-1 && (pick==-1 || str[i]<str[pick])) {
						pick=i;
					}
				}
				res[index++]=str[pick];
				for (int i = pick+1; i <= r; i++) {
					if (map[str[i]='a']!=-1) {
						map[str[i]-'a']++;
					}
					
				}
				map[str[pick]-'a']=-1; //当前字符被使用后，置为-1，后续将不再考虑
				l=pick+1; //在当前字符的索引位置的后半部分查找下一个字符
				r=l;
			}
		}
		return String.valueOf(res,0,index);
	}

}
