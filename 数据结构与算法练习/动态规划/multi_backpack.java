package 动态规划;
import java.util.Scanner;
//多重背包
/*
有N种物品和一个容量为V的背包。
第i种物品最多有n[i]件物品可用，每件的耗费是w[i]，价值是v[i]，
求解将哪些物品装入背包可使得耗费和不超过背包总容量且总价值最大。
*/

public class multi_backpack {

	public static void main(String[] args) {
		Scanner inScanner=new Scanner(System.in);
		int N=inScanner.nextInt();
		int[] n=new int[N];
		int[] w=new int[N];
		int[] v=new int[N];
		for (int i=0;i<N;i++) { //输入物品的个数
			n[i] = inScanner.nextInt();
		}
		for (int i=0;i<N;i++) { //输入物品的重量
			w[i] = inScanner.nextInt();
		}
		for (int i=0;i<N;i++) {  //输入物品的价值
			v[i] = inScanner.nextInt();
		}
		int C=inScanner.nextInt();

		findMax(n, w, v, C);
		findMax1(n, w, v, C);
	}

	//	转换成01背包（三重循环）
//	多重背包最朴素的思想就是将所有的物品(不管同不同一类)都看不同的种类，进行01背包的求解。
//	另也可以看做完全背包的变形：第 i 种物品可以取0件、取1件……取n[i]件。
	public static int[] findMax(int[] n,int[] w,int[] v,int C) {
		int[] dp=new int[C+1];
		for(int i=0;i<n.length;i++) {//遍历每一个物品
			for(int j=0;j<n[i];j++) {//遍历物品的数量
				for(int k=C;k>=w[j];k--) {//当做01背包来处理
					//取01背包情况的dp[k]和dp[k-w[i]]+v[i]的最大值
					dp[k]=Math.max(dp[k], dp[k-w[j]]+v[j]);
				}

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


	//	二进制优化法
	public static int[] findMax1(int[] n,int[] w,int[] v,int C) {
		int[] dp=new int[C+1];
		for(int i=0;i<n.length;i++) { //遍历每一个物品
			if(w[i]*n[i]>=C) {
				//如果同一类物品的总重量大于背包的最大容量,则转换成完全背包
				CompleteBag(w[i],v[i],dp,C);
			}
			else { //多个01背包
				int curnum=n[i];
				for(int k=1;k<=curnum;) { //二进制优化
					bag01(w[i]*k,v[i]*k,dp,C);
					curnum-=k;
					k*=2;
				}
				bag01(w[i]*(n[i]-curnum+1),v[i]*(n[i]-curnum+1),dp,C);
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

	public static void bag01(int heft,int worth,int[] dp,int C)  //01背包
	{   //heft为当前物品的重量,worth为当前物品的价值
		for(int i=C;i>=heft;i--)
		{
			if(dp[i]>dp[i-heft]+worth)
				dp[i]=dp[i];
			else dp[i]=dp[i-heft]+worth;
		}
	}
	public static void CompleteBag(int heft,int worth,int[] dp,int C)  //完全背包
	{   //heft为当前物品的重量,worth为当前物品的价值
		for(int i=heft;i<=C;i++)
		{
			if(dp[i]>dp[i-heft]+worth)
				dp[i]=dp[i];
			else dp[i]=dp[i-heft]+worth;
		}
	}

}