package src;
/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *  NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @author zoe
 *
 */
public class 旋转数组的最小数字 {
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0) {
        	return 0;
        }
        int left=0;
        int right=array.length-1;
    	if(left==right) {
    		return array[left];
    	}
    	while (left<right) {
			int mid=(left+right)/2;
			
			if(array[mid]>array[right]) { //3,4,5,1,2    最小数字一定在mid的右边
				left=mid+1;
			}else if (array[mid]<array[right]) {//1,2,3,4,5   最小数字一定在mid的左边
				right=mid;
			}else { //array[mid]==array[right]  类似 [1,0,1,1,1] 或者[1,1,1,0,1]
//				此时最小数字不好判断在mid左边 还是右边,这时只好一个一个试 ， 
				right=right-1;
			}
		}
    	return array[left];
    }

}
