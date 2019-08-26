package 二分查找;
/*
实现 pow(x, n) ，即计算 x 的 n 次幂函数。

输入: 2.00000, 10
输出: 1024.00000
 */
//解题思想: 折半计算
public class x的n次方 {
	
//迭代计算
//	让i初始化为n，然后看i是否是2的倍数，是的话x乘以自己，否则res乘以x，i每次循环缩小一半，直到为0停止循环。
//	最后看n的正负，如果为负，返回其倒数
    public static double myPow(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) res *= x;
            x *= x;
        }
        return n < 0 ? 1 / res : res;
    }
//    递归折半计算
    public static double myPow2(double x, int n) {
    	if(n==0) return 1;
    	double half=myPow2(x, n/2);
    	if(n%2==0)  return half*half;
    	if(n>0)	return half*half*x;
    	return half*half/x;
    }
	public static void main(String[] args) {
	    double x=2.0;
	    int n=10;
	    System.out.println(myPow2(x,n));
	}

}
