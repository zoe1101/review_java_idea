package 二分查找;
/*
 实现 int sqrt(int x) 函数。
计算并返回 x 的平方根，其中 x 是非负整数。
由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

输入: 4
输出: 2
 */
//相当于查找最后一个不大于目标值的数
public class x的平方根 {
    public static int mySqrt(int x) {
        if(x<=1) return x;
        int left=0,right=x;
        while(left<right) {
        	int mid=(left+right)/2;
        	if(x/mid>=mid) {
        		left=mid+1;
        	}else {
        		right=mid;
        	}
        }
        return right-1;
    }
	public static void main(String[] args) {
	    int x=8;
	    System.out.println(mySqrt(x));

	}
}
