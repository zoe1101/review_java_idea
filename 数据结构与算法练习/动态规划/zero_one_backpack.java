package 动态规划;

//01背包问题,  价值最大化
//时间和空间复杂度均为O(N*V)
public class zero_one_backpack {

	public static void main(String[] args) {
	    int[] v= {0 , 2 , 5 , 3 , 10 , 4};  //物品价值
	    int[] w= {0 , 1 , 3 , 2 , 6 , 2}; //物体重量
	    int C = 12; //背包容量
	    int[][] dp=FindMax2(v,w,C);
	    FindMax1(v, w, C);
	    FindWhat(dp,w);
	}
	
	public static int[][] FindMax2(int[] v,int[] w,int C) {
		int[][] dp =new int[w.length+1][C+1] ;
		//填表
		for(int i=1;i<=w.length;i++) {
	    	for(int j=1;j<=C;j++) {
	    		if(j<w[i-1])   //背包容量不足以放下第 i 件物品，只能选择不拿
	    			dp[i][j]=dp[i-1][j];
				else {//背包容量可以放下第 i 件物品，要考虑拿这件物品是否能获取更大的价值。
					dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-w[i-1]]+v[i-1]);
				}		
	    	}
		}
		System.out.println("输出dp数组");
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("最大价值为："+dp[dp.length-1][dp[0].length-1]);
    	return dp;
	}
	
	public static int[] FindMax1(int[] v,int[] w,int C) {
		int[] dp =new int[C+1] ;
		//填表
		for(int i=1;i<=w.length;i++) {
	    	for(int j=C;j>=w[i-1];--j) {
	    		dp[j]=Math.max(dp[j], dp[j-w[i-1]]+v[i-1]);
				}		
		}
		System.out.println("输出dp数组");
		for(int i=0;i<dp.length;i++) {	
			System.out.print(dp[i]+" ");
			}
		System.out.println();
		System.out.println("最大价值为："+dp[dp.length-1]);
    	return dp;
	}
	////最优解情况
	public static void FindWhat(int[][] dp,int[] w) {  
		int n=dp.length;  //行数，n件物品
		int c=dp[0].length-1;  //列数，容量
		int[] x=new int[n];
	
	    for(int i=n-1;i>1;i--)
	    {
	        if(dp[i][c]==dp[i-1][c]) //第i件物品未取
	            x[i]=0;
	        else
	        {
	            x[i]=1;
	            c-=w[i-1];
	        }
	    }
	    x[1]=(dp[1][c]>0)?1:0;
	    
	    System.out.println("最优解");
	    for(int i=1;i<n;i++) {
	    	System.out.print(x[i]+" ");
	    }
	}
}
