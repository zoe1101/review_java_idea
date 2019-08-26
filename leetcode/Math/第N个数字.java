package Math;

import java.math.BigInteger;

/*
在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。

注意:
n 是正数且在32为整形范围内 ( n < 2^31)。

示例 1:
输入:
3
输出:
3

示例 2:
输入:
11
输出:
0

说明:
第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。

 */
public class 第N个数字 {
//	根据题意，是求将自然数数列拼接起来的字符串第n个字符， 如1 2 3 4 5 6 7 8 9 10 的第11个字符是0
	//1234567891011121314151617181920
	//1 - [1,9]             9
	//2 - [10,99]          90
	//3 - [100,999]       900
	//4 - [1000,9999]    9000
	//.........2^31-1 = 2147483647
	
	/*
设， 自然数数列有x项，构成的字符串长度为y
当x=234时, 1-9是1位的， 10-99是2位的， 100-234是3位的
则y = 3 * (234-99) + 2 * 90 + 1 * 9
用a代表x的位数， 可以得到函数 
y = a*(x-10^(a-1)-1) + (a-1)*9*10^(a-2) + (a-2)*9*10^(a-3) + ... + 9
化简可得： y = a*x + a - 10^(a-1) - 10^(a-2) - ... - 10^0
由于函数y是递增的，可以用二分查找找到离y离n最近时的x的取值， 就可以求出第n位的数字
	 */
    public int findNthDigit(int n) {
        if (n<10) {//小于10，直接返回n
			return n;
		}
        int i;//记录结果所在数字的区间是几位数
        for(i=1;9*i*Math.pow(10,i-1)<n;i++){
            n-=9*i*Math.pow(10,i-1);
        }
        int index=n/i;//某个区间第index个数字
        if(index==0) index=1; //不会出现第0个数字，起码从第一个数字起
        int bit=n%i;//第index个数的第bit位，接下来找出这个位数
        int number=(int)Math.pow(10,i-1)+index-1; //number为一个具体的i位数
        if(bit==0)//说明在这个数字的最后一位
            return number%10;
        else return getIndexBit(number+1,bit,i);//bit不为0时，数字要再加1
    }
    
    private int getIndexBit(int number,int bit,int i){ //获取数字number的第bit位数
        int a=(int)(number/Math.pow(10,i-bit));
        return a%10;
    }
}
