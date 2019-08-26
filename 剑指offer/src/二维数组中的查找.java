package src;
/*
在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。　　
 */

//解题思路: 从右上角开始查起
public class 二维数组中的查找 {
    public static boolean Find(int target, int [][] array) {
    	if(array.length==0 || array[0].length==0 || array==null) {
    		return false;
    	}
    	int m=0,n=array[0].length-1;
    	while(m<array.length && n>=0) {
    		if(array[m][n]==target) { //右上角元素等于目标值
    			return true;
    		}else if(array[m][n]>target) { //右上角>key,删除一列，看左侧
    			n--; 
    		}else { //删除上面的行，看下面的行
    			m++;
    		}
    	}
    	return false;
    }
	public static void main(String[] args) {
	    int[][] arr= {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
	    System.out.println(Find(7,arr));

	}
    
}
