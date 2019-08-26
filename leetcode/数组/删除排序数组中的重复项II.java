package 数组;

/*
 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，
 返回移除后数组的新长度。
不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
//难度：meduim
public class 删除排序数组中的重复项II {
	public static int removeDuplicates(int[] nums) {
		if(nums.length==0) return 0;
		int i=1; //记录remove过后的数组最后一个元素位置
		int count=0;//记录重复次数
		for(int j=1;j<nums.length;j++) { //遍历整个数组
			if(nums[i-1]==nums[j]) {
				count++;
				if(count>=2) continue;
			}else {
				count=0;
			}
			nums[i]=nums[j];
			i++;
		}
		return i;
	    }

	public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,1,2,3,3};
		System.out.println(removeDuplicates(nums));
	}

}
