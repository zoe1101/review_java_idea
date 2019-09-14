package 查找算法;

/**
 * @author ZOE
 * @date 2019/9/14 11:27
 */
public class 查找指定元素 {
    public static int bisearch(int[] arr,int target) {
        int left=0;
        int right=arr.length-1;
        while(left<=right) {
            int mid=left+(right-left)/2;  //为了防止数值溢出
            if(target==arr[mid]) {
                return mid;
            }else if(target<arr[mid]) { //在mid的左边
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return -1;
    }

}
