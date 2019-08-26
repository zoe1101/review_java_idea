package Math;

import org.omg.CORBA.ARG_IN;

import java.util.ArrayList;
import java.util.regex.Matcher;

/**
 * 定整数a和b，请问区间[a,b)内有多少个素数？
 * a< b<=10^12
 * b-a<=10^6
 *
 * 输入
 * 22 37
 * 输出
 * 3
 * 输入
 * 22801763489 2280178297
 * 输出
 * 1000
 *
 * @author ZOE
 * @date 2019/8/26 11:48
 */
public class 求大区间内素数的个数 {
/*
【分析】b以内的合数的最小质因数一定不超过sqrt(b)。如果有sqrt(b)以内的素数表的话，
就可以把埃式筛法运用在[a,b)上了。也就是说，先分别做好[2,sqrt(b))的表和[a,b)的表，
然后从[2,sqrt(b))的表中筛得素数的同时，也将其倍数从[a,b)的表中划去，最后剩下的就是区间[a,b)内的素数了。


使用埃拉托斯特尼筛法
基本思想：素数的倍数一定不是素数
实现方法：用一个长度为N+1的数组保存信息（0表示素数，1表示非素数），先假设所有的数都是素数（初始化为0），
从第一个素数2开始，把2的倍数都标记为非素数（置为1），一直到大于N；
然后进行下一趟，找到2后面的下一个素数3，进行同样的处理，直到最后，数组中依然为0的数即为素数。
如果n*n > 范围最大值就跳出。

 */
    //对区间[a,b)内的整数执行筛法，is_prime[i-a]=true  ---  表示i是素数 注意这里下标偏移了a，所以从0开始。
    public static int numOfPrime(int a, int b) {
        ArrayList<Integer> prime=new ArrayList<>();
        boolean[] is_prime_small=new boolean[1000005];
        boolean[] is_prime=new boolean[1000005];
        for (int i=0; i*i<b; i++){
            is_prime_small[i]=true;//对[2,sqrt(b))的初始化全为质数
        }
        for (int i=0; i<b-a; i++){
            is_prime[i]=true;//对下标偏移后的[a,b)进行初始化
        }
        for (int i = 2; i*i <b ; i++) {
            if (is_prime_small[i]){
                for (int j = 2*i; j*j <b ; j+=i) {
                    is_prime_small[j]=false;//筛选[2,sqrt(b));
                }
                for (int j = Math.max(2,(a+i-1)/i)*i; j<b ; j+=i) {//(a+i-1)/i为[a,b)区间内的第一个数至少为i的多少倍.
                    is_prime[j-a]=false;//筛[a,b)
                }
            }

        }
        for (int i=0;i<b-a;i++){
            if (is_prime[i]){
                prime.add(i+a);
                System.out.println(i+a);
            }
        }
        return prime.size();
    }

    public static void main(String[] args) {
        System.out.println(numOfPrime(0,20));
    }
}
