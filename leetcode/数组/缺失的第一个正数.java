package 数组;

/*
给定一个未排序的整数数组，找出其中没有出现的最小的正整数。

输入: [3,4,-1,1]
输出: 2
 */
//时间复杂度应为O(n),并且只能使用常数级别的空间。
//难度: hard
//让数组的第i个位置应该存放值i + 1
//对于一个正数number，我们将其放在数组nums中第number - 1个位置  [1,2,3,4,5,...]
public class 缺失的第一个正数 {
	
    public static int firstMissingPositive(int[] nums) {
    	for(int i=0;i<nums.length;i++) {
    	   while(nums[i]>0 && nums[i]<=nums.length && nums[nums[i]-1]!=nums[i]) {
    		   int temp=nums[i];
    		   nums[i]=nums[temp-1];
    		   nums[temp-1]= temp;
    	    }
    	}
    	for (int i = 0; i < nums.length; i++) {
			if(nums[i]!=i+1) {
				return i+1;
			}
		}
    	return nums.length+1;
        
    }

	public static void main(String[] args) {
		int[] nums= {3,4,-1,1};
		System.out.print(firstMissingPositive(nums));
	}

}
