package src;
import java.util.Arrays;
/**
 * @author ZOE
 * @date 2019/8/8 18:51
 */

//须保证原有元素的相对顺序
public class 调整数组顺序使奇数位于偶数前面_有序 {

    //类似插入排序 的方法
    public static int[] reOrderArray(int [] array) {
        if (array==null || array.length<2){
            return array;
        }
        for (int i = 0; i <array.length ; i++) {
            int temp=array[i];
            if (temp%2==1){ //奇数，需要调整到i之前
                int j;
                for (j = i-1; j>=0;j--) {
                    if (array[j]%2==0){ //偶数后移
                        array[j+1]=array[j];
                    }else{//碰到第一个奇数，退出
                        break;
                    }
                }
                array[j+1]=temp; //交换array[i]与array[j+1],找到第一个非偶数的位置，进行奇偶交换
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(reOrderArray(arr)));
    }

}
