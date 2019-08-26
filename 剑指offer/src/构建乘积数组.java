package src;
/*
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 */
public class 构建乘积数组 {
//	利用上三角和下三角进行计算。
	/*这道题的中心思想是将返回的数据列成一个矩阵，每一个矩阵的行向量都是一个从a(0)到a(n-1)
    ,然后这个对角线都是1.那么此时B0的值就是A0为一，剩下的行向量相乘。
  */
    public int[] multiply(int[] A) {
    	int[] B=new int[A.length];
    	B[0]=1;
    	for(int i=1;i<A.length;i++) { //从上到下进行下三角计算
    		B[i]=B[i-1]*A[i-1];
    	}
    	int temp=1;
    	for (int i = A.length-2; i>=0; i--) {//从下到上进行上三角计算
			temp*=A[i+1];
			B[i]*=temp;
		}
    	return B;
    }
}
