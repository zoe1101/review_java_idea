package 数组;

import java.util.ArrayList;
import java.util.List;

/*
Given a sorted integer array where the range of elements are [lower, upper] inclusive, 
return its missing ranges.

For example, 
given [0, 1, 3, 50, 75], lower = 0 and upper = 99, 
return ["2", "4->49", "51->74", "76->99"].

 */
public class 缺失的区间 {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> list=new ArrayList<>();
		 if (nums == null || nums.length == 0) {
			 list.add(range(lower, upper));
	            return list;
        }
		if (lower < nums[0]) {
			list.add(range(lower, nums[0]-1));
		}
		for(int i=0; i<nums.length-1; i++) {
            if (nums[i]+1 < nums[i+1]) { //前后元素不连续
            	list.add(range(nums[i]+1, nums[i+1]-1));
            }
        }
        if (nums[nums.length-1] < upper) {
        	list.add(range(nums[nums.length-1]+1, upper));
        }
        return list;

		
	}
	
	private String range(int lower, int upper) {
        if (lower == upper) {
        	return Integer.toString(lower);
        }
        return lower + "->" + upper;
    }

}
