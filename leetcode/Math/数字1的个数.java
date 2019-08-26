package Math;
/*
给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。

示例:
输入: 13
输出: 6 
解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。

 */
public class 数字1的个数 {
    public int countDigitOne(int n) {
    	if (n<1) {
			return 0;
		}
		int len=getNumLen(n); //n的位数
		if (len==1) {
			return 1;
		}
        int temp=powerBaseOf10(len-1);//n为123，temp为100
    /*
    将一个数字拆分为最高位和其右边 ，比如 3452，拆成 3 和 452， 最高位 high = 3, last = 452, 
    数的范围是几千的数字，那么 power = 1000 先看最高位贡献了多少个 1，
    如果最高位大于1、 那么最高位贡献1000个1，1000~1999 那么剩余位贡献多少个1呢，
    只要看0-999的个、十、百位贡献了多少个1， 那么 1000~1999，2000~2999，的个、十、百位贡献的1的
    个数都是一样的 即high * countDigitOne(power-1)个1 最后还剩下3000-3452这last+1个数字的
    个、十、百位贡献的1的数量，即countDigitOne(last)
     */
        int first=n/temp; //最高位的数
        //最高位能贡献多少个1
        //123能贡献24（123%100+1）个1（100-123）
        //223能够贡献100个1（100-199）
        int firstOneNum=first==1?n%temp+1:temp; 
        //除最高位以外的数可以贡献多少个1
        int otherOneNum=first*(len-1)*(temp/10);
        return firstOneNum+otherOneNum+countDigitOne(n%temp); //递归的过程
    }

	private int powerBaseOf10(int i) {
		return (int) Math.pow(10, i);
	}

	private int getNumLen(int n) {
		int len=0;
		while (n!=0) {
			len++;
			n=n/10;
		}
		return len;
	}
}
