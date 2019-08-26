package 贪心算法;
/*
给定一个非负整数数组，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个位置。

输入: [2,3,1,1,4]
输出: true
解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 */
public class 跳跃游戏 {
    public static boolean canJump(int[] nums) {
        if(nums[0]==0){
        	if(nums.length==1) return true;
        	else if (nums.length>1) return false;
        }
        int n=nums.length;
        int temp=1;//记录到达最后一个元素, 需要跳跃的步数
        for(int i=n-2;i>=0;i--) { //从后往前遍历
        	if(nums[i]>=temp) { //可以到达当前的最后一个元素，则截断后边的元素。
        		temp=1;
        		continue;
        	}else { //继续往前
        		temp++;
        	}
        }
        //若最后剩下的元素大于1个，则可以判断为假。
        return (temp==1)?true:false;
    }

	public static void main(String[] args) {
		int[] nums= {2,3,1,1,4};
		System.out.print(canJump(nums));

	}

}
