package 校招真题在线编程;

/**
 * 假设你正在玩跳格子（所有格子排成一个纵列）游戏。需要 跳完n 个格子你才能抵达终点。
 * 每次你可以跳 1 或 2 个格子。你有多少种不同的方法可以到达终点呢？
 * 注意：给定 n 是一个正整数。
 *
 * 输入描述:
 * 格子数n
 *
 * 输出描述:
 * 跳完n个格子到达终点的方法
 *
 * 输入例子1:
 * 2
 *
 * 输出例子1:
 * 2
 * @author ZOE
 * @date 2019/9/6 14:34
 */
import java.util.Scanner;
//斐波那契，dp来做，可以状态压缩
public class 招银_跳格子游戏 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f1 = 1, f2 = 1;
        int temp = 0;
        for (int i = 2; i <=n; i++) {
               temp = f1 + f2;
               f1 = f2;
               f2 = temp;
           }
        System.out.println(f2);
    }
}
