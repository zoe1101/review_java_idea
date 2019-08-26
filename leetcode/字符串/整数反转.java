package 字符串;
/*
 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:
输入: 123
输出: 321

注意:

假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。
根据这个假设，如果反转后的整数溢出，则返回 0。
 */


public class 整数反转 {
    public int reverse(int x) {
    	int absx=Math.abs(x); //x的绝对值
    	boolean isNeg=x<0?true:false; //x的正负号
    	String strx=String.valueOf(absx); //转化为字符串
    	StringBuffer reversex=new StringBuffer(); //缓存反转结果
    	for (int i= strx.length()-1;i>=0; i--) {
			reversex.append(strx.charAt(i));
		}
    	String maxValue = String.valueOf(Integer.MAX_VALUE); //32位可以存储的最大值
    	if (reversex.length()>maxValue.length()) { //溢出了
			return 0;
		}else if (reversex.length()==maxValue.length()) {
			return reversex.toString().compareTo(maxValue)>0?0:
				isNeg?-Integer.parseInt(reversex.toString()):
					  Integer.parseInt(reversex.toString());
		}else {
			return isNeg?-Integer.parseInt(reversex.toString()):
				         Integer.parseInt(reversex.toString());
		}
        
    }

}
