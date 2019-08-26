package 华为20190821;

import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 给你一个区间，求出这个区间内的所有素数十位数和，个位数和之间的较小值。
 * @author ZOE
 * @date 2019/8/21 19:30
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()) {
            int low = scanner.nextInt();
            int high = scanner.nextInt();
            boolean flag = true; //是否为素数
            ArrayList<Integer> list = new ArrayList<>();
            for (int value = low; value < high; value++) {
                flag = true;
                for (int i = 2; i < value; i++) { //判断i是不是素数
                    if (value % i == 0) {
                        flag = false;
                    }
                }
                if (flag == true) {
                    list.add(value);
                }
            }

            int firstNumSum = 0;  //个位和
            int secondNumSum = 0; //十位和
            for (int i = 0; i < list.size(); i++) {
                firstNumSum += list.get(i) % 10;
                secondNumSum += list.get(i) >= 10 ? (list.get(i) / 10 % 10) : 0;
            }
            System.out.println(firstNumSum < secondNumSum ? firstNumSum : secondNumSum);
        }
    }
}
