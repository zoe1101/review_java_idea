package 递归与动态规划;

public class 换钱的最少货币数 {
	// 暴力递归
	public static int minCoins1(int[] arr,int aim) {
		if(arr==null || arr.length==0 ||aim<0) {
			return -1;
		}
		return process(arr, 0, aim);
	}
	// 暴力法
	/**
	 * 
	 * @param arr
	 * @param i :当前考虑的面值arr[i]的钱
	 * @param rest :剩余需要找零的钱
	 * @return  返回-1表示找不开，返回的不是-1时，返回的是找回的钱币张数
	 */
	public static int process(int[] arr,int i,int rest) {
		//已经没有面值可以考虑了
		if(i==arr.length) {
			return rest==0?0:-1;
		}
		//最少张数，初始为-1，代表无效解
		int res=-1;
		for(int k=0;k*arr[i]<rest;k++) {
			int next=process(arr, i+1, rest-k*arr[i]);
			if(next!=-1) {
				res=res==-1?next+k:Math.min(res, next+k);
			}
		}
		return res;
	}
	/**
	 * 动态规划法
	 * @param arr
	 * @param aim
	 * @return
	 */
	public static int minCoins2(int[] arr,int aim) {
		if(arr==null || arr.length==0 ||aim<0) {
			return -1;
		}
		int n=arr.length;
		int[][] dp=new int[n+1][aim+1];
		for(int i=1;i<=aim;i++) {
			dp[n][i]=-1;
		}
		for(int i=n-1;i>=0;i--) { //从下往上计算每一行
			for(int rest=0;rest<=aim;rest++) { //每一行从左到右
				dp[i][rest]=-1; //初始时先设置dp[i][rest]的值无效
				if(dp[i+1][rest]!=-1) { //下面dp[i+1][rest]值有效时
					dp[i][rest]=dp[i+1][rest];//先设置成下面的值dp[i+1][rest]
				}
				//左边的位置不越界其有效
				if(rest-arr[i]>=0 && dp[i][rest-arr[i]]!=-1) {
					if(dp[i][rest]==-1) {//之前的下面的值dp[i+1][rest]是无效的，导致dp[i][rest]值未被改变
						dp[i][rest]=dp[i][rest-arr[i]]+1; //设为左边的值
					}else { //左边的值和下面的值都有效时，需要从中选一个最小的
						dp[i][rest]=Math.min(dp[i][rest], dp[i][rest-arr[i]]+1);
					}
				}
			}
		}
		return dp[0][aim];
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
