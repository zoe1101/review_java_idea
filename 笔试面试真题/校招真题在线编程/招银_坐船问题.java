package 校招真题在线编程;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 公司组织团建活动，到某漂流圣地漂流，现有如下情况：
 * 员工各自体重不一，第 i 个人的体重为 people[i]，每艘漂流船可以承载的最大重量为 limit。
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * 为节省开支，麻烦帮忙计算出载到每一个人所需的最小船只数(保证每个人都能被船载)。
 *
 * 输入描述:
 * 第一行输入参与漂流的人员对应的体重数组，
 * 第二行输入漂流船承载的最大重量

 * 输出描述:
 * 所需最小船只数
 * 示例1
 * 输入
 * 1 2
 * 3
 * 输出
 * 1
 * @author ZOE
 * @date 2019/9/6 14:15
 */
public class 招银_坐船问题 {
//    给一个很简单的思路吧：把体重先排序并默认一个人一条船；从最轻的人开始，找一个剩下最重的人拼船，
//    找到了船就减一，没找到那后面更重的人也不可能找到了伙伴了直接break；
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int[] weights=new int[n];
            for (int i = 0; i < n; i++) {
                weights[i]=scanner.nextInt();
            }
            int maxLoad=scanner.nextInt();
            Arrays.sort(weights);
            int count=0;
            int i=0;
            int j=weights.length-1;
            while (i<j){
                if (weights[i]+weights[j]<=maxLoad){
                    i++;
                    j--;
                }else {
                    j--;
                }
                count++;
            }
            System.out.println(count+(j==i?1:0));
        }
    }
}
