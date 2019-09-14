package src;

/**
 * @author ZOE
 * @date 2019/9/14 9:41
 */
public class 不修改数组找出重复的数字 {
    //利用二分查找 实现
    public int getDuplication(int[] numbers){
        if (numbers==null || numbers.length<=1 ){
            return -1;
        }
        int start=0;
        int end=numbers.length-1;
        while (start<=end){
            int mid=start+(end-start)>>1;
            int count=countRange(numbers,start,mid);
            if (start==end){
                if (count>1){
                    return start;
                }else {
                    break;
                }
            }
            if (count>(mid-start+1)){ //重复数字在mid左边
                end=mid;
            }else { //重复数字在mid右边
                start=mid+1;
            }
        }
        return -1;
    }
 //统计在【start，end】区间内的数字数目
    private int countRange(int[] numbers, int start, int end) {
        if (numbers==null || numbers.length==0){
            return 0;
        }
        int count=0;
        for (int i = 0; i <numbers.length ; i++) {
            if (numbers[i]>=start && numbers[i]<=end){
                count++;
            }
        }
        return count;
    }

}
