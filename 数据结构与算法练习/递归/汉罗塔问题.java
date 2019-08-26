package 递归;


/*
  * 伪算法(要移动盘子的柱子为A,借助的介质柱子为B,移动到目的柱子为C.
  * 如果盘子数为1，则直接将盘子从A柱子移到C柱子。
  * 否则：
  *     step1:将A柱子上的N-1个盘子借助于C柱子移动到B柱子上。
  *     step2:将A柱子上的第N个盘子直接移动到C柱子上。
  *     step3:将B柱子上的N-1个盘子借助A柱子移动到C柱子上。
 */
public class 汉罗塔问题 {
	public static void hannoi(int n,char from,char in,char to) {
		if(n==1) {
			System.out.println("将编号为"+n+"的盘子从"+from+"移动到"+to);
		}else {
			hannoi(n-1,from,to,in);  //将编号小于n的盘子移动到中间
			System.out.println("将编号为"+n+"的盘子从"+from+"移动到"+to); //将编号为n个的盘子从左边移动到右边
			hannoi(n-1, in, from, to); //将编号小于n的盘子从中间移动到右边
		}
		
	}

	public static void main(String[] args) {
		int n=3;
		hannoi(n, 'A', 'B', 'C');

	}

}
