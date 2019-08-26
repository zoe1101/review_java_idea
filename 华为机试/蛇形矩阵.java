import java.util.Scanner;

/**
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 *
 * 输入描述:
 * 输入正整数N（N不大于100）
 *
 * 输出描述:
 * 输出一个N行的蛇形矩阵。
 *
 * 示例1
 * 输入
 * 4
 *
 * 输出
 * 1 3 6 10
 * 2 5 9
 * 4 8
 * 7
 *
 * @author ZOE
 * @date 2019/8/21 16:10
 */
public class 蛇形矩阵 {
    /*
找规律：
每一行第一个：
行1第一个数必定为1；
行1和行2第一个数，差值为1；
行2和行3第一个数，差值为2；
行3和行4第一个数，差值为3；
所以有：
1 ...
2 ...
4 ...
7 ...
11 ...

每一行自己行内：
第一行两数字间差值分别为: 2, 3, 4, 5, 6..... (由2开始，差值为1的递增)
第二行两数字间差值分别为: 3, 4, 5, 6..... (由3开始，差值为1的递增)
第三行两数字间差值分别为: 4, 5, 6..... (由4开始，差值为1的递增)

同时我们可以看到：
每一行之间的初始差值从2开始也是以差值为1来递增；
     */
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt(); //n行
            int start =1; //打头数字
            int diff=2; //初始差值
            int pre=0; //前一行的开头的数字
            for (int i =0; i <n ; i++) { //行遍历
                start+=i;
                System.out.print(start+" ");
                pre=start;
                for (int j = 0; j <n-i-1 ; j++) { //第i行的遍历
                    System.out.print(pre+diff+j+" "); //diff+j:差值是递增的
                    pre=pre+diff+j;
                }
                diff++; //每行的初始差值是递增的
                System.out.println();
            }
        }
    }
}
