package 数组;
/*
给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，
使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

注意:
不能使用代码库中的排序函数来解决这道题。

示例:

输入: [2,0,2,1,1,0]
输出: [0,0,1,1,2,2]
*/
//排序
public class 颜色分类 {
	/*
使用双指针，分别指向数组的头和尾，将非1的数扔向两边，即将 0 扔向左边，将 2 扔向右边。
定义left指针指向数组开头位置，right指针指向数组末尾位置。
遍历原数组，如果遇到 0，则交换该值和left位置的值，并将left指针后移一位。
若遇到 2，则交换该值和right位置的值，并将right指针前移一位。若遇到1，则继续遍历。
	 */
    public void sortColors(int[] nums) {
    	if(nums == null || nums.length == 0) {
    		return;
    	}
    	int left = 0;
        int right = nums.length - 1;
        for(int i = left; i <= right; i++){
        	if (nums[i]==0) {
				swap(nums,i,left++);
			}
        	if (nums[i]==2) {
				swap(nums, i--, right--);
			}
        }
    }

	private void swap(int[] nums, int i, int j) {
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
		
	}
}
