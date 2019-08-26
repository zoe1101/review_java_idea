package 其他题目;

import java.util.HashSet;

//小矩形拼成大矩形
public class 能否完美的拼成矩形 {
	//定位法
	public static boolean isRectCover(int[][] matrix) {
		if (matrix==null || matrix.length==0 || matrix[0].length==0) {
			return false;
		}
		int mostLeft=Integer.MAX_VALUE; //记录最左边的点的x值
		int mostRight=Integer.MIN_VALUE;//记录最右边的点的x值
		int mostUp=Integer.MIN_VALUE; //记录最上边的点的y值
		int mostDown=Integer.MAX_VALUE; //记录最下边的点的y值
		HashSet<String> set =new HashSet<String>(); //记录每个点的出现次数
		int area=0;
		for (int[] rect:matrix) { //一个小矩形由左下角点和右上角点组成，共四个值
			mostLeft=Math.min(mostLeft, rect[0]);
			mostDown=Math.min(mostDown, rect[1]);
			mostRight=Math.max(mostRight, rect[2]);
			mostUp=Math.max(mostUp, rect[3]);
			area+=(rect[2]-rect[0])*(rect[3]-rect[1]); //长乘宽
			String leftDown=rect[0]+","+rect[1];
			String leftUp=rect[0]+","+rect[3];
			String rightDown=rect[2]+","+rect[1];
			String rightUp=rect[2]+","+rect[3];
			if (!set.add(leftDown)) { //如果leftDown这个点已经存在了，会返回false
				set.remove(leftDown); //可以通过移除这个点来判断是否出现偶数次
			}
			if (!set.add(leftUp)) {
				set.remove(leftUp);
			}
			if (!set.add(rightDown)) {
				set.remove(rightDown);
			}
			if (!set.add(rightUp)) {
				set.remove(rightUp);
			}
		}
		//判断最左，右，上，下的点是否只出现一次，且保证其他点出现偶数次
		if (   !set.contains(mostLeft+","+mostDown)
			|| !set.contains(mostLeft+","+mostUp)
			|| !set.contains(mostRight+","+mostDown)
			|| !set.contains(mostRight+","+mostUp)
			|| set.size()!=4) {
			return false;
		}
		return area==(mostRight-mostLeft)*(mostUp-mostDown)?true:false;
	}
	

}
