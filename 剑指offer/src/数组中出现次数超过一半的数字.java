package src;

import java.util.HashMap;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如:
 * 输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * @author zoe
 *
 */
public class 数组中出现次数超过一半的数字 {
	/**
	 * 遍历数组，记录数组中数字的值和出现的次数，若下一个数字和记录的值一致，则次数加1，否则次数减1，
	 * 一旦次数减为0，则保存下一个数字，同时将次数置为1，
	 * 遍历完后，要找的数字肯定是最后一次将次数置为1对应的那个数字，时间复杂度为O(n)
	 * @param array
	 * @return
	 */
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array==null ||array.length==0) {
        	return 0;
        }
        int result = array[0];
        int count=1;
        for(int i=1;i<array.length;i++) {
        	if(count==0) {
        		result=array[i];
        		count=1;
        	}else if(array[i]==result) {
				count++;
			}else {
				count--;
			}
        }
        if(checkMoreThanHalf(array,result))
            return result;
        else
            return 0;
    }  
    
    //判断是否数组中的数字有超过半数的
	public static boolean checkMoreThanHalf(int[] array,int result){
	    boolean flag = false;
	    int number = 0;
	    for(int i = 0;i<array.length;i++){
	        if(array[i]==result)
	            number++;
	        else
	            continue;
	    }
	    if(number*2>array.length)
	        flag = true;
	    return flag;
	}

}
