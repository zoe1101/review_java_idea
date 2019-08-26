package 字符串;

public class 字符串的统计字符串 {
	/**
	 * 将源字符串转换为统计字符串
	 * @param string
	 * @return
	 */
	public static String getCountString(String string) {
		if(string==null ||string.length()==0) {
			return "";
		}
		char[] chars=string.toCharArray();
		String res=String.valueOf(chars[0]);
		int num=1;
		for(int i=1;i<chars.length;i++) {
			if(chars[i]!=chars[i-1]) {
				res=res+"_"+num+"_"+chars[i];
				num=1;
			}else {
				num++;
			}
		}
		return res+"_"+num;
	}
	/**
	 * 从统计字符串中得知源字符串中第index字符是什么
	 * @param string
	 * @param index
	 * @return
	 */
	public static char getCharAt(String string, int index) {
		if(string==null ||string.length()==0) {
			return 0;
		}
		char[] chars=string.toCharArray();
		boolean stage=true; //true表示目前处在遇到字符的阶段，false表示目前处在遇到连续字符统计的阶段
		char cur=0;//在上一个遇到字符阶段时，遇到的是cur字符 。 0表示空字符
		int num=0;//在上一个遇到连续字符统计的阶段时，字符出现的数量
		int sum=0;//目前统计字符串的位置相当于源字符串的什么位置
		for(int i=0;i<chars.length;i++) {
			if(chars[i]=='_') { //转阶段了
				stage=!stage;
			}else if(stage) {
				sum+=num;
				if(sum>index) {
					return cur;
				}
				num=0;
				cur=chars[i];
			}else {
				num=num*10+chars[i]-'0';
			}
		}
		return sum+num>index?cur:0;
	}
	public static void main(String[] args) {
		String string="aaabbadddffc";
		System.out.println(getCountString(string));
		
	}


}
