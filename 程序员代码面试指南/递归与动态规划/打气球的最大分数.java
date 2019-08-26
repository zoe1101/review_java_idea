package 递归与动态规划;

public class 打气球的最大分数 {
	/**暴力递归
	 * 打爆arr[L..R]上的所有气球
	 * 假设arr[L-1]与arr[R+1]移动没有被打爆
	 * @param arr
	 * @param L
	 * @param R
	 * @return
	 */
	public static int process(int[] arr, int L,int R) {
		if(L==R) {//只有一个气球，直接打爆
			return arr[L-1]*arr[L]*arr[R+1];
		}
		//先取最后打爆arr[L]与最后打爆arr[R]得分的较大者
		int max=Math.max(
				arr[L-1]*arr[L]*arr[R+1]+process(arr, L+1, R), //最后打爆arr[L]
				arr[L-1]*arr[R]*arr[R+1]+process(arr, L, R-1));  //最后打爆arr[R]
		//然后比较最后打爆第i个气球与当前max值，取较大者为新的max
		for(int i=L+1;i<R;i++) {
			//最后打爆第i个气球，需要先全部打爆i左边与右边的气球
			max=Math.max(arr[L-1]*arr[i]*arr[R+1]+process(arr, L, i-1)+process(arr, i+1, R), max);
		}
		return max;
	}
	
	public static int maxScores1(int[] arr) {
		if(arr==null ||arr.length==0) {
			return 0;
		}
		if(arr.length==1) {
			return arr[0];
		}
		int N=arr.length;
		int[] help=new int[N+2]; //辅助数组,在arr的基础上做首尾补1
		help[0]=1;
		help[N+1]=1;
		for(int i=0;i<N;i++) {
			help[i+1]=arr[i];
		}
		return process(help, 1, N); //只需打爆有效的气球
	}
/**
 * 动态规划法
 * @param arr
 * @return
 */
	public static int maxScores2(int[] arr) {
		if(arr==null ||arr.length==0) {
			return 0;
		}
		if(arr.length==1) {
			return arr[0];
		}
		int N=arr.length;
		int[] help=new int[N+2]; //辅助数组,在arr的基础上做首尾补1
		help[0]=1;
		help[N+1]=1;
		for(int i=0;i<N;i++) {
			help[i+1]=arr[i];
		}
		int[][] dp=new int[N+2][N+2];
		for(int i=1;i<=N;i++) {
			dp[i][i]=help[i-1]*help[i]*help[i+1];
		}
		for(int L=N; L>=1;L--) {
			for(int R=L+1;R<=N;R++) {
				int finalL=help[L-1]*help[L]*help[R+1]+dp[L+1][R]; //最后打爆arr[L]的方法
				int finalR=help[L-1]*help[R]*help[R+1]+dp[L][R-1]; //最后打爆arr[R]的方法
				dp[L][R]=Math.max(finalL, finalR);
				for(int i=L+1;i<R;i++) {
					dp[L][R]=Math.max(dp[L][R], help[L-1]*help[i]*help[R+1]+dp[L][i-1]+dp[i+1][R]);
				}
			}
		}
		return dp[1][N];
	}
	public static void main(String[] args) {
		int[] arr= {3,2,5};
		
		System.out.println(maxScores1(arr));
		System.out.println(maxScores2(arr));

	}

}
