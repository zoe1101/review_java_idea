package 其他题目;

/*
对于数字n，计算它的第i(i从1开始，从右边开始计数)位数上包含的数字1的个数：
假设第i位上的数字为x的话，则
1.如果x > 1的话，则第i位数上包含的1的数目为：(高位数字 + 1）* 10 ^ (i-1) 
 	(其中高位数字是从i+1位一直到最高位数构成的数字)
2.如果x < 1的话，则第i位数上包含的1的数目为：(高位数字 ）* 10 ^ (i-1)
3.如果x == 1的话，则第i位数上包含1的数目为：(高位数字) * 10 ^ (i-1) +(低位数字+1)   
	(其中低位数字时从第i - 1位数一直到第1位数构成的数字)
 */
public class 一到n中1出现的次数 {
	public int oneNums(int n) {
		if (n<1) {
			return 0;
		}
		int len=getLenOfNum(n); //n的位数
		if (len==1) {
			return 1;
		}
		int tmp1=powerBaseOf10(len-1);
		int first=n/tmp1;  //表示当前的最高位值
		int firstOneNum=first==1?n%tmp1+1:tmp1;   //最高位上1出现是对应的数的个数
		int otherOneNum=first*(len-1)*(tmp1/10);
		return firstOneNum+otherOneNum+oneNums(n%tmp1);
		
	}

	private int powerBaseOf10(int base) {
		return (int) Math.pow(10, base);
	}

	private int getLenOfNum(int n) {
		int len=0;
		while (n!=0) {
			len++;
			n=n/10;
		}
		return len;
	}

}
