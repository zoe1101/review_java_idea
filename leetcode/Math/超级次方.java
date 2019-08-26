package Math;
/*
你的任务是计算 a^b 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。

输入: a = 2, b = [1,0]
输出: 1024
 */
//采用按位来处理，比如2^23 = (2^2)^10 * 2^3, 
//所以我们可以从b的最高位开始，算出个结果存入res，然后到下一位是，res的十次方再乘以a的该位次方再对1337取余

//两个数的乘积求余等于：ab % k = (a%k)(b%k)%k
public class 超级次方 {
    public static int superPow(int a, int[] b) {
    	int res=1;
        for(int i=0;i<b.length;i++) {
        	res=powMod(res, 10)*powMod(a, b[i])%1337;
        }
        return res;
    }
    public static int powMod(int x, int n) { ////计算x^n %(k),且0<=n<=10
        if (n == 0) return 1;
        if (n == 1) return x % 1337;
        return powMod(x%1337, n/2) * powMod(x%1337, n-n/2)%1337;
    }
    
	public static void main(String[] args) {
		int a=2;
		int[] b= {1,0,0};
		System.out.println(superPow(a,b));

	}

}
