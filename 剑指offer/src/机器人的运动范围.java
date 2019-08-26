package src;
/*
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下
 * 四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 */

//回溯法
/*
使用一个访问数组记录是否已经经过该格子。
机器人从(0,0)开始移动，当它准备进入(i,j)的格子时，通过检查坐标的数位来判断机器人是否能够进入。
如果机器人能进入(i,j)的格子，接着在判断它是否能进入四个相邻的格子(i,j-1),(i,j+1),(i-1,j),(i+1,j)。
 */
public class 机器人的运动范围 {
    public int movingCount(int threshold, int rows, int cols)
    {
    	if (rows<=0 ||cols<=0 || threshold<0) {
			return 0;
		}
    	boolean[] visited=new boolean[rows*cols]; //记录矩阵中的格子的访问情况
    	return MovingCount(threshold, rows, cols, 0, 0, visited);
    }
//    可以活动的单元格计算
    public static int MovingCount(int threshold, int rows, int cols,int i, int j,boolean[] visited) {
		int count=0;
		int index=i*cols+j;
		if (canWalkInto(threshold, rows, cols, i, j, visited)) {
			visited[index]=true;
			count=1+MovingCount(threshold, rows, cols, i-1, j, visited)
				   +MovingCount(threshold, rows, cols, i+1, j, visited)
				   +MovingCount(threshold, rows, cols, i, j-1, visited)
				   +MovingCount(threshold, rows, cols, i, j+1, visited);
		}
		return count;
	}
    //判断当前位置是否能走
    public static boolean  canWalkInto(int threshold, int rows, int cols,int i, int j,boolean[] visited) {
    	int index=i*cols+j;
		if (i>=0 && i<rows && j>=0 && j<cols && getSumOfDigits(i)+getSumOfDigits(j)<=threshold && !visited[index]) {
			return true;
		}else {
			return false;
		}
	}
    //就算一个数字的数位和，13->1+3=4
    public static int getSumOfDigits(int number){
        int sum=0;
        while(number!=0){
            sum+=number%10;
            number/=10;
        }
        return sum;
    }

}
