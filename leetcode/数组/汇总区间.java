package 数组;

import java.util.ArrayList;
import java.util.List;

/*
给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。

示例 1:

输入: [0,1,2,4,5,7]
输出: ["0->2","4->5","7"]
解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
 */
public class 汇总区间 {
    public List<String> summaryRanges(int[] nums) {
    	List<String> list = new ArrayList<>();
    	if (nums==null || nums.length==0) {
			return list;
		}
    	int left=0;
    	int right=0;
    	while (right<nums.length) {
    		//元素大小连续，右边界可以递增
    		 while (right < nums.length-1 && nums[right]+1 == nums[right+1]){
                 right++;
             }
    		 if(right == left){ //只有一个元素时
                 list.add(String.valueOf(nums[left]));
             }else { //多个元素连续时
                 list.add(nums[left] + "->" + nums[right]);
             }
    		 //更新左右区间边界值
             left = right + 1;
             right = left;
         }
         return list;
    }
}
