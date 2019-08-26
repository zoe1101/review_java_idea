package 数组;
/*
如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。
第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。

例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。
相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，
第二个序列是因为它的最后一个差值为零。

给定一个整数序列，返回作为摆动序列的最长子序列的长度。 
通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。


输入: [1,7,4,9,2,5]
输出: 6 
解释: 整个序列均为摆动序列。

 */
public class 摆动序列 {
	
	public int wiggleMaxLength(int[] nums) {
		//动态规划 两个数组，每个存到目前为止的数目
		//用up[i]和down[i]分别记录到第i个元素为止，以上升沿和下降沿[结束]的最长“摆动”序列长度
		int n = nums.length;
		if(n<2) {
			return n;
		}
		
		int[] up=new int[n];
		int[] down=new int[n];
		up[0] = down[0] = 1;
		for(int i=1;i<n;i++){
		    if(nums[i] < nums[i-1]){ //下降沿
		        down[i] = up[i-1] + 1;
		        up[i] = up[i-1];
		    }else if(nums[i] > nums[i-1]){ //上升沿
		        up[i] = down[i-1] + 1;
		        down[i] = down[i-1];
		    }else{ //平面，保持
		        up[i] = up[i-1];
		        down[i] = down[i-1];
		    }
		}
		return Math.max(up[n-1], down[n-1]);
	}
	
//	改进后
    public int wiggleMaxLength1(int[] nums) {
    	int n=nums.length;
        if (n<2) {
			return n;
		}
        int up = 1;
        int down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            }
            if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
}

}

