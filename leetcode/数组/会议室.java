package 数组;

import java.util.Arrays;
import java.util.Comparator;

/*
定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，
请你判断一个人是否能够参加这里面的全部会议。

输入: 
[[0,30],[5,10],[15,20]]

输出: false
 */
public class 会议室 {
	public static boolean canAttendMeetings(int[][] intervals) {
		Arrays.sort(intervals,new Comparator<int[]>() {
			public int compare(int[] a,int[] b) {
				return a[0]-b[0];
			}
		});
		for (int i = 1; i < intervals.length; i++) {
			//当前会议开始时间与上一个会议的结束时间存在冲突
			if (intervals[i][0]>intervals[i-1][1]) { 
				return false;
			}
		}
		return true;
	}

}
