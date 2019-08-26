package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：

答案中不可以包含重复的四元组。

示例：

给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 */

//双指针法
public class 四数之和 {
//使用双循环固定两个数，用双指针找另外两个数，通过比较与target 的大小，移动指针。
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	List<List<Integer>> res=new ArrayList<List<Integer>>();
    	if(nums==null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        int n = nums.length;
       //最小的数都大于目标值，则没有满足要求的
        if (nums[0] + nums[1] + nums[2] + nums[3] > target) {
            return res;
        }
         //最大的数都小于目标值，则没有满足要求的
        if (nums[n-1] + nums[n-2] + nums[n-3] + nums[n-4] < target) {
            return res;
        }

        for (int i = 0; i < n-3; i++) {
        	//nums[i] = nums[i - 1]，需要去重
			if (i > 0 && nums[i] == nums[i - 1]) continue;
			
			//当前最小的数和已经大于目标值，则没有查找的必要了
			if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
			
			//当前最大的数和小于目标值，可以继续查找是否存在满足要求的nums[i]
			if (nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) continue;
			
			for (int j = i + 1; j < n - 2; j++) {
				//去重
				if (j - i > 1 && nums[j] == nums[j - 1]) continue;
				//检查最小的数和
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                //检查最大的数和
                if (nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target) continue;
                
                //在后面查找后两个数
                int left = j + 1; //左指针
                int right = n - 1; //右指针
                while (left < right) {
                    int tmp = nums[i] + nums[j] + nums[left] + nums[right];
                    if (tmp == target) { //满足要求
                        List<Integer> tmpList = new LinkedList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        res.add(tmpList);
                        //去重复元素
                        while (left < right && nums[left] == nums[left + 1]) left += 1;
                        while (left < right && nums[right] == nums[right - 1]) right -= 1;
                        left += 1;
                        right -= 1;
                    } else if (tmp > target) { //大了
                    	right -= 1;
                    }else { //小了
                    	left += 1;
                    }
                }
			}
		}
        return res; 
    }
}
