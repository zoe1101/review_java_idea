import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ZOE
 * @date 2019/8/21 14:48
 */
public class 素数伴侣 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int[] arr=new int[n];
            for (int i = 0; i <n ; i++) {
                arr[i]=scanner.nextInt();
            }
            System.out.println(getBestPairsNum(arr, n));
        }
    }
/*
 *素数绝对不是偶数；
 * 奇数加奇数一定是偶数，和一定不是素数，两个奇数不是素数伴侣；
 * 偶数加偶数一定是偶数，和一定不是素数，两个偶数不是素数伴侣；
 * 我们可以先处理一下原始数据：把偶数个数据按奇偶分成两分，素数伴侣只有可能从一边取一个得到。
 * 这样就变成了二分图最大匹配问题了。
 * 注意：分成两个，两个部分的大小并不是原来的一半，这是由于数据并没有保证奇数偶数个数一样多。
 *
 *
 * 匈牙利算法。
 */
    private static int getBestPairsNum(int[] arr, int n) {
        if (arr==null || n==0 || n%2!=0){
            return 0;
        }
        ArrayList<Integer> evens = new ArrayList<>();// 偶数部分
        ArrayList<Integer> odds = new ArrayList<>();// 奇数部分
        for (int i=0;i<n;i++){
            if (arr[i]%2==0){ // 偶数
                evens.add(arr[i]);
            }else {// 奇数
                odds.add(arr[i]);
            }
        }
        int[] evenMatch=new int[evens.size()];
        int res=0;
        for (int i = 0; i <odds.size() ; i++) {
            int[] used=new int[evens.size()];
            if (find(odds.get(i),evens,odds,used,evenMatch)){
                res++;
            }
        }
        return res;

    }
//    得到从偶数集合和奇数集合各抽取一个数字组成素数的最大组合数
    private static boolean find(int x, ArrayList<Integer> evens, ArrayList<Integer> odds, int[] used,int[] evenMatch) {
        for (int j=0; j<evens.size(); j++) {
            if (isPrime(x+evens.get(j)) && used[j]==0){
                used[j] = 1;
                if (evenMatch[j]==0 || find(evenMatch[j],evens,odds,used,evenMatch)){
                    evenMatch[j]=x;
                    return true;
                }
            }
        }
        return false;
    }

// 判断是否为素数
    private static boolean isPrime(int n) {
        int count = (int) Math.sqrt(n);
        while (count > 1) {
            if (n % count == 0 ) {
                return false;
            }
            count--;
        }
        return true;
    }
}
