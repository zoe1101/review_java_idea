package 顺丰20190829;

import java.util.Scanner;
import java.util.regex.Matcher;

/**
 * @author ZOE
 * @date 2019/8/29 19:31
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            System.out.println(process(arr));
        }


    }

    public static int process(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int maxCount = 0;
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                maxCount=Math.max(dp[i],maxCount);
            }
        }
        return maxCount;
    }

}