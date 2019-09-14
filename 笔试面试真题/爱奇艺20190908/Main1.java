package 爱奇艺20190908;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author ZOE
 * @date 2019/9/8 14:26
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int[] a=new int[n-1];
            for (int i = 0; i <n-1 ; i++) {
                a[i]=scanner.nextInt();
            }

            int count=0;

            int[] b=new int[n];

            for (int i = 0; i <n; i++) {
                b[i]=i+1;
            }
            List<List<Integer>> lists=permute(b);
            for (List<Integer> list:lists) {
                boolean flag=true;
                for (int i = 0; i <n-1 ; i++) {
                    if (a[i]==0 && list.get(i)>=list.get(i+1)){
                        flag=false;
                    }
                    if (a[i]==1 && list.get(i)<=list.get(i+1)){
                        flag=false;
                    }
                }
                if (flag){
                    count++;
                }
            }

            System.out.println(count);

        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        backtrack(res, nums, new ArrayList<Integer>(), visited);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            tmp.add(nums[i]);
            backtrack(res, nums, tmp, visited);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }
}
