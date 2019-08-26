package src;

/**
 * @author ZOE
 * @date 2019/8/5 14:13
 *
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可获得的最大利润是多少？
 *
 * 例如，一只股票在某些时间节点的价格为{9,11,8,5,7,12,16,14}。
 * 如果我们能在价格为5的时候买入并在价格为16时卖出，则能获得最大的利润为11.
 */
public class 股票的最大利润 {
//    记录当前最小值和最大差值
    public static int getMaxProfit(int[] arr) {
        if (arr==null || arr.length<2){
            return  0;
        }
        int min=arr[0];
        int maxdiff=arr[1]-min;
        for (int i = 2; i <arr.length ; i++) {
            if (arr[i-1]<min){
                min=arr[i-1];
            }
            int curdiff=arr[i]-min;
            if (curdiff>maxdiff){
                maxdiff=curdiff;
            }
        }
        return  maxdiff;
    }

    public static void main(String[] args) {
        int[] arr={9,11,8,5,7,12,16,14};
        System.out.println(getMaxProfit(arr));
    }

}
