package Math;
/*
实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100

 */
public class x的n次幂 {
	/*
	使用折半计算，每次把n缩小一半，这样n最终会缩小到0，任何数的0次方都为1，这时候我们再往回乘，
	 */
	public double myPow(double x, int n) {
		if (n==0) {
			return 1;
		}
		double half=myPow(x, n/2);
		if (n%2==0) { //n为偶数
			return half*half;
		}
		if(n>0)	{//n为奇数且为正数,half*half少乘了x
			return half*half*x;
		}
		return half*half/x;  //n为奇数且为负数，half*half少乘了x^(-1)
	}
}
