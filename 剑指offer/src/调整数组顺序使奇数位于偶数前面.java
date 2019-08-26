package src;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author zoe
 *
 */
//不用保证原始顺序
public class 调整数组顺序使奇数位于偶数前面 {
	/**
	 * 复杂度：O(n^2)
	 * @param array
	 * @return
	 */

	//利用双指针法，一个从左往右left，一个从右往左right，出现前偶后奇就交换
	public static int[] reOrderArray(int [] array) {
	    if (array==null || array.length<2){
	        return array;
        }
	    int left=0;
	    int right=array.length-1;
	    while (left<right){
	        while (left<right && (array[left]&1)!=0){
	            left++;
            }
            while (left<right && (array[right]&1)==0){
                right--;
            }
            if (left<right){
                int temp=array[left];
                array[left]=array[right];
                array[right]=temp;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(reOrderArray(arr)));
    }
}
