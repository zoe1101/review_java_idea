package 递归与动态规划;
/*
骑士从左上角出发，每次只能向右或向下走，最后到达右下角见到公主。
地图中每个位置的值代表骑士要遭遇的事情。如果是负数，说明此处有怪兽，要让骑士损失血量。
如果是非负数，代表此处有血瓶，能让骑士回血。
骑士从左上角到右下角的过程中，走到任何一个位置时，血量都不能少于1.

为了保证骑士能见到公主，初始血量至少是多少？根据map，返回初始血量。
 */
//需要先求出最优路径，然后计算出初始血量dp[0][0]
public class 龙与地下城游戏问题 {
	public static int minHP1(int[][] map) {
		if (map==null || map.length==0 || map[0]==null || map[0].length==0) {
			return 1;
		}
		int row=map.length;
		int col=map[0].length;
		//dp[i][j]:到达（i,j）位置，且最终需要右下角最少需要的血量
		int[][] dp=new int[row][col];
		
		//dp[row-1][col-1]:要到达右下角最少需要的血量
		dp[row-1][col-1]=map[row-1][col-1]>0?1:-map[row-1][col-1]+1; 
		for (int j = col-2; j >=0; j--) { //最后一行，只有向右走的可能
			dp[row-1][j]=Math.max(dp[row-1][j+1]-map[row-1][j+1], 1);
		}
		
		int right=0;
		int dowm=0;
		//dp[i][j+1]:从（i，j）位置向右走
		//dp[i+1][j]:从（i，j）位置向下走
		for (int i = row-2; i>=0; i--) {
			dp[i][col-1]=Math.max(dp[i+1][col-1]-map[i][col-1], 1);
			for (int j = col-2; j>=0; j--) {
				right=Math.max(dp[i][j+1]-map[i][j], 1);
				dowm=Math.max(dp[i+1][j]-map[i][j], 1);
				dp[i][j]=Math.min(right, dowm); //从向右走和向下走中选一个最右的
			}
		}
		return dp[0][0];
	}
	//优化动态规划
	public static int minHP2(int[][] map) {
		if (map==null || map.length==0 || map[0]==null || map[0].length==0) {
			return 1;
		}
		int more=Math.max(map.length, map[0].length);
		int less=Math.min(map.length, map[0].length);
		boolean rowmore=more==map.length; //矩阵行是否比列多
		int[] dp=new int[less];
		int tmp=map[map.length-1][map[0].length-1];
		dp[less-1]=tmp>0?1:-tmp+1;
		int row=0;
		int col=0;
		for (int j = less-2; j >=0; j--) {
			//矩阵行是否比列多。是的话则行还是行，列还是列。否则行列互换了
			row=rowmore?more-1:j;
			col=rowmore?j:more-1;
			dp[j]=Math.max(dp[j+1]-map[row][col], 1);
		}
		int choosen1=0;
		int choosen2=0;
		for (int i = more-2; i>=0; i--) {
			row=rowmore?i:less-1;
			col=rowmore?less-1:i;
			dp[less-1]=Math.max(dp[less-1]-map[row][col], 1);
			for (int j= less-2; j >=0; j--) {
				row=rowmore?i:j;
				col=rowmore?j:i;
				choosen1=Math.max(dp[j]-map[row][col], 1);
				choosen1=Math.max(dp[j+1]-map[row][col], 1);
				dp[j]=Math.min(choosen1, choosen2);
			}
		}
		return dp[0];
	}

}
