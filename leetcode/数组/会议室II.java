package 数组;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，
请你计算最少需要多少个会议室。

输入: 
[[0,30],[5,10],[15,20]]
输出: 2
 */
public class 会议室II {
	/*
	 使用优先队列算法, 生成优先队列, 代表已开的房间, 先将时间段按照开始时间排序, 遍历时间段, 
	 如果没有多余的房间, 则将这个会议的加到队列里, 
	 如果有多余的房间且目前会议的起始之间在上个会议的终止时间之后, 更新队列.
	 */
	public int minMeetingRooms(int[][] intervals) {
		if(intervals == null || intervals.length == 0) return 0; 
		Arrays.sort(intervals,new Comparator<int[]>() {
			public int compare(int[] a,int[] b) {
				return a[0]-b[0];
			}
		});
		
		PriorityQueue<Integer> queue=new PriorityQueue<Integer>();
		for (int i = 0; i < intervals.length; i++) {
			//当前会议开始时间与之前会议的结束时间不存在冲突
			if (i>0 && !queue.isEmpty() && intervals[i][0]>=queue.peek()) { 
				queue.poll();
			}
			queue.add(intervals[i][1]);
		}
		return queue.size();
	}
}
