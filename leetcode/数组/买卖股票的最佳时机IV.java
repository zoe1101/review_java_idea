package 数组;
/*
给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。


输入: [3,2,6,5,0,3], k = 2
输出: 7
解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。

 */
public class 买卖股票的最佳时机IV {
	 public int maxProfit(int k, int[] prices) {
        if(prices==null||prices.length==0)return 0;
            //k大于数组长度的一半等同于无限次买入卖出
            if(k>=prices.length/2) return process(prices);
            int[][] dp=new int[k+1][2];//当前天依赖于前一天,因此不用添加前一天维度
            int res=0;
            for(int i=1;i<=k;i++){
                dp[i][0]=0;
                dp[i][1]=-prices[0];
            }
            for(int i=1;i<prices.length;i++){
                for(int j=1;j<=k;j++){
                    dp[j][0]=Math.max(dp[j][0],dp[j][1]+prices[i]);
                    dp[j][1]=Math.max(dp[j][1],dp[j-1][0]-prices[i]);
                    res=Math.max(Math.max(dp[j][0],dp[j][1]),res);
                }
            }
            return res;
        }

	    public int process(int[] prices){
	        int res=0;
	        for(int i=1;i<prices.length;i++){
	            if(prices[i]>prices[i-1]) { //只要价格比前一天高
	            	res+=prices[i]-prices[i-1];
	            }
	        }
	        return res;
	    }
}
