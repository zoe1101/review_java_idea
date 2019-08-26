package 数组;
/*
 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6
 */
public class 接雨水 {
    public int trap(int[] height) {
        if (height==null || height.length<3) {
			return 0;
		}
        int res=0;
        int leftMax=height[0];
        int rightMax=height[height.length-1];
        int L=1;
        int R=height.length-2;
        while (L<=R) {
			if (leftMax<=rightMax) {
				res+=Math.max(0, leftMax-height[L]);
				leftMax=Math.max(leftMax, height[L++]);
			}else {
				res+=Math.max(0, rightMax-height[R]);
				rightMax=Math.max(rightMax, height[R--]);
			}
		}
        return res;
    }
}
