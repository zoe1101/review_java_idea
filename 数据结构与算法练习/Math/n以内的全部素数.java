package Math;

/**
 * @author ZOE
 * @date 2019/8/26 13:35
 */
public class n以内的全部素数 {
    //素数的个数，也是b的下标
    private static int count=0;

    public static void numOfPrime(int n) {
        long[] a=new long[n+1];
        long[] b=new long[n+1];
        for (long i = 2; i <=n ; i++) {
            if (a[(int)i]!=0){
                continue;
            }else {
                b[count++]=i;
                for (long j = i; j*i <=n ; j++) {
                    a[(int)(i*j)]=1;
                }
            }
        }
        for (int i = 0; i < count; i++) {
            System.out.println(b[i]);
        }
    }

    public static void main(String[] args) {
        numOfPrime(20);
    }


}
