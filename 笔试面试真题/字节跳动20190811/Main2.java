package 字节跳动20190811;

import com.sun.org.apache.xpath.internal.objects.XString;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ZOE
 * @date 2019/8/11 19:24
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
//        int n=scanner.nextInt(); //明文字符串的长度
//        int k=scanner.nextInt(); //需要向右移位k次
//        String S=scanner.next();
        int n=7;
        int k=4;
        String S="1110100110";
        int[] Sarr=new int[n+k-1];
        for (int i=0;i<S.length();i++){
            Sarr[i]=S.charAt(i)-'0';
        }
        int[] res=new int[n];
        res[0]=Sarr[0];
        for (int i=1;i<n;i++) {
            if (i<k) {
                if ((Sarr[i - 1] ^ 0) == Sarr[i]) {
                    res[i] = 0;
                } else {
                    res[i] = 1;
                }
            }else {
                for (int j = i - k; j < i - k + 4; j++) {
                    res[i] = res[i] ^ res[j];
                }
                if ((res[i] ^ 0) == Sarr[i]) {
                    res[i] = 0;
                } else {
                    res[i] = 1;
                }
            }
        }

        System.out.println(Arrays.toString(res));


    }
}
