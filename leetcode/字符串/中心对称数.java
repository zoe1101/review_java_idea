package 字符串;

import java.util.HashMap;

/*
中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
请写一个函数来判断该数字是否是中心对称数，其输入将会以一个字符串的形式来表达数字。

示例 1:

输入:  "69"
输出: true
示例 2:

输入:  "88"
输出: true
示例 3:

输入:  "962"
输出: false

 */
public class 中心对称数 {
	/*
	 0, 1, 6, 8, 9 旋转 180° 以后，得到了新的数字 0, 1, 9, 8, 6 。
     2, 3, 4, 5, 7 旋转 180° 后,得到的不是数字。
	 */
	public boolean isStrobogrammatic(String num) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('1','1');
        map.put('0','0');
        map.put('6','9');
        map.put('9','6');
        map.put('8','8');
        int left=0;
        int right=num.length()-1;
		//从两边向中间检查对应位置的两个字母是否有映射关系
		while (left<=right) {
			// 如果字母不存在映射或映射不对，则返回假
			 if(!map.containsKey(num.charAt(right)) || num.charAt(left) != map.get(num.charAt(right))){
	                return false;
            }
            left++;
            right--;
		}
		return true;	
	}
}
