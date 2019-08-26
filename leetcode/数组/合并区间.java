package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

 */
public class 合并区间 {
	/*
	 先按照数组开始位置从小到大排序，然后遍历判断两个相邻的节点区域是否有交集。
	 若有交集，取出最大及最小值作为新的节点
	 */
    public int[][] merge(int[][] intervals) {
    	if(intervals==null || intervals.length<= 1) {
    		return intervals;
    	}
    	Arrays.sort(intervals,new Comparator<int[]>() {
    		@Override
    		public int compare(int[] a,int[] b) {
				return a[0]-b[0];
			}
		} );
    	
    	List<int[]> list=new ArrayList<int[]>();
    	int i=0;
    	while (i<intervals.length) {
			int left=intervals[i][0];
			int right=intervals[i][1];
			//当前区间的结束位置和下一个区间的重叠了
			while(i<intervals.length-1 && right>=intervals[i+1][0]){ 
				right = Math.max(right,intervals[i+1][1]); //更新结束位置
                i++;
            }
			list.add(new int[] {left,right});
            i++;
        }
        return list.toArray(new int[list.size()][2]);
    }
}
