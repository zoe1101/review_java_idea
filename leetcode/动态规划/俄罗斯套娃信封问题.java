package 动态规划;

import java.util.Arrays;
import java.util.Comparator;

/*
给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。
当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。

请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。

说明:
不允许旋转信封。

示例:

输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
输出: 3 
解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。

 */
public class 俄罗斯套娃信封问题 {
	//长排序+宽排序
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length==0) {
			return 0;
		}
        Arrays.sort(envelopes,new Comparator<int[]>() {
        	//按长度升序排序,若相等，则按宽度升序排序
        	public int compare(int[] a,int[] b) {
        		return a[0]==b[0]?a[1]-b[1]:a[0]-b[0];
        	}
		});
        int n=envelopes.length;
        int[] dp=new int[n];
        int res=0;
        for (int i = 0; i < n; i++) {
        	dp[i]=1;//只有一个信封
        	for (int j = 0; j < i; j++) {
				if (envelopes[j][0]<envelopes[i][0] && envelopes[j][1]<envelopes[i][1]) {
					dp[i]=Math.max(dp[i], dp[j]+1);
					//以envelopes[j]为次外层信封时最多的嵌套层数，加上envelopes[i]
				}
			}
        	res=Math.max(res, dp[i]);
		}
        return res;
    }
}
