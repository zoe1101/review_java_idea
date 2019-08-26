package 回溯算法;
/*
实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

 */
public class 下一个排列 {
	//从后面遍历数组，找出右侧比当前节点大的数据，交换他们，并将当前节点右侧排序。
    public void nextPermutation(int[] nums) {
    	boolean ifreverse = false;
		int k = -1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (ifreverse)
				break;
			for (int j = nums.length - 1; j > i; j--) {
				if (nums[i] < nums[j]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
					k = i;
					ifreverse = true;
					break;
				}
			}
		}

		if (!ifreverse) {
			for (int i = 0; i < nums.length/2; i++) {
				int temp = nums[i];
				nums[i] = nums[nums.length-1-i];
				nums[nums.length-1-i] = temp;
			}
		} else {
			// 将k后面的数排序
			for (int i = k + 1; i < nums.length - 1; i++) {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[i] > nums[j]) {
						int tmp = nums[i];
						nums[i] = nums[j];
						nums[j] = tmp;
					}
				}
			}
		}
    }
}
