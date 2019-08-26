import java.util.Scanner;

/**
 * @author ZOE
 * @date 2019/8/21 16:41
 */
public class 求最小公倍数 {
//    最小公倍数 = 两数之积除以最大公约数
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()){
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        System.out.println(a*b/gcd(a,b));
    }
}
//最大公约数：辗转相除法
    private static int gcd(int a, int b) {
        if (b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}
