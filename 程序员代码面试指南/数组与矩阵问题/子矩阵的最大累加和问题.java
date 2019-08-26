package 数组与矩阵问题;

//需要把矩阵转换为数组求解，在行上求和变成数组，然后利用子数组求解方式求最优列
public class 子矩阵的最大累加和问题 {
	public static int maxSum(int[][] m) {
		if (m==null || m.length==0 || m[0]==null || m[0].length==0) {
			return 0;
		}
		int max=Integer.MIN_VALUE;
		int cur=0;
		int[] s=null; //在行上求和变成数组，得到的累加数组
		for (int i = 0; i < m.length; i++) {
			s=new int[m[0].length]; //存储第i到j行的累加和
			for (int j = i; j < m.length; j++) { 
				cur=0;
				for (int k = 0; k < s.length; k++) {
					s[k]+=m[j][k];
					cur+=s[k];
					max=Math.max(max, cur);
					cur=cur<0?0:cur;
				}
			}
		}
		return max;
	}

}
