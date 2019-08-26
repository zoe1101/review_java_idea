package Math;
/*
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321
 示例 2:

输入: -123
输出: -321
假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。
请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class 整数反转 {
	public int reverse(int x) {
		boolean isNeg=x<0?true:false;
		int absx=Math.abs(x);
		String strx=String.valueOf(absx);
		StringBuffer revBuffer=new StringBuffer();
		for (int i = strx.length()-1; i >=0; i--) {
			revBuffer.append(strx.charAt(i));
		}
		String maxValue=String.valueOf(Integer.MAX_VALUE);
		if (revBuffer.length()>maxValue.length()) { //溢出
			return 0;
		}else if (revBuffer.length()==maxValue.length()) {
			return revBuffer.toString().compareTo(maxValue)>0?0:
				isNeg?-Integer.parseInt(revBuffer.toString()):Integer.parseInt(revBuffer.toString());
		}else {
			return isNeg?-Integer.parseInt(revBuffer.toString()):Integer.parseInt(revBuffer.toString());
		}
	}
}
