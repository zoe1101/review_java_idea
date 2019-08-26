package src;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * @author zoe
 *
 *根据题目的要求，两个数字m和n能拼成数字mn和nm。如果mn<nm，那么我们应该打印出mn，即m应该排在n的前面，我们此时定义m小于n；
 *反之，如果nm<mn，我们定义n小于m。如果mn=nm，我们定义m等于n。
 *（注：符号的<，>, =是常规意义的数值大小，而文字的“大于”，“小于”，“等于”表示新定义的大小关系）。
因存在大数问题，故我们把数字转化为字符串，另外把数字m和数字n拼接起来得到mn和nm，
它们的位数肯定是相同的，因此比较它们的大小只需要按照字符串大小的比较规则就可以了。

 */
public class 把数组排成最小的数 {
    public static String PrintMinNumber(int [] numbers) {
    	if(numbers==null || numbers.length==0) {
    		return "";
    	}
    	int len = numbers.length;
    	String[] strings=new String[len];
    	StringBuffer stringBuffer=new StringBuffer();
    	for(int i=0;i<len;i++) {
    		strings[i]=String.valueOf(numbers[i]);
    	}
    	//这里根据自己定义的排序规则,新的排序规则,如若取最大值，~c1.compareTo(c2)
    	Arrays.sort(strings,new Comparator<String>(){ 
    		public int compare(String str1,String str2) {
    			String c1=str1+str2;
    			String c2=str2+str1;
    			return c1.compareTo(c2);
    		}
    	
		});
    	for(int i = 0; i < len; i++){
    		stringBuffer.append(strings[i]);
    	}
    	return stringBuffer.toString();
    }
    public static void main(String[] args) {
		int a[] = {3, 32, 321};
		System.out.println(PrintMinNumber(a));
		
	}
}
