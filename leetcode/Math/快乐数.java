package Math;

import java.util.HashSet;
import java.util.Set;

/*
编写一个算法来判断一个数是不是“快乐数”。

一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。
如果可以变为 1，那么这个数就是快乐数。

示例: 

输入: 19
输出: true
解释: 
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1

 */
public class 快乐数 {
	Set<Integer> set=new HashSet<Integer>();//记录出现过的平方和
    public boolean isHappy(int n) {
    	int result = 0;
        while(n!=0){ //每个位置上的数字的平方和
            int i = n % 10;
            result += i*i;
            n /= 10;
        }
        if(set.contains(result) && result!=1) { //如果一个平方和多次出现，即代表进入了循环状态，不会是快乐数
        	return false;
        }else { //集合中不包含当前平方和
        	set.add(result);
        }
        if(result == 1) return true;
        return isHappy(result);
    }
}
