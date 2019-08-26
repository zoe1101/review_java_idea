package src;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
import java.util.PriorityQueue;
public class 数据流中的中位数 {
	
//	一：使用ArrayList即可
	ArrayList<Integer> res = new ArrayList<>();
    public void Insert(Integer num) {
        res.add(num);
        Collections.sort(res);
    }
    public Double GetMedian() {
        int n = res.size();
        if (n % 2 == 0) {
            return Double.valueOf((res.get(n / 2) + res.get(n / 2 - 1)) / 2.0);
        } else {
            return Double.valueOf(res.get(n / 2));
        }
    }

//  解法二：使用大顶堆和小顶堆的特性
    private int count = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
    });
    
    public void Insert2(Integer num) {
        if (count %2 == 0) {//当数据总数为偶数时，新加入的元素，应当进入小根堆
            //（注意不是直接进入小根堆，而是经大根堆筛选后取大根堆中最大元素进入小根堆）
            //1.新加入的元素先入到大根堆，由大根堆筛选出堆中最大的元素
            maxHeap.offer(num);
            int filteredMaxNum = maxHeap.poll();
             //2.筛选后的【大根堆中的最大元素】进入小根堆
             minHeap.offer(filteredMaxNum);
        } else {//当数据总数为奇数时，新加入的元素，应当进入大根堆
            //（注意不是直接进入大根堆，而是经小根堆筛选后取小根堆中最大元素进入大根堆）
            //1.新加入的元素先入到小根堆，由小根堆筛选出堆中最小的元素
            minHeap.offer(num);
            int filteredMinNum = minHeap.poll();
             //2.筛选后的【小根堆中的最小元素】进入大根堆
             maxHeap.offer(filteredMinNum);
        }
        count++;
    }
    public Double GetMedian2() {
        if (count %2 == 0) {
            return new Double((minHeap.peek() + maxHeap.peek())) / 2;
         } else {
            return new Double(minHeap.peek());
        }
    }


}
