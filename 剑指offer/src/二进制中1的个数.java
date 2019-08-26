package src;
/*
 *输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
//考察位运算

//1）判断输入的数是否大于1，即：为真。 
//2）判断该数的二进制数的最右边的数是否为1，为1则计1，否则向右移。 
//3）再重复步骤2，直到整个整数为1为止。
public class 二进制中1的个数 {
	
    public int NumberOf1(int n) {
    	int count=0;
    	int flag=1; 
    	if(flag!=0){
    		if((n&flag)==1) {
    			count++;
    		}else {
    			flag=flag<<1; // 为了避免死循环的发生,对1进行左移
    		}
    	}
    	return count;
    }
    
//优化思路：
//把一个整数减去1，再和原来整数做与运算，会把该整数最右边一个1变成0,。
//那么一个整数的二进制表示中有多少个1，就可以进行多少次这样的操作。
    
    public int NumberOf11(int n) {
    	int count=0;
    	if(n!=0){
			count++;
			n=(n-1)&n;
    	}
    	return count;
    }
}
