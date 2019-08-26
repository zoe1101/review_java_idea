package 位运算;
/*
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。
找出那个只出现了一次的元素。

说明：
你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:
输入: [2,2,3,2]
输出: 3

 */
public class 只出现一次的数字II {
    public int singleNumber(int[] nums) {
        int a=0,b=0;
        for (int num:nums) {
        	a = (a ^ num) & ~b;
            b = (b ^ num) & ~a;
		}
        return a;
    }
    
}
