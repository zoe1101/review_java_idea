package 数组;

/*
给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 */
//难度：easy
/*
说明:
初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
示例:
输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
 */

//先算出A和B的总长度,由于数组中后面的元素是空的,可以从后往前复制，
//时间复杂度是O(M+N)
//空间复杂度是O(1)
public class 合并两个有序数组 {
	//归并排序的merge过程
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i=m-1;
		int j=n-1;
		int index=m+n-1;
		//从尾部开始遍历，否则会覆盖 nums1 的值。
	    while (i>=0||j>=0) {
	    	 //前两个判断要放在前面，防止空指针异常
			if(i<0) {//说明nums1已经填充完了
				nums1[index--]=nums2[j--];//把nums2填充到nums1之后
				continue;
			}else if(j<0){//nums2已经全部填充到了nums1,直接跳出循环就行了
				break;
			}
			//将数据填充到具体的index
			if(nums1[i]>nums2[j]) {//对应元素交换
				nums1[index--]=nums1[i--];
			}else {
				nums1[index--]=nums2[j--];
			}
	    }
	     
	 }

	public static void main(String[] args) {
//		

	}

}
