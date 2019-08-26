package 数组;

import java.util.regex.Matcher;

/**
 * 给定数组中的元素可以重复，输入数组最大长度为2000，其中的元素最大为10**8。
 * arr是一个可能包含重复元素的整数数组，我们将这个数组分割成几个“块”，并将这些块分别进行排序。
 * 之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
 *
 * 我们最多能将数组分成多少块？
 *
 * 输入: arr = [5,4,3,2,1]
 * 输出: 1
 * 解释:
 * 将数组分成2块或者更多块，都无法得到所需的结果。
 * 例如，分成 [5, 4], [3, 2, 1] 的结果是 [4, 5, 1, 2, 3]，这不是有序的数组。
 *
 * @author ZOE
 * @date 2019/8/24 21:50
 */
public class 最多能完成排序的块II {
//    寻找[index + 1, arrSize - 1]这一段是否都比[0, index]这一段的值大，
//    即[0, index]的最大值 < [index + 1, arrSize - 1]最小值注意区间的闭合情况！！！
    public int maxChunksToSorted(int[] arr) {
        int n=arr.length;
        int count=1;
        //leftMax[index]用于记录[0, index]的最大值
        //rightMin[index]用于记录[index + 1, arrSize - 1]的最小值
        int[] leftMax=new int[n];
        int[] rightMin=new int[n];
        leftMax[0]=arr[0];
        rightMin[n-1]=Integer.MAX_VALUE;
        //第一步：从左到右扫描，递推寻找[0, index]的最大值
        for (int i = 1; i <n ; i++) {
            leftMax[i]=Math.max(arr[i],leftMax[i-1]);
        }
        //第二步：从右到左扫描，递推寻找[index + 1, arrSize - 1]的最小值
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(arr[i + 1], rightMin[i + 1]);
        }
        for (int i = 0; i <n ; i++) {
            if (leftMax[i]<=rightMin[i]){
                count++;
            }
        }
        return count;

    }
}
