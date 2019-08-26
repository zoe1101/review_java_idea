package 递归与动态规划;

public class 跳跃游戏 {
	public static int jump(int[] arr) {
		if (arr==null || arr.length==0) {
			return 0;
		}
		int jump=0; //目前跳跃的步数
		int cur=0; //如果只能跳jump步可以到达的最远距离
		int next=0; //如果在跳一步（jump+1），可以到达的最远距离
		for (int i = 0; i < arr.length; i++) { //遍历到位置i
			if (cur<i) { //还有没有跳到i，需要再跳一步
				jump++;
				cur=next;
			}
			next=Math.max(next, i+arr[i]);
		}
		return jump;
	}

}
