package src;
/*
求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */

//
//递归
//利用逻辑与的短路特性实现递归终止
//当n==0时，(n>0)&&((sum+=Sum_Solution(n-1))>0)只执行前面的判断，为false，然后直接返回0
//当n>0时，执行sum+=Sum_Solution(n-1)，实现递归计算Sum_Solution(n)

// f(n)=n+f(n-1)
public class 求1到n的和 {
    public int Sum_Solution(int n) {
        int sum=n;
        boolean flag= (n>0) && (sum+=Sum_Solution(n-1))!=0;
        return sum;
    }
}
