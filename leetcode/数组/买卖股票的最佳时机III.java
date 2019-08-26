package 数组;
/*
给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

输入: [3,3,5,0,0,3,1,4]
输出: 6
解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 */
//解题思路:动态规划
public class 买卖股票的最佳时机III {
	public static int maxProfit(int[] prices) {
		if(prices==null ||prices.length==0) {
			return 0;
		}
	    int[] local=new int[3];
	    int[] global=new int[3];
	    for(int i=1;i<prices.length;i++) {
	    	int temp=prices[i]-prices[i-1];
	    	for(int j=2;j>=1;--j) {
	    		local[j]=Math.max(global[j-1]+Math.max(temp, 0), local[j]+temp);
	    		global[j]=Math.max(local[j], global[j]);
	    	}
	    }
	    return global[2];
	   }
	public static void main(String[] args) {
		int[] prices= {3,3,5,0,0,3,1,4};
		System.out.println(maxProfit(prices));

	}

}
