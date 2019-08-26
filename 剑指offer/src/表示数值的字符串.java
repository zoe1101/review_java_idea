package src;
/*
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 *  但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class 表示数值的字符串 {
    //《剑指OFFER》一书的方法：将数字的形式总结为：A[.[B]][e|EC] 或 .B[e|EC] ,
//其中A、C都是整数（可以有正负号，也就可以没有），B是无符号整数（无正负号）。
    private static int index;// 用于记录当前字符位置

    public static boolean isNumeric(char[] str) {
        if (str==null || str.length==0) {
			return false;
		}
       //先判断A
        boolean isNumeric=isInteger(str); //用于记录是否满足数字条件

       // 判断B
        if (index < str.length && (str[index] == '.')) { //如果出现‘.’，则接下来是数字的小数部分
            index++;
            //小数部分可以没有正数部分，如.123等于0.123
            //小数点部分可以没有数字，如233.等于233.0
            //小数点前面和后面可以都有数字，如233.56
            isNumeric = isUnsignedInteger(str) || isNumeric; // .B和A.和A.B形式均可以
        }
        // 如果出现e或E，则接下来是数字的指数部分，即C部分
        if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
            index++;
            //存在两种情况：
            //当e或E前面没有数字时，整个字符串部分表示数字，如.e1, e1;
            //当e或E后面没有整数时，整个字符串部分表示数字，如12e, 12e+5.4;
            isNumeric = isInteger(str) && isNumeric; //保证e前面有数字且后面有整数
        }
        return isNumeric && index == str.length; //有数字且到达数字字符串结尾，为true
    }
    
//标记法：
/*设置三个标志符分别记录“+/-”、“e/E”和“.”是否出现过。
** 对于“+/-”： 正常来看它们第一次出现的话应该出现在字符串的第一个位置，
	如果它第一次出现在不是字符串首位，而且它的前面也不是“e/E”，那就不符合规则；
	如果是第二次出现，那么它就应该出现在“e/E”的后面，如果“+/-”的前面不是“e/E”，那也不符合规则。
** 对于“e/E”： 如果它的后面不接任何数字，就不符合规则；如果出现多个“e/E”也不符合规则。
** 对于“.”： 出现多个“.”是不符合规则的。还有“e/E”的字符串出现“.”也是不符合规则的。
同时，要保证其他字符均为 0-9 之间的数字。
 */
    public static boolean isNumeric2(char[] str) {
    	int len = str.length;
    	boolean sign = false; //正负号出现次数标记
    	boolean decimal = false;  //“.”出现次数标记
    	boolean hasE = false;  //e/E出现次数标记
    	for (int i = 0; i < len; i++) {
			if (str[i]=='+' ||str[i]=='-') {
				if(!sign && i>0 && str[i-1]!='e' && str[i-1]!='E') {//第一次出现正负号
					return false;
				}
				if(sign && str[i-1]!='e' && str[i-1]!='E') { //第二次出现正负号
					return false;
				}
				sign=true;
			}else if (str[i] == 'e' || str[i] == 'E') {
				if(i==len-1) {
					return false;
				}
				if (hasE) {//前面已经出现过E了
					return false;
				}
				hasE=true;
			}else if (str[i]=='.') {
				if(hasE || decimal) { //e出现了或者已经有过“.”了
					return false;
				}
				decimal=true;
			}else if (str[i]<'0' || str[i]>'9') {
				return false;
			}
		}
    	return true;
    }

    //有符号整数判断，用来匹配A和C部分
    private static boolean isInteger(char[] str) {
        //index:当前字符的位置
        //首字符的判断，如果是带符号的数，就需要对当前字符位置后移，再判断后续是否是0-9的无符号数
        if (index < str.length && (str[index] == '+' || str[index] == '-'))
            index++;
        return isUnsignedInteger(str);
    }
    //无符号整数判断，用来匹配B部分
    private static boolean isUnsignedInteger(char[] str) {
        int start = index;
        while (index < str.length && (str[index] - '0' <= 9 && str[index] - '0' >= 0))
            index++;
        return index>start; //只存在0-9的无符号数时，返回true，否则返回false
    }

    public static void main(String[] args) {
        String str="1.3e13";
        System.out.println(isNumeric(str.toCharArray()));
    }
}
