package 顺丰20190829;

import sun.security.krb5.SCDynamicStoreConfig;

import java.rmi.UnexpectedException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * @author ZOE
 * @date 2019/8/29 20:50
 */
public class Main11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();  //人数
            int m = scanner.nextInt();  //语言数
            int k = scanner.nextInt(); //已知信息数
            Map<Integer,Integer> map=new HashMap<>();
            HashSet<Integer> set=new HashSet<>();
            if (k == 0) {
                System.out.println(n);
                continue;
            }
            for (int i = 0; i < k; i++) {
                map.put(scanner.nextInt(),scanner.nextInt());
            }
        }
    }
}
