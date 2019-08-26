package 动态规划;

public class 买卖股票的最佳时机含手续费 {
    public int maxProfit(int[] prices, int fee) {
    	int buy = Integer.MIN_VALUE;//表示当天买入股票的最大收益
        int sell = 0; //表示当天卖出股票的最大收益
        for (int price:prices) {
			buy=Math.max(buy, sell-price-fee); //今天买了的收益或之前买的收益 之间的最大值
			sell=Math.max(sell, buy+price);//今天卖的收益或之前卖的收益之间的最大值
		}
        return sell;
    }
}
