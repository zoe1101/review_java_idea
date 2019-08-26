package Math;
/*
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:
输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
示例 2:

输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。

 */
public class 加一 {
	public int[] plusOne(int[] digits) {
		int carry=0;
		int index=digits.length-1;
		if (digits[index]<9) { //末尾小于9  直接加一  返回数组
			digits[index]+=1;
			return digits;
		}
		while (digits[index]==9) { //从后往前，循环到末位不为9为止
			digits[index]=0; //当前的末位加1后变成0
			if (index==0) { //后面全部都需要进位，例如9999,99,9等
				int newlen=digits.length+1;
				int[] newdigits=new int[newlen];
				newdigits[0]=1;
				return newdigits;
			}
			index--;
			carry=1;
		}
		digits[index]+=carry;
		return digits;
	}
}
