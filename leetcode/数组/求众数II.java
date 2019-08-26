package 数组;

import java.util.ArrayList;
import java.util.List;

/*
给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。

输入: [1,1,1,3,3,2,2,2]
输出: [1,2]
 */
public class 求众数II {
    public List<Integer> majorityElement(int[] nums) {
    	List<Integer> res=new ArrayList<Integer>();
    	if (nums==null || nums.length==0) {
			return res;
		}
    	if (nums.length==1) {
			res.add(nums[0]);
			return res;
		}
    	int cand1=0;
    	int cand2=0;
    	int time1=0;
    	int time2=0;
    	for (int i = 0; i < nums.length; i++) {
			if ((time1==0 || cand1==nums[i]) && cand2!=nums[i]) { //确保候选1不等于候选2
				cand1=nums[i];
				time1++;
			}else if (time2==0 || cand2==nums[i]) {
				cand2=nums[i];
				time2++;
			}else {
				time1--;
				time2--;
			}
		}
    	
    	time1=0;
    	time2=0;
    	for (int i = 0; i < nums.length; i++) {
			if (cand1==nums[i]) {
				time1++;
			}
			if (cand2==nums[i]) {
				time2++;
			}
		}
    	if (time1>nums.length/3) {
			res.add(cand1);
		}
    	if (time2>nums.length/3) {
    		if (cand2!=cand1) {
    			res.add(cand2);
			}
		}
    	return res;
    	
    }
}
