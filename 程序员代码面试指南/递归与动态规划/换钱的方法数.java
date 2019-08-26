package 递归与动态规划;

public class 换钱的方法数 {
	/**
	 * 暴力递归
	 * @param arr
	 * @param aim
	 * @return
	 */
	public static int coins1(int[] arr,int aim) {
		if(arr==null || arr.length==0 || aim<0) {
			return 0;
		}
		return process1(arr, 0, aim);
	}
	public static int  process1(int[] arr ,int index,int aim) {
		int res=0;
		if(index==arr.length) {
			res=aim==0?1:0;
		}else {
			for(int i=0;i*arr[index]<=aim;i++) {
				res+=process1(arr, index+1, aim-i*arr[index]);
			}
		}
		return res;
	}
/**
 * 记忆化搜索法
 * @param arr
 * @param aim
 * @return
 */
	public static int coins2(int[] arr,int aim) {
		if(arr==null || arr.length==0 || aim<0) {
			return 0;
		}
		int[][] map=new int[arr.length+1][aim+1];
		return process2(arr, 0, aim, map);
	}
	
	public static int  process2(int[] arr ,int index,int aim,int[][] map) {
		int res=0;
		if(index==arr.length) {
			res= aim==0? 1:0;
		}else {
			int mapValue=0;
			for(int i=0;i*arr[index]<aim;i++) {
				mapValue=map[index+1][aim-i*arr[index]];
				if(mapValue!=0) {
					res+=mapValue==-1?0:mapValue;
				}else {
					res+=process2(arr, index+1, aim-i*arr[index], map);
				}
			}
		}
		map[index][aim]=res==0?-1:res;
		return res;
	}
	/**
	 * 动态规划法,时间复杂度为O(N*aim^2)
	 * @param arr
	 * @param aim
	 * @return
	 */
	public static int coins3(int[] arr,int aim) {
		if(arr==null || arr.length==0 || aim<0) {
			return 0;
		}
		int[][] dp=new int[arr.length][aim+1];
		for(int i=0;i<arr.length;i++) {
			dp[i][0]=1;
		}
		for(int j=1;j*arr[0]<=aim;j++) {
			dp[0][j*arr[0]]=1;
		}
		int num=0;
		for(int i=1;i<arr.length;i++) {
			for(int j=1;j<=aim;j++) {
				num=0;
				for(int k=0;j-k*arr[i]>=0;k++) {
					num+=dp[i-1][j-k*arr[i]];
				}
				dp[i][j]=num;
			}
		}
		return dp[arr.length-1][aim];
	}
	/**
	 * 动态规划法，时间复杂度为O(N*aim)
	 * @param arr
	 * @param aim
	 * @return
	 */
	public static int coins4(int[] arr,int aim) {
		if(arr==null || arr.length==0 || aim<0) {
			return 0;
		}
		int[][] dp=new int[arr.length][aim+1];
		for(int i=0;i<arr.length;i++) {
			dp[i][0]=1;
		}
		for(int j=1;j*arr[0]<=aim;j++) {
			dp[0][j*arr[0]]=1;
		}
		for(int i=1;i<arr.length;i++) {
			for(int j=1;j<=aim;j++) {
				dp[i][j]=dp[i-1][j];
				dp[i][j]+=j-arr[i]>=0?dp[i][j-arr[i]]:0;
			}
		}
		return dp[arr.length-1][aim];
	}
	
	/**
	 * 动态规划法+空间压缩，时间复杂度为O(N*aim)
	 * @param arr
	 * @param aim
	 * @return
	 */
	public static int coins5(int[] arr,int aim) {
		if(arr==null || arr.length==0 || aim<0) {
			return 0;
		}
		int[] dp=new int[aim+1];
		for(int j=0;j*arr[0]<=aim;j++) {
			dp[j*arr[0]]=1;
		}
		for(int i=1;i<arr.length;i++) {
			for(int j=1;j<=aim;j++) {
				dp[j]+=j-arr[i]>=0?dp[j-arr[i]]:0;
			}
		}
		return dp[aim];
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
