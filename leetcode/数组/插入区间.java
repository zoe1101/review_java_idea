package 数组;
/*
给出一个无重叠的 ，按照区间起始端点排序的区间列表。
在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。

示例 1:

输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
输出: [[1,5],[6,9]]

 */
public class 插入区间 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
    	int Num= intervals.length;
    	// 假设没有合并,最终的区间个数为 Num + 1
        int newNum = intervals.length + 1;
        int i=0;
        for (; i < Num; i ++) {
        	if (newInterval[0]<intervals[i][0]) {// 如果新区间小于当前区间
        		if (newInterval[1]<intervals[i][0]) {// 区间不重叠,则新区间放在当前位置
					break;
				}
        		//否则合并为新区间,将当前区间丢弃,新数组长度 - 1
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                intervals[i] = null;
                newNum --; 
			}else {// 新区间的起始位置大于当前区间的起始位置大,且存在重叠
				//合并为新区间,将当前区间丢弃,新数组长度 - 1
				if (newInterval[0] <= intervals[i][1]) {
					newInterval[0] = intervals[i][0];
                    newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                    newNum --; 
                    intervals[i] = null;
				}
			}
        }
        int[][] res = new int[newNum][];
        int j = 0;
        int k = 0;
        // 将新区间取代位置前的所有区间(不包括舍弃的,null)放入新数组
        for (; k < i; k ++) {
            if (intervals[k] != null) {
                res[j++] = intervals[k];
            }
        }
        // 放入新区间
        res[j++] = newInterval;
        // 将新区间取代位置后的所有区间(不包括舍弃的,null)放入新数组
        for (; k < Num; k ++) {
            if (intervals[k] != null) {
                res[j++] = intervals[k];
            }
        }
        return res;
    }
}
