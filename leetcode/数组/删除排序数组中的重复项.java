package 数组;

import org.omg.CORBA.portable.RemarshalException;

/*
 *给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，
 *返回移除后数组的新长度。
不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
//方法：双指针法
//一个记录remove过后的数组最后一个元素位置，一个用来遍历整个数组，判断条件就是比较该元素和target的值，
//如果不相等就把它copy给另一个pointer.
//难度：easy
/*
 时间复杂度：O(n)， 假设数组的长度是 n，那么 i 和 j 分别最多遍历 n 步。
空间复杂度：O(1)。
 */
public class 删除排序数组中的重复项 {
	public static int removeDuplicates(int[] nums) {
		if(nums.length==0) return 0;
		int i=1; //用于记录remove过后的数组最后一个元素位置
		for(int j=1;j<nums.length;j++) {
			if(nums[i-1]!=nums[j]) {
				nums[i]=nums[j];
				i++;
			}
		}
		return i;
    }

	public static void main(String[] args) {
		int[] nums= {1,2,2,3,3,4,4,5};
		System.out.println(removeDuplicates(nums));
	}

}
