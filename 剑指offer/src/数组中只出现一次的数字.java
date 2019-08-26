package src;
/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 * @author zoe
 *
 */
public class 数组中只出现一次的数字 {
	//num1,num2分别为长度为1的数组。传出参数
	//将num1[0],num2[0]设置为返回结果
	//先找到第一个只出现一次的数字，然后把数组切分两部分
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null ||array.length==0) {
        	return;
        }
        if(array.length<2) {
        	num1[0]=0;
        	num2[0]=0;
        	return;
        }
        int temp=array[0];
        for (int i = 1; i < array.length; i++) {
			temp=temp^array[i];
		}
        int firstBit =0;
        while ((temp&1)==0 && firstBit<32) {//找到第一个只出现一次的数字所在的位置
			firstBit++;
			temp=temp>>1;
		}
    	num1[0]=0;
    	num2[0]=0;
    	for (int i = 0; i < array.length; i++) {
			if(isBit(array[i], firstBit)) {
				num1[0]=num1[0]^array[i];
			}else {
				num2[0]=num2[0]^array[i];
			}
			
		}
    }
    public boolean isBit(int num, int indexBit) {
		num = num >> indexBit;
		return (num & 1) == 1;
	}
}
