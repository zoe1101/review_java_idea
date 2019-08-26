package 数组;

import java.util.PriorityQueue;

/**
在未排序的数组中找到第 k 个最大的元素。
请注意，你需要找的是数组排序后的第 k个最大的元素，而不是第 k个不同的元素。

示例 1:

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
 * @author zoe
 *
 */

//堆排序
public class 数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
    	 PriorityQueue<Integer> queue = new PriorityQueue<>();
    	 for (int num:nums) {
			queue.add(num);
			if (queue.size()>k) {
				queue.poll();
			}
		}
    	 return queue.peek();
    }
}
