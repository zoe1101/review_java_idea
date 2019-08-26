package 递归与动态规划;

public class 最小编辑代价 {
	/**
	 * 
	 * @param str1：字符串1
	 * @param str2：字符串2
	 * @param ic：一个字符的插入代价
	 * @param dc：一个字符的删除代价
	 * @param rc：一个字符的替换代价
	 * @return
	 */
	public static int minCost1(String str1,String str2,int ic,int dc,int rc) {
		if (str1==null || str2==null) {
			return 0;
		}
		char[] chs1=str1.toCharArray();
		char[] chs2=str2.toCharArray();
		//目标：str1变成str2
		//d[i][j]为将str1的1~i位和str2的1~j位变为相同时的操作代价
		int[][] dp=new int[chs1.length+1][chs2.length+1];
		
		for (int i = 1; i < chs1.length+1; i++) { //str1变成空字符串，删除str1中所有元素
			dp[i][0]=dc*i;
		}
		
		for (int i = 1; i < chs2.length+1; i++) {//空字符串变成str1，将str1中所有元素进行插入
			dp[0][i]=ic*i;
		}
		for (int i = 1; i < chs1.length+1; i++) {
			for (int j = 1; j <chs2.length+1; j++) {
				 //dp[i][j]对应的是str1[i-1]与str2[j-1]
				if (chs1[i-1]==chs2[j-1]) { //str1[i-1]与str2[j-1]相等
					dp[i][j]=dp[i-1][j-1];
				}else {//str1[i-1]与str2[j-1]不相等，就进行替换
					dp[i][j]=dp[i-1][j-1]+rc;
				}
				//从不操作，插入，删除，替换中选一个最小的
				dp[i][j]=Math.min(dp[i][j], dp[i][j-1]+ic);
				dp[i][j]=Math.min(dp[i][j], dp[i-1][j]+dc);
			}
		}
		return dp[chs1.length][chs2.length];
	}
	
	//优化动态规划，减少空间复杂度
	public static int minCost2(String str1,String str2,int ic,int dc,int rc) {
		if (str1==null || str2==null) {
			return 0;
		}
		char[] chs1=str1.toCharArray();
		char[] chs2=str2.toCharArray();
		//目标是由长变短
		char[] longs=chs1.length>=chs2.length?chs1:chs2; //str1与str2中的较长者
		char[] shorts=longs==chs1?chs2:chs1;//str1与str2中的较短者
		
		if (chs1.length<chs2.length) { //str1短于str2，将插入和删除的代价值交换
			int tmp=ic;
			ic=dc;
			dc=tmp;
		}
		// dp[j] = dp[i][j]:str1的1—i为变成str2的1:j位所需的代价
		int[] dp=new int[shorts.length+1]; 
		
		for (int i = 1; i < dp.length; i++) { //空字符串到str2[0:i]所需的代价，插入操作
			dp[i]=ic*i;
		}
		for (int i = 1; i < longs.length+1; i++) {
			int pre=dp[0]; //左上角的值
			dp[0]=dc*i; //str1[0:i]到空字符串所需的代价，删除操作
			for (int j = 1; j < shorts.length+1; j++) {
				int tmp=dp[j];
				if (longs[i-1]==shorts[j-1]) {
					dp[j]=pre;
				}else {
					dp[j]=pre+rc; //str1[i-1]替换
				}
				dp[j]=Math.min(dp[j], dp[j-1]+ic); //插入
				dp[j]=Math.min(dp[j], tmp+dc); //删除
				pre=tmp;
			}
		}
		return dp[shorts.length];
	}

}
