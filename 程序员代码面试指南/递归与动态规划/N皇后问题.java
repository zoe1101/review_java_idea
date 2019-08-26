package 递归与动态规划;
/*
 * 在n x n的棋盘上放置彼此不受攻击的n个皇后，彼此之间满足如下规则：
 * 任意两个棋子不同行，不同列，并且不在一条斜线上。
 */
public class N皇后问题 {
	private static int solution1(int n) {
		if(n<1) return 0;
		int[] record=new int[n]; //记录第i行的皇宫所在的位置，在哪一列
		return process1(0, record, n);
	}
	/**
	 * 
	 * @param i :在第i行放置皇后
	 */
	private static int process1(int i, int[] record, int n) {
		if(i==n) {
			return 1;
		}
		int res=0;
		for(int j=0;j<n;j++) {
			if(isVaild(record, i, j)) {
				record[i]=j;
				res+=process1(i+1, record, n);
			}
		}
		return res;
	}
	/**
	 * 判断是否可以在第i行的第j列放置皇后
	 */
	private static boolean isVaild(int[] record, int i, int j) {
		for(int k=0;k<i;k++) {
			if(j==record[k] || Math.abs(record[k]-j) == Math.abs(i-k) ) {
				return false;
			}
		}
		return true;
	}
	/**
	 * 递归+位运算，利用位运算进行加速
	 * @param n
	 * @return
	 */
	public static int solution2(int n) { 
		//这里位运算符的载体是int型变量，所以只能算1到32个皇后问题
		if(n<1 || n>32) return 0;
		int upperLim=n==32?-1:(1<<n)-1; //当前行哪些位置可以放皇后，1代表可以放置
		return process2(upperLim, 0, 0,0);
	}
	/**
	 * 位于该行上的冲突位置用colLim、leftDiaLim和rightDiaLim中的1来表示。
	 * 把它们三个并起来，得到该行所有的禁位，取反后就得到所有可以放的位置（用pos来表示）。
	 * 从上向下搜索的
	 * @param upperLim://当前行哪些位置可以放皇后，1代表可以放置，0代表不可以
	 * @param colLim:前面的行中，哪些列已经放置了皇后，1代表已经放置，0代表没有
	 * @param leftDiaLim:因为受已经放置的所有皇后的对左下方斜线的影响，导致当前行不能放置皇后，1代表不能放置
	 * @param rightDiaLim:因为受已经放置的所有皇后的对右下方斜线的影响，导致当前行不能放置皇后，1代表不能放置
	 * @return
	 */
	private static int process2(int upperLim, int colLim, int leftDiaLim, int rightDiaLim) {
		if(colLim==upperLim) { //如果递归到某个时候发现colLim=upperlim，说明n个皇后全放进去了，找到的解的个数加一。
			return 1;
		}
		int pos=0; //当前行可以放的位置
		int mostRightOne=0;
		pos=upperLim&(~(colLim |leftDiaLim | rightDiaLim));
		int res=0;

		while (pos!=0) {//0 -- 皇后没有地方可放，回溯
//			  pos & -pos
//			取反再加 1 就是补码，and 运算 与负数，就是按位和补码与运算。
			mostRightOne=pos & (~pos+1);//取出最右边的那个1。这样pos就表示该行的某个可以放的位置，把它从pos中移除并递归调用该过程。
//			pos中存储了所有的可放位置，为了求出所有解，必须遍历所有可放的位置，而每走过一个点必须要删掉它，否则就成死循环啦！
			pos=pos-mostRightOne;
//			  (leftDiaLim | mostRightOne)<< 1 是因为由leftDiaLim造成的占位在下一行要右移一下；
//			 (rightDiaLim | mostRightOne)>> 1 是因为由rightDiaLim造成的占位在下一行要左移一下。
			res+=process2(upperLim, colLim|mostRightOne, (leftDiaLim|mostRightOne)<<1, (rightDiaLim|mostRightOne)>>1);
		}
		return res;
	}

	public static void main(String[] args) {
		int n = 8;

		long start = System.currentTimeMillis();
		System.out.println(solution1(n));
		long end = System.currentTimeMillis();
		System.out.println("cost time: " + (end - start) + "ms");

		start = System.currentTimeMillis();
		System.out.println(solution2(n));
		end = System.currentTimeMillis();
		System.out.println("cost time: " + (end - start) + "ms");

	}

}
