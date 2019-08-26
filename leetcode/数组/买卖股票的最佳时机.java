package 数组;
/*
 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
注意你不能在买入股票前卖出股票。

输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 */
public class 买卖股票的最佳时机 {
	public static int maxProfit(int[] prices) {
		int minprice=Integer.MAX_VALUE; // int 类整数的最大值是 2 的 31 次方 - 1 = 2147483648 - 1 = 2147483647
        int maxprofit=0;
        for(int i=0;i<prices.length;i++) {
        	if(prices[i]<minprice) {//该天的价格低于最低价格
        		minprice=prices[i];
        	}else if(prices[i]-minprice>maxprofit) {//当前收益大于之前的最大收益
        		maxprofit=prices[i]-minprice;
        	}
        }
        return maxprofit;
    }
	public static void main(String[] args) {
		int[] prices= {7,1,5,3,6,4};
		System.out.println(maxProfit(prices));

	}

}
