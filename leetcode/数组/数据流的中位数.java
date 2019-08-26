package 数组;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

/*
中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
例如，
[2,3,4] 的中位数是 3
[2,3] 的中位数是 (2 + 3) / 2 = 2.5
设计一个支持以下两种操作的数据结构：
void addNum(int num) - 从数据流中添加一个整数到数据结构中。
double findMedian() - 返回目前所有元素的中位数。
示例：

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
 */
public class 数据流的中位数 {
	/*
维护一个大顶堆 maxHeap，一个小顶堆 minHeap。
maxHeap 保存 <= median 的数，_minHeap 保存 > median 的数。
在 addNum 的过程中，维护性质 0 <= maxHeap.size() - minHeap.size() <= 1 即可。
	 */
	private PriorityQueue<Integer> minHeap;
	private PriorityQueue<Integer> maxHeap;
	public 数据流的中位数() {
	    minHeap = new PriorityQueue<>();
	    maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
	        @Override
	        public int compare(Integer i, Integer j) {
	            return j.compareTo(i);
	        }
	    });
    }
    
    public void addNum(int num) {
    	int size = minHeap.size() + maxHeap.size();
    	if ((size & 1) == 0) { //数组元素个数为偶数
    		if (!minHeap.isEmpty() && num > minHeap.peek()) {
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
    	}else { //数组元素个数为奇数
            if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        }
    }
    
    public double findMedian() {
    	int size = minHeap.size() + maxHeap.size();
        if ((size & 1) == 0) //数组元素个数为偶数
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        return maxHeap.peek();
    }
}
