package 数组;

import java.util.LinkedList;

/*
给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
返回滑动窗口最大值。

示例:

输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7] 
解释: 

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 
注意：
你可以假设 k 总是有效的，1 ≤ k ≤ 输入数组的大小，且输入数组不为空。

 */
public class 滑动窗口最大值 {
    /*
    双向队列保存当前窗口中最大的值的数组下标,双向队列中的数从大到小排序，
    新进来的数如果大于等于队列中的数 则将这些数弹出,再添加
    当R-L+1=k 时 滑窗大小确定 每次R前进一步L也前进一步 保证此时滑窗中最大值的
    数组下标在[L，R]中，并将当前最大值记录
    */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || k<1 || nums.length<k) {
        	return new int[] {};
        }
     // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数按从大到小排序
        LinkedList<Integer> qmax=new LinkedList<Integer>();
        int[] res=new int[nums.length-k+1]; // 结果数组
        int index=0;
        for (int i = 0; i < nums.length; i++) {
        	// 保证从大到小的顺序，如果前面数小弹出
			while (!qmax.isEmpty() && nums[i]>=nums[qmax.peekLast()]) {
				qmax.pollLast();
			}
			 // 添加当前值对应的数组下标
			qmax.addLast(i);
			 // 初始化窗口 等到窗口长度为k时，下次移动前删除过期数值
			if (qmax.peekFirst()==i-k) {
				qmax.pollFirst();
			}
			 // 窗口长度为k时，保存当前窗口中最大值
			if (i>=k-1) {
				res[index++]=nums[qmax.peekFirst()];
			}
		}
        return res;
    }
}
