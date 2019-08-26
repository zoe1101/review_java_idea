package 动态规划;

import java.util.Stack;

/*
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
求在该柱状图中，能够勾勒出来的矩形的最大面积。

输入: [2,1,5,6,2,3]
输出: 10
 */

//递增栈实现
public class 柱状图中最大的矩形 {
	/*
	首先我们定义我们的stack栈[],这个栈用来储存的是对应矩形的下标。
	我们希望，这个stack里储存的下标所对应的高度是递增的。
	如果出现不递增的情况，则代表出现了断层，这时候我们就可以在这个断层处更新我们的最大面积。
	有人可能会问，如果这些矩形的高度是一直递增的呢？那不就不存在下降的断层嘛？
	没错，所以我们在heights的末尾处加了一个0，就是为了让面积能在最后结束结算。

	以[2,1,5,6,2,3]为例，它一开始会变为[2,1,5,6,2,3,0]。
	接着我们把0（第一个元素的下标）添进栈中，接下来遇到的高度是个断层，
	所以我们pop掉0这个下标，更新面积为heights[0]*1 (结果为2)。
	接下来的三个下标，1，2，3 分别对应 1， 5， 6 三个高度，所以它们是递增的，
	所以这时stack保存的下标为[1,2,3],接下来遇到断层，于是我们会逐个蹦出我们的元素，
	先蹦下标3，更新面积，再蹦下标2，更新面积，但是下标1不会蹦出来，
	因为下标1和当前下标4的面积还是存在很多种可能性的，我们不能在这里就结束它们之间的联系，
	意思是说这2个下标在以后的遍历过程中可能会制造更大的面积，所以我们保留。

	 */
    public int largestRectangleArea(int[] heights) {
        if (heights==null || heights.length==0) {
			return 0;
		}
        if (heights.length==1) {
			return heights[0];
		}
        int res=0;
        Stack<Integer> stack=new Stack<Integer>();
        int[] newheights=new int[heights.length+1];
        for (int i = 0; i < heights.length; i++) {
			newheights[i]=heights[i];
		}
        newheights[heights.length]=0;
        for (int i = 0; i < newheights.length; i++) {
			while (!stack.isEmpty() && newheights[stack.peek()]>=newheights[i]) {
				int index=stack.pop();
				int left=stack.isEmpty()?-1:stack.peek();
				res=Math.max(res, (i-left-1)*newheights[index]);
			}
			stack.push(i);
		}
        return res;
    }
}
