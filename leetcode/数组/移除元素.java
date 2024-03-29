package 数组;
/*
给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
//难度：easy
//方法：双指针
public class 移除元素 {
	
	public static int removeElement(int[] nums, int val) {
		if(nums.length==0) {//空数组
			return 0;
		}
		int i=0;
		for(int j=0;j<nums.length;j++) {
			if(nums[j]!=val) {
				nums[i]=nums[j];
				i++;
			}
		}
        return i;
    }

	public static void main(String[] args) {
		int[] nums={3,2,2,3};
		int val=3;
		System.out.println(removeElement(nums,val));

	}

}
