package src;
/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。 
 * 习惯上我们把1当做是第一个丑数。
 * 求按从小到大的顺序的第N个丑数。
 * @author zoe
 *
 *丑数可以由另外一个丑数乘以2，3或者5得到。
 */
public class 丑数 {
	//时间复杂度过高,不满足要求
   public int GetUglyNumber_Solution(int index) {
	   if(index<=0) {
		   return 0;
	   }
	   int n=0;
       int uglyCount=0;
       while (uglyCount<index) {
    	   n++;
    	   if(isUgly(n)) {
    		   uglyCount++;
    	   }
       }
       return n;
    }
   
   
   public int GetUglyNumber_Solution2(int index) {
	   if(index<=0) {
		   return 0;
	   }
	   //创建一个数组,里面的数字是排好序的丑数,每一个丑数都是前面的丑数乘以2,3或者5得到的。
	   int[] uglyNumbers = new int[index];
	   uglyNumbers[0] = 1;
       int nextUglyIndex = 1;
       int multiply2 = 0;
       int multiply3 = 0;
       int multiply5 = 0;
       int min = 0;
       /*
	       把得到的第一个丑数乘以2以后得到的大于M的结果记为M2。
	       同样，我们把已有的每一个丑数乘以3和5，能得到第一个大于M的结果M3和M5。
	       那么M后面的那一个丑数应该是M2,M3和M5当中的最小值：Min(M2,M3,M5)。
	       比如将丑数数组中的数字按从小到大乘以2，直到得到第一个大于M的数为止，
	       那么应该是2*2=4<M，3*2=6>M，所以M2=6。
	       同理，M3=6，M5=10。所以下一个丑数应该是6。
       */
       while (nextUglyIndex<index) {
    	   //M2/M3/M5这三个数的最小者
    	   min=MininThreeNum(
    			   uglyNumbers[multiply2]*2, 
    			   uglyNumbers[multiply3]*3, 
    			   uglyNumbers[multiply5]*5);
    	   uglyNumbers[nextUglyIndex]=min;
    	   while (uglyNumbers[multiply2] * 2 <= uglyNumbers[nextUglyIndex]){
               multiply2++;
           }
    	   while (uglyNumbers[multiply3] * 3 <= uglyNumbers[nextUglyIndex]){
               multiply3++;
           }

           while (uglyNumbers[multiply5] * 5 <= uglyNumbers[nextUglyIndex]){
               multiply5++;
           }
           nextUglyIndex++;
           }
       int result = uglyNumbers[index - 1];
       return result;
   }
   //三个数中的最小值
   public int MininThreeNum(int num1, int num2, int num3)
   {
       int min = num1 < num2 ? num1 : num2;
       min = min < num3 ? min : num3;

       return min;
   }
   
   /*
Step1.如果一个数能够被2整除，那么让他继续除以2；
Step2.如果一个数能够被3整除，那么让他继续除以3；
Step3.如果一个数能够被5整除，那么让他继续除以5；
Step4.如果最后这个数变为1，那么这个数就是丑数，否则不是。
    */
	public boolean isUgly(int n) {
		 while (n%2==0) {
			   n/=2;
		 }
		 while (n%3==0) {
			n/=3;
		 }
		 while (n%5==0) {
			n/=5;
		 }
		 return n==1;
		
	}		
}
