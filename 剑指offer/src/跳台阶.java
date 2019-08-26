package src;
/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级。
求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */

//假设第一次跳的是一阶，那么剩下的n-1个台阶，跳法是f(n-1)
//假设第一次跳的是两阶，那么剩下的n-2个台阶，跳法是f(n-2)
//由上面两种假设可得：f(n) = f(n-1) + f(n-2)
//由实际情况可知：f(1) = 1，f(2) = 2
//递归问题:  斐波那契数列
/*
f(n)   =     1，                                        n = 1
f(n)   =     2,                n = 2
f(n)   =     f(n-1) + f(n -2), n >2
*/
public class 跳台阶 {
	//递归的方法, 运行时间过长
    public static int JumpFloor(int target) {
    	if(target<=0) return 0;
    	else if(target<=2) return target;
    	else return JumpFloor(target-1)+JumpFloor(target-2);

    }
    
	//动态规划的方法, 提高效率。
    public static int JumpFloor2(int target) {
        if(target<=0) return 0;
        else if(target<=2)  return target;
    	int[] result=new int[target];
    	result[0]=1;
    	result[1]=2;
    	for(int i=2;i<target;i++) {
    		result[i]=result[i-1]+result[i-2];
    	}
    	return result[target-1];
    }
    	
	public static void main(String[] args) {
	    int target=3;
	    System.out.println(JumpFloor2(target));

	}
}
