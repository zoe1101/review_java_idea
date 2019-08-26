package 数组;

import test.class_A;

/*
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
你可以假设除了整数 0 之外，这个整数不会以零开头。

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
 */
//解题思路：使用加法进位的原理进行求解。
public class 加一 {
	 public static int[] plusOne(int[] digits) {
        int carry=0;//进位标志
        int index=digits.length-1;
        if(digits[index]<9){  //末尾小于9  直接加一  返回数组
            digits[index]+=1;
            return digits;
        }
        while(digits[index]==9){      //末尾为9
            digits[index]=0;   //末尾置0  之后判断次末尾
            if(index==0){          //考虑输入为999 或 9这种极端情况
                //数据溢出，申请新的数组空间
                int newLen=digits.length+1;
                int[] newDigits=new int[newLen];
                newDigits[0]=1;//最高位置1
                return newDigits;
            }
            --index;  //再判断次末尾是否为9
            carry=1;   //进位
        }
        digits[index]=digits[index]+carry;
        return digits; 
    }
	public static void main(String[] args) {
		int[] digits= {9,9,9,9};
		for(int e:plusOne(digits)){
			System.out.println(e+" ");
		}

	}

}
