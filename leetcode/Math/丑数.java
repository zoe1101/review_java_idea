package Math;
/*
编写一个程序判断给定的数是否为丑数。

丑数就是只包含质因数 2, 3, 5 的正整数。

示例 1:

输入: 6
输出: true
解释: 6 = 2 × 3
示例 2:

输入: 8
输出: true
解释: 8 = 2 × 2 × 2
 */
public class 丑数 {
	 public boolean isUgly(int num) {
		if (num<=1) {
			return num==1?true:false;
		} 
		while (num>1) { //1是循环终止条件，如果num为1了还只有2,3,5三个因子，则其是丑数
			int temp=num;
			while (temp%2==0) {
				temp/=2;
			}
			while (temp%3==0) {
				temp/=3;
			}
			while (temp%5==0) {
				temp/=5;
			}
			if (temp==num) { //temp不能整除2,3,5
				return false;
			}
			num=temp; //更新num
		}
		return true;
	 }
}
