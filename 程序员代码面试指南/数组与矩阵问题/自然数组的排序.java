package 数组与矩阵问题;

public class 自然数组的排序 {
	//方法1:运用跳着换值的思想
	public static void sort1(int[] arr) {
		int tmp=0;
		int next=0;
		for (int i = 0; i < arr.length; i++) {
			tmp=arr[i];
			while (arr[i]!=i+1) { //当前位置的值不对
				next=arr[tmp-1]; //记录arr[tmp-1]位置的值
				arr[tmp-1]=tmp;  //将当前位置的值应该是arr[tmp-1]位置的值
				tmp=next;
			}
			
		}
	}
	//方法2：利用交换思想
	public static void sort2(int[] arr) {
		int tmp=0;
		for (int i = 0; i < arr.length; i++) {
			while (arr[i]!=i+1) {
				tmp=arr[arr[i]-1];
				arr[arr[i]-1]=arr[i];
				arr[i]=tmp;
			}
		}
	}
	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 8, 2, 1, 6, 9, 3, 7, 5, 4 };
		sort1(arr);
		printArray(arr);
		System.out.println("================");
		arr = new int[] { 8, 2, 1, 6, 9, 3, 7, 5, 4 };
		sort2(arr);
		printArray(arr);

	}

}
