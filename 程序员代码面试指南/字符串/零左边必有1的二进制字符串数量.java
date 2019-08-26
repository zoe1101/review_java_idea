package 字符串;

public class 零左边必有1的二进制字符串数量 {
	public static int getNum1(int n) {
		if (n<1) {
			return 0;
		}
		return process(1,n); 
	}
//在0~i-1位置上的字符已经确定，符合要求且第i-1位置为‘1’时，后面的i~N-1位可以列举出多少种符合要求的字符串。
	public static int process(int i,int n) {
		if (i==n-1) { //第n-2位为1，则最后n-1位可以是1或0，两种
			return 2;
		}
		if (i==n) { //字符串遍历完了，后面没有可以组合的可能了，只有0~n-1这种方式
			return 1;
		}
		//i<n-1时，第i-1位为1，则第i位可能是1或0
		//第i位是1时，对应process(i+1, n)
		//第i位是0时，第i+1位必为1，对应process(i+2, n)
		return process(i+1, n)+process(i+2, n);
	}
	//方法2，直接公式计算
	//类似于斐波那契数列，第1项为1，第二项为2，其他项为f(n)=f(n-1)+f(n-2)
	public static int getNum2(int n) {
		if (n<1) {
			return 0;
		}
		if (n==1) {
			return 1;
		}
		int pre=1; //当前项的前两项
		int cur=1; //当前项，也是当前的前一项
		int tmp=0;
		for(int i=2;i<=n;i++) {
			tmp=cur;
			cur+=pre;
			pre=tmp;
		}
		return cur;
	}
	//方法2优化
	public static int getNum3(int n) {
		System.out.println("ff");
		return  0;
	}

}
