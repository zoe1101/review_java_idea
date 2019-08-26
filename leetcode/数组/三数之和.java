package 数组;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
注意：答案中不可以包含重复的三元组

例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
//难度：meduim

//固定一个，找后两个
class 三数之和 {
	//一遍哈希表
    public int hash1(int[] nums) {
    	int target=0;
        if (nums == null || nums.length < 3) {
            return 0;
        }
        // 这个不用去重，直接找到最小值即可。
        Arrays.sort(nums); // 仍然需要先排序
        int minSum = nums[0] + nums[1] + nums[2];
        for (int k = 0; k < nums.length; k++) {
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                int curSum = nums[k] + nums[i] + nums[j];
                if (Math.abs(curSum - target) < Math.abs(minSum - target)) {
                    minSum = curSum;
                }
                if (curSum > target) {
                    j--;
                }else if (curSum == target) {
                    return curSum;
                }else{
                    i++;
                }
            }
        }
        return minSum;
    }
    //暴力法
    public List<List<Integer>> violence(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		int len=nums.length;
		if (len<3) {
			System.out.println("数组长度小于3");
			return result;
			} //数组长度小于3
			
		Arrays.sort(nums);  // 先对数组进行排序，然后利用双指针进行两数之和。O(n*n)
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>0) break;
			if(i>0 && nums[i]==nums[i-1]) continue; // 对第一层元素去重(去重的目的是防止出现重复三元组结果.)
			int j=nums.length-1;
			int target=0-nums[i];
			int k=i+1;
			while(k<j)
				if(nums[k]+nums[j]==target) {
					List<Integer> item=Arrays.asList(nums[i],nums[k],nums[j]);
					result.add(item);
					while(k<j && nums[k]==nums[k+1]) k++; // 对第二层元素去重处理
					while(k<j && nums[j]==nums[j-1]) j--;
					k++;j--;
						}
				else if (nums[k]+nums[j]<target)
					k++;
				else
					j--;
		}
		return result;
	}
public static void main(String[] args) {
    三数之和 solution = new 三数之和();
    System.out.println(solution.hash1(new int[]{-1, 0, 1, 2, -1, -4}));
}
}
