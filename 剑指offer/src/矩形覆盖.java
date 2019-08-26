package src;
/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @author zoe
 *
 */
public class 矩形覆盖 {
	/**
	 * 分治法
	 * 如果第一步竖着填充，那么该问题的规模就缩减为对于剩余的2×（number-1）的大矩形的填充。
	 * 如果第一步横着填充，则第二排的前面两个小矩形也只能如此填充，那么该问题的规模就缩减为对于剩余的2×（number-2）的大矩形的填充.
	 * 当n大于2时，rectCover(number)=rectCover(number-1)+rectCover(number-2)
	 * 其实是一个斐波那契序列
	 * @param target
	 * @return
	 */
    public int RectCover(int target) {
    	if(target<=0) {
    		return 0;
    	}else if(target==1 || target==2) {
    		return target;
    	}else {
    		return RectCover(target-1)+RectCover(target-2);
		}
    }

}
