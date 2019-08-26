package Math;
/*
给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10^n 。

示例:

输入: 2
输出: 91 
解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。

 */
public class 计算各个位数不同的数字个数 {
	//排列组合问题
	/*
	 n=3: res=9 * 9 * 8+91=739 # 三位数第一位只能为1-9（9种选择），第二位只能为非第一位的数（9种），
	 第三位只能为非前两位的数（8种选择），加上两位数的所有结果
	 */
    public int countNumbersWithUniqueDigits(int n) {
    	 if(n==0) {
    		 return 1;
    	 }
         int ans=1;
         for(int i=0;i<n-1;++i) { //n位数的选择个数
        	 ans*=(9-i);
         }
         return 9*ans+countNumbersWithUniqueDigits(n-1); //n位数的个数+（n-1）位数的个数
    }
}
