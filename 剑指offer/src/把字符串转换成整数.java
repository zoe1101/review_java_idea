package src;
/*
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 要求不能使用字符串转换整数的库函数。 
 * 数值为0或者字符串不是一个合法的数值则返回0。
 */
public class 把字符串转换成整数 {

    public int StrToInt(String str) {
        if(str==null || str.length()==0) {
        	return 0;
        }
        int symbol=1;
        int res=0;
        char[] chas=str.toCharArray();
        if(chas[0]=='+') {
        	symbol=1;
        	chas[0]='0';// 设置为0实际上是方便遍历
        }
        if(chas[0]=='-') {
        	symbol=-1;
        	chas[0]='0';
        }
        for(int i=0;i<chas.length;i++) {
        	//判断数字是不是合法的
        	if(chas[i]<'0' || chas[i]>'9') {
        		res=0;
        		break;
        	}
        	res=res*10+chas[i]-'0';// 转换核心,防止有进位
        }
        return res*symbol;  // 如果只有正负号也输出0
    }
}
