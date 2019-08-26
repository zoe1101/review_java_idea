package 动态规划;
/*
有 N 堆石头排成一排，第 i 堆中有 stones[i] 块石头。

每次移动（move）需要将连续的 K 堆石头合并为一堆，而这个移动的成本为这 K 堆石头的总数。

找出把所有石头合并成一堆的最低成本。如果不可能，返回 -1 。

 

示例 1：

输入：stones = [3,2,4,1], K = 2
输出：20
解释：
从 [3, 2, 4, 1] 开始。
合并 [3, 2]，成本为 5，剩下 [5, 4, 1]。
合并 [4, 1]，成本为 5，剩下 [5, 5]。
合并 [5, 5]，成本为 10，剩下 [10]。
总成本 20，这是可能的最小值。

1 <= stones.length <= 30
2 <= K <= 30
1 <= stones[i] <= 100
 */
public class 合并石头的最低成本 {
    public int mergeStones(int[] stones, int K) {
        int len=stones.length;
      //本来就是一堆的话,没有合并成本
        if (len==1) {
			return 0;
		}
      //无论用什么方式,石头每次减少K-1个,但最终要剩K个石头
        if (len<K || (len-K)%(K-1)!=0) {
			return -1;
		}
       //sum[i]表示stones[0]加至stones[i]的总和(PS:sum[0]设为0)
        //dp[i][j][K]表示将i到j区间的石头合并成k块需要的最小代价
        int[] sum=new int[32];
        int[][][] dp=new int[32][32][32];
        for(int i=1;i<=len;i++){
            sum[i] = sum[i-1]+stones[i-1];
            //每个石子自成一堆,没有合并成本
            dp[i][i][1] = 0;
        }
        int span,left,right,mid,heap;
        //问题由小递推至大,因此先两个两个石头考虑,再三个三个石头考虑,通过span控制left与right的间距,从而递增考虑石子的个数
        for(span=1;span<len;span++){
            for(left=1;left<=len-span;left++){
                right=left+span;
                //决定在哪将要考虑的石子分为两部分
                for(mid=left;mid<right;mid++){
                    //先考虑分为两堆,三堆,仍然是递增考虑,堆数不可能超过石子数
                    for(heap=2;heap<=span+1;heap++){
                        //将本次考虑的所有石子合并为heap堆的成本,就是左部分是heap-1堆而右部分1堆相加的成本,反复更新dp[left][right][heap]以获取最小值
                        dp[left][right][heap] = Math.min(dp[left][right][heap],dp[left][mid][heap-1]+dp[mid+1][right][1]);
                    }
                }
                //将本次考虑的所有石子合并为一堆的代价,就是将K堆石子合并起来的代价,反复更新dp[left][right][1]以获取最小值
                dp[left][right][1] = Math.min(dp[left][right][1],dp[left][right][K]+sum[right]-sum[left-1]);
            }
        }
        //将编号为1到len的石子合成一堆的成本即最终答案
        return dp[1][len][1];
        
    }
}
