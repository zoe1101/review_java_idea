package 栈和队列;

import java.util.Stack;

public class 最大子矩阵的大小 {
	public static int maxRecSize(int[][] map) {
		if(map==null || map.length==0||map[0].length==0) {
			return 0;
		}
		int maxArea=0;
		int[] height=new int[map[0].length];
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				height[j]=map[i][j]==0?0:height[j]+1;//只记录连续1的情况
			}
			maxArea=Math.max(maxArea, maxRecFromBoottom(height));
		}
		return maxArea;
	}
	public static int maxRecFromBoottom(int[] height) {
		if(height==null ||height.length==0) {
			return 0;
		}
		int maxArea=0;
		Stack<Integer> stack=new Stack<Integer>();
		for(int i=0;i<height.length;i++) {
			while (!stack.isEmpty() && height[stack.peek()]>=height[i]) {
				int curIndex=stack.pop();
				int leftLessIndex=stack.isEmpty()?-1:stack.peek(); //左边最早小于当前元素对应元素的位置索引
				int curArea=(i-leftLessIndex-1)*height[curIndex];
				maxArea=Math.max(curArea, maxArea);
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			int curIndex=stack.pop();
			int leftLessIndex=stack.isEmpty()?-1:stack.peek(); //左边最早小于当前元素对应元素的位置索引
			int curArea=(height.length-leftLessIndex-1)*height[curIndex];
			maxArea=Math.max(curArea, maxArea);
		}
		
		return maxArea;
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
