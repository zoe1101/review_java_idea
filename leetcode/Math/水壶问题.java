package Math;
/*
有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，
从而可以得到恰好 z升 的水？
如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水.

你允许：
装满任意一个水壶
清空任意一个水壶
从一个水壶向另外一个水壶倒水，直到装满或者倒空

示例 1: (From the famous "Die Hard" example)
输入: x = 3, y = 5, z = 4
输出: True

示例 2:
输入: x = 2, y = 6, z = 5
输出: False

 */
public class 水壶问题 {
//	找到x,y的最大公约数能否z被整除
    public boolean canMeasureWater(int x, int y, int z) {
        if (x+y<z) {
			return false;
		}
        int g = gcd(x, y); //最大公约数
        return z == 0 || z % g == 0;
    }
/*用较大数除以较小数，再用出现的余数（第一余数）去除除数，再用出现的余数（第二余数）
 * 去除第一余数，如此反复，直到最后余数是0为止。如果是求两个数的最大公约数，
 * 那么最后的除数就是这两个数的最大公约数。
 */
    private int gcd(int a, int b) { //辗转相除法
        while (b!=0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}
