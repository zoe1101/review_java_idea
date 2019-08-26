package test;

import java.util.Arrays;

public class Arrays类练习 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] array=new int[5];
		Arrays.fill(array,3); // 填充数组,3代表填充值
		System.out.println("填充数组：Arrays.fill(array, 5)：");
		printArray(array);
		// 将数组的第2和第3个元素赋值为8
        Arrays.fill(array, 2, 4, 8);
        System.out.println("将数组的第2和第3个元素赋值为8：Arrays.fill(array, 2, 4, 8)：");
        printArray(array);
        int[] array1 = { 7, 8, 3, 2, 12, 6, 3, 5, 4 };
        printArray(array1);
     // 对数组的第2个到第6个进行排序进行排序
        Arrays.sort(array1, 2, 7);
        System.out.println("对数组的第2个到第6个元素进行排序进行排序：Arrays.sort(array,2,7)：");
        printArray(array1);
     // 对整个数组进行排序
        Arrays.sort(array1);
        System.out.println("对整个数组进行排序：Arrays.sort(array1)：");
        printArray(array1);
        
//        复制数组
        Arrays.copyOf(array1, 14);
        System.out.println("复制数组至长度14： Arrays.copyOf(array1, 14)");
        printArray(array1);
        
        System.out.println("复制数组的[2,5)号元素到新数组");
        printArray(Arrays.copyOfRange(array1, 2,5));
        
        // 比较数组元素是否相等
        System.out.println("比较数组元素是否相等:Arrays.equals(array, array1):" + "\n" + Arrays.equals(array, array1));
        int[] array2 = array1.clone();
        System.out.println("克隆后数组元素是否相等:Arrays.equals(array1, array2):" + "\n" + Arrays.equals(array1, array2));
        // 使用二分搜索算法查找指定元素所在的下标（必须是排序好的，否则结果不正确）
        Arrays.sort(array1);
        System.out.println("元素3在array1中的位置：Arrays.binarySearch(array1, 3)：" + "\n" + Arrays.binarySearch(array1, 3));
        // 如果不存在就返回负数
        System.out.println("元素9在array1中的位置：Arrays.binarySearch(array1, 9)：" + "\n" + Arrays.binarySearch(array1, 9));
	}
	
	// 打印所有数组元素
	public static void printArray(int[] arr) {
		for(int ele:arr) {
			System.out.print(ele+" ");
		}
		System.out.println("");
	}

}
