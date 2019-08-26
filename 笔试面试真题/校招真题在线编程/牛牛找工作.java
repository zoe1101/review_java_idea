package 校招真题在线编程;

import java.util.*;

/**
为了找到自己满意的工作，牛牛收集了每种工作的难度和报酬。
牛牛选工作的标准是在难度不超过自身能力值的情况下，牛牛选择报酬最高的工作。
在牛牛选定了自己的工作后，牛牛的小伙伴们来找牛牛帮忙选工作，牛牛依然使用自己的标准来帮助小伙伴们。
牛牛的小伙伴太多了，于是他只好把这个任务交给了你。 

输入描述:
每个输入包含一个测试用例。
每个测试用例的第一行包含两个正整数，分别表示工作的数量N(N<=100000)和小伙伴的数量M(M<=100000)。
接下来的N行每行包含两个正整数，分别表示该项工作的难度Di(Di<=1000000000)和报酬Pi(Pi<=1000000000)。
接下来的一行包含M个正整数，分别表示M个小伙伴的能力值Ai(Ai<=1000000000)。
保证不存在两项工作的报酬相同。


输出描述:
对于每个小伙伴，在单独的一行输出一个正整数表示他能得到的最高报酬。一个工作可以被多个人选择。

输入例子1:
3 3 
1 100 
10 1000 
1000000000 1001 
9 10 1000000000

输出例子1:
100 
1000 
1001

 * @author zoe
 *
 */
public class 牛牛找工作 {
	/*
	将输入的工作难度和报酬按照工作难度的大小由小到大排序，
	然后遍历数组，更新到当前工作难度为止，能得到的最大的报酬，将更新完成之后的数组保存到TreeMap中，
	然后可以在map中查找最接近输入的能力的难度（<=），根据难度得到最大报酬。
	 */
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //工作数量
        int n = scanner.nextInt();
        //伙伴数量
        int m = scanner.nextInt();
        int[][] arr = new int[n][2]; //存储工作难度与报酬
        for (int i = 0; i < n ; i++) {
            int ai = scanner.nextInt();
            int sa = scanner.nextInt();
            arr[i][0] = ai;
            arr[i][1] = sa;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 1; i < n ; i++) {
            arr[i][1] = Math.max(arr[i - 1][1],arr[i][1]);
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i][0],arr[i][1]);
        }
        for (int i = 0; i < m; i++) {
            int ai = scanner.nextInt();
            Integer index = (Integer)map.floorKey(ai);
            if(index != null) System.out.println(map.get(index));
            else System.out.println(0);

        }
    }
}
