/**
 * 长度为n的数组乱序存放着0至n-1，现在只能进行0与其他数的交换，完成以下函数。
 * @author ZOE
 * @date 2019/8/21 10:52
 */
public class 零交换排序 {
//    循环交换。先将0与处于i位置的数字进行交换，即swapWithZero(array, len, array[i])；
//    此时0处于i位置，然后交换0与数字i，即可让数字i归位到i位置。
    public void sort(int[] array, int len) {
        if (len<2){
            return;
        }
        for (int i = len-1; i>0; i--) {
            if (array[i]==i){//判断是否处于正确位置
                continue;
            }
            //对未处于正确位置的数字进行下面两步交换
            swapWithZero(array, len, array[i]);////把i位置上的数和0交换,此时array[i]=0
            swapWithZero(array, len, i);//交换0与数字i

        }

    }
    private static void swapWithZero(int[] arr, int len, int n) {
        int zIndex = -1;
        int nIndex = -1;
        //循环遍历找到0和数字n所在的位置
        for (int i = 0; i < len; i++) {
            if (arr[i] == 0) {
                zIndex = i;
            }
            if (arr[i] == n) {
                nIndex = i;
            }
        }
        //交换位置
        int tmp = arr[zIndex];
        arr[zIndex] = arr[nIndex];
        arr[nIndex] = tmp;
    }

}
