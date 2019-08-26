package 数组;

import java.util.Arrays;

import test.test;

/*
给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。

示例 1:

输入: nums = [1, 5, 1, 1, 6, 4]
输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]

 */
public class 摆动排序II {
	/*
	 */
    public void wiggleSort(int[] nums) {
    	int n=nums.length;
        if (n<2) {
			return ;
		}
        int[] tmp=nums.clone();
        Arrays.sort(tmp);//排序
        int left = (n + 1) / 2;
        int right = n;
        //交叉写入
        for (int i = 0; i < tmp.length; i++) {
			if (i%2==0) {//偶数位置放左半部分的数
				nums[i] = tmp[--left];
			}else {//奇数位置放右半部分的数
				nums[i] = tmp[--right];
			}
		}
    }

}
