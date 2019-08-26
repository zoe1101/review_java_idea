package src;
/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @author zoe
 *
 */
public class 数值的整数次方 {
//	需要考虑的问题：数值是0、指数是负数、算法复杂度
    public double Power(double base, int exponent) {
    	if(exponent==0) {
    		return 1;
    	}
    	if (exponent==1) {
			return base;
		}
    	if(exponent>1) {
    		double res=Power(base, exponent>>1);
    		res=res*res;
    		if((exponent&1)==1) {
    			res=res*base;
    		}
    		return res;
    	}
    	if(exponent<0) { //指数为负时
    		exponent=-exponent;
    		double res=Power(base, exponent);
    		return 1/res;
    	}
    	return -1;

    }
}
