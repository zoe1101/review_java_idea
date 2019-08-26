package Math;
/*
累加数是一个字符串，组成它的数字可以形成累加序列。
一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。

示例 1:
输入: "112358"
输出: true 
解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8

示例 2:
输入: "199100199"
输出: true 
解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199

 */
public class 累加数 {
    public static boolean isAdditiveNumber(String num) {
    	int len=num.length();
        if (len<3) {
			return false;
		}
        //处理前两个字符都为0的特殊情况
        if(num.charAt(0) == '0' && num.charAt(1) == '0'){
            for(int i = 2;i < num.length();i++){
                if(num.charAt(i) != '0') return false;
            }
            return true;
        }
//要先确定好前两个数
/*
 * 前两个数的位数取值区间是[1,len/2],且len1+len2<len,确保字符串中有能有三个数
 * 选择一个len1,len2组合，剩余字符串为str3 = num.substr(len1+len2,size)。深度搜索DFS(str1,str2,str3)。
 */
        String str1,str2,str3;
        for (int len1 = 1; len1 <= len/2; len1++) {
        	str1 = num.substring(0, len1);
        	for (int len2 = 1; len2 <= len/2; len2++) {
        		System.out.println("==================");
        		str2 = num.substring(len1, len1+len2);
    		    str3 = num.substring(len1+len2, len);
        		if (DFS(str1, str2, str3)) {
        			return true;
        		}
        	}
		}
        return false;
    }

	private static boolean DFS(String str1, String str2, String last) {
	    if (str1.charAt(0) =='0'&& !str1.equals("0") || str2.charAt(0) =='0'&& !str2.equals("0")) {
	    	return false;
	    }
	    String addstr = add(str1, str2); //字符串相加
	    int addlen=addstr.length();
	    if (addlen>last.length()) { //超出边界了
	    	return false;
		}
	    if (addstr.equals(last)) { //结束标记
			return true;
		}
	    if (!addstr.equals(last.substring(0,addlen))) { //加和与后面字符串对不上
			return false;
		}
	    
	    str1=str2;
	    str2=addstr;
	    last=last.substring(addlen,last.length());
	    return DFS(str1, str2, last);
	}

	private static String add(String str1, String str2) {
		if (str1.length()<str2.length()) {
		  String temp=str1;
		  str1=str2;
		  str2=temp;
		}
		
		int index1=str1.length()-1;
		int index2=str2.length()-1;
		int carry=0;
		StringBuffer sb=new StringBuffer();
		for (; index1>=0; index1--,index2--) {
			if (index2>=0) {
				int sum=(str1.charAt(index1)-'0')+(str2.charAt(index2)-'0')+carry;
				sb.append(sum%10);
				carry=sum/10;
			}else {
				int sum=(str1.charAt(index1)-'0')+carry;
				sb.append(sum%10);
				carry=sum/10;
			}
		}
		if (carry==1) {
			sb.append(1);
		}
		return sb.reverse().toString();
	}
	public static void main(String[] args) {
		String string="112358";
		System.out.println(isAdditiveNumber(string));
	}
}
