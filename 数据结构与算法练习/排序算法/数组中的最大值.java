/**
 * 
 */
package 排序算法;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

import javax.naming.InitialContext;
/**
 * @author zoe
 *
 */
public class 数组中的最大值 {

	/**
	 * @param args
	 */
	// 打印所有数组元素
	public static void printArray(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	//一维数组元素转置
	public static int[] reverse(int[] arr) {  //数组作为函数的返回值
		int[] result=new int[arr.length];
		for (int i=0,j=result.length-1;i<result.length;i++,j--) {
			result[j]=arr[i];
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner stdinScanner=new Scanner(System.in);
		
		int n=stdinScanner.nextInt();
		
		int[] arr=new int[n];
		
		//数组的输入
		for(int i=0;i<arr.length;i++) { 
			arr[i]=stdinScanner.nextInt();
		}
		
		
		//// 打印所有数组元素
		printArray(arr);
		
		reverse(arr);
		printArray(arr);

	}

}
