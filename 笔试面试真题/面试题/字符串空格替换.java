package 面试题;

/*
请实现一个函数，将一个字符串中的每个空格替换成“%20”。

当字符串为We Are Happy.
则经过替换之后的字符串为We%20Are%20Happy。
 */
public class 字符串空格替换 {
	
	public static String replaceSpace1(StringBuffer str) {
		String reString=str.toString();
		if(reString.contains(" ")) {
			while (str.indexOf(" ")!=str.lastIndexOf(" ")) {
				int index=str.indexOf(" ");
				str.replace(index, index+1, "%20");
			//StringBuffer的indexOf方法找不到时返回值为-1	
			}
			int index=str.indexOf(" ");
			str.replace(index, index+1, "%20");
			reString=str.toString();
			return reString;
		}else {
			return reString;
		}
	}
	
	public static String replaceSpace2(StringBuffer str) {
		int index=str.indexOf(" ");
		while (index!=-1) {//StringBuffer的indexOf方法找不到时返回值为-1	
			str.replace(index, index+1, "%20");
			index=str.indexOf(" ",index);//查找下一个空格
		}
		
		String reString=str.toString();
		return reString;
	}
	
	
//不调用replace的方法
//	从前往后替换，后面的字符要不断往后移动，要多次移动，所以效率低下
//  从后往前，先计算需要多少空间，然后从后往前移动，则每个字符只为移动一次，这样效率更高一点。
	public static String replaceSpace3(StringBuffer str) {
		int len=str.length();//字符串的长度
		int space_count=0;//空格的个数
		for(int i=0;i<len;i++) {
			if(str.charAt(i)==' ') {//空格计数
				space_count++;
			}
		}
		int new_len=len+2*space_count;//新的字符串长度
		int index_old=len-1;
		int index_new=new_len-1;
		str.setLength(new_len);
		while(index_old>=0 && index_new>index_old) {
			if(str.charAt(index_old)!=' ') {
				str.setCharAt(index_new--, str.charAt(index_old));
			}else {//如果是空格 
				str.setCharAt(index_new--, '0');
				str.setCharAt(index_new--, '2');
				str.setCharAt(index_new--, '%');
			}
			index_old--;
		}
		return str.toString();
		
//		char[] char_str=new char[new_len];
//		while(index_old>=0) {
//			if(str.charAt(index_old)!=' ') {
//				char_str[index_new--]=str.charAt(index_old);
//			}else {//如果是空格 
//				char_str[index_new--]='0';
//				char_str[index_new--]='2';
//				char_str[index_new--]='%';
//			}
//			index_old--;
//		}
//		return String.valueOf(char_str);//将字符数组转为String类型后返回 
	}
	public static void main(String[] args) {
		StringBuffer stringBuffer=new StringBuffer("We Are Happy");
		System.out.println(replaceSpace3(stringBuffer));

	}

}
