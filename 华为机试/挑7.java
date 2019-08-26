import java.util.Scanner;
/**
 * 出7有关数字的个数，包括7的倍数，还有包含7的数字（如17，27，37...70，71，72，73...）的个数
 * （一组测试用例里可能有多组数据，请注意处理）
 *
 * 输入描述:
 * 一个正整数N。(N不大于30000)
 *
 * 输出描述:
 * 不大于N的与7有关的数字个数，例如输入20，与7有关的数字包括7,14,17.
 *
 * 示例1
 * 输入
 * 20
 * 输出
 * 3
 * @author ZOE
 * @date 2019/8/21 18:43
 */
public class 挑7 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int cnt = 0;
            for(int i=1; i<=n; i++) {
                if(i%7 == 0) {
                    cnt++;
                    continue;
                }
                if(String.valueOf(i).contains("7")) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
