package 贪心算法;
/*
给定一个非负整数数组，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
你的目标是使用最少的跳跃次数到达数组的最后一个位置。

输入: [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
           从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 */
public class 跳跃游戏II {
    public static int jump(int[] nums) {
    	if(nums.length<=1) {
    		return 0;
    	}
    	int cur_reach=0;//当前到达位置
    	int nextreach=nums[0]; //跳一次后到达的位置
    	int step=0; //跳跃次数
    	for(int i=0;i<nums.length;i++) {
    		nextreach=Math.max(nextreach, i+nums[i]);
    		if(nextreach>=nums.length-1) return step+1;
    		if(i==cur_reach) { //上次跳跃后到达的位置，即当前所在位置
    			step++;
    			cur_reach=nextreach;
    		}	
    	}
    	return step;
        
    }

	public static void main(String[] args) {
		int[] nums= {2,3,1,1,4};
		System.out.print(jump(nums));

	}

}
