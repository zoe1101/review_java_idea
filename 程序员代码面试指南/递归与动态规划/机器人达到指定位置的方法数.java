package 递归与动态规划;

public class 机器人达到指定位置的方法数 {
	/**
	 * 暴力递归
	 * @param N:N个位置
	 * @param M: 机器人当前所在的位置
	 * @param rest:还剩rest步要走
	 * @param P:机器人需要达到的目标位置
	 * @return
	 */
	public static int walk(int N,int cur,int rest,int P) {
		if(rest==0) { //没有剩余步数了，当前位置cur就是最后的位置
			return cur==P?1:0;//如果最后位置在P上，则说明之前的移动是有效的
		}
		if(cur==1) {//当前在1位置，只能往2上走
			return walk(N, 2, rest-1, P);
		}
		if (cur==N) {//当前在N位置，只能往N-1上走
			return walk(N, N-1, rest-1, P);
		}
		//在中间位置
		return walk(N, cur+1, rest-1, P)+walk(N, cur-1, rest-1, P);
	}
	/**
	 * 
	 * @param N:N个位置
	 * @param M: 机器人所在的起始位置
	 * @param K:需要走K步
	 * @param P:机器人需要达到的目标位置
	 * @return
	 */
	public static int solution1(int N,int M,int K,int P) {
		if(N<2 || K<1 || M<1 || M>N || P<1  || P>N) {
			return 0;
		}
		
		return walk(N, M, K, P);
	}
	/**
	 * 动态规划
	 * @param N
	 * @param M
	 * @param K
	 * @param P
	 * @return
	 */
	public static int solution2(int N,int M,int K,int P) {
		if(N<2 || K<1 || M<1 || M>N || P<1  || P>N) {
			return 0;
		}
		int[][] dp=new int[K+1][N+1];
		dp[0][P]=1;
		for(int i=1;i<=K;i++) {
			for(int j=1;j<=N;j++) {
				if(j==1) {
					dp[i][j]=dp[i-1][2];
				}else if(j==N) {
					dp[i][j]=dp[i-1][N-1];
				}else {
					dp[i][j]=dp[i-1][j-1]+dp[i-1][j+1];
				}
			}
		}
		return dp[K][M];
	}
	/**
	 * 动态规划+空间压缩
	 * @param N
	 * @param M
	 * @param K
	 * @param P
	 * @return
	 */
	public static int solution3(int N,int M,int K,int P) {
		if(N<2 || K<1 || M<1 || M>N || P<1  || P>N) {
			return 0;
		}
		int[] dp=new int[N+1];
		dp[P]=1;
		for(int i=1;i<=K;i++) {
			int leftUP=dp[1]; //左上角的值
			for(int j=1;j<=N;j++) {
				int temp=dp[j];
				if(j==1) {
					dp[j]=dp[j+1];
				}else if(j==N) {
					dp[j]=leftUP;
				}else {
					dp[j]=leftUP+dp[j+1];
				}
				leftUP=temp;
			}
		}
		return dp[M];
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
