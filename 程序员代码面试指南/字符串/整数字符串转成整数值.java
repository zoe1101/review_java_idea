package 字符串;


public class 整数字符串转成整数值 {
	/**
	 * 先将字符串转换为负数形式，然后判断正负形式
	 * 这样做是因为负数的表示范围比正数多一个，可以保证数据不溢出
	 * @param string
	 * @return
	 */
	public static int convert(String string) {
		if(string==null || string.length()==0) {
			return 0;
		}
		char[] chars=string.toCharArray();
		if(!isVaild(chars)) {
			return 0;
		}
		boolean posi=chars[0]=='-'? false:true; //正负号标记
		int minq=Integer.MIN_VALUE/10;
		int minr=Integer.MIN_VALUE%10;
		int res=0;
		int cur=0;
		for(int i=posi?0:1;i<chars.length;i++) {
			cur='0'-chars[i]; //当前数字字符的负数表现形式
			if(res<minq || (res==minq && cur<minr)) {
				return 0;
			}
			res=res*10+cur;
		}
		if(posi && res==Integer.MIN_VALUE) {
			return 0;
		}
		return posi?-res: res;
	}
	
/**
 * 检查字符串是否为书写正确的整数
 * @param chars
 * @return
 */
	public static boolean isVaild(char[]  chars) {

		if(chars[0]!='-' && (chars[0]<'0'|| chars[0]>'9')) {
			return false;
		}
		if(chars[0]=='-' && (chars.length==1 || chars[1]=='0')) {
			return false;
		}
		if(chars[0]=='0' && chars.length>1) {
			return false;
		}
		for(int i=1;i<chars.length;i++) {
			if(chars[i]<'0' || chars[i]>'9') {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		String test1 = "2147483647"; // max in java
		System.out.println(convert(test1));

		String test2 = "-2147483648"; // min in java
		System.out.println(convert(test2));

		String test3 = "2147483648"; // overflow
		System.out.println(convert(test3));

		String test4 = "-2147483649"; // overflow
		System.out.println(convert(test4));

		String test5 = "-123";
		System.out.println(convert(test5));

	}
}
