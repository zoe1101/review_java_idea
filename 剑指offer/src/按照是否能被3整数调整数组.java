package src;
import java.util.Arrays;
/**
 * 能被3整除的放前面，不能被3整除的放后面
 * @author ZOE
 * @date 2019/8/8 18:55
 */
public class 按照是否能被3整数调整数组 {
    public static int[] reOrderArray(int [] array) {
        if (array==null || array.length<2){
            return array;
        }
        int left=0;
        int right=array.length-1;
        while (left<right){
            while (left<right && array[left]%3==0){
                left++;
            }
            while (left<right && array[right]%3!=0){
                right--;
            }
            if (left<right){
                int temp=array[left];
                array[left]=array[right];
                array[right]=temp;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9,10,11};
        System.out.println(Arrays.toString(reOrderArray(arr)));
    }

}
