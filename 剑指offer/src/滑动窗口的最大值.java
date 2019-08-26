package src;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/*
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 *  针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 *   {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， 
 *   {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */


public class 滑动窗口的最大值 {
	
//	用双端队列实现
/*
 * 队列第一个位置保存当前窗口的最大值，当窗口滑动一次， 判断当前最大值是否
 * 过期（当前最大值的位置是不是在窗口之外），新增加的值从队尾开始比较，把所有比他小的值丢掉。
 * 时间复杂度为O(n)
 */
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
    	ArrayList<Integer> res=new ArrayList<Integer>();
    	if(num==null || num.length==0 || size<=0) {
    		return res;
    	}
    	Deque<Integer> deque=new ArrayDeque<Integer>(); //双端队列
    	int left=0;
    	for (int i = 0; i < num.length; i++) {
			left=i-size+1;
			if (deque.isEmpty()) {
				deque.offerLast(i);
			}else if (left>deque.peekFirst()) {
				deque.pollFirst();
			}
			while (!deque.isEmpty() && num[deque.peekLast()]<=num[i]) {
				deque.pollLast();
			}
			deque.offerLast(i);
			if (left>=0) {
				res.add(num[deque.peekFirst()]);
			}
		}
    	return res;
    }
    
    public ArrayList<Integer> maxInWindows2(int [] num, int size){
        ArrayList<Integer> res = new ArrayList<Integer>();
        Deque<Integer> deque = new LinkedList<Integer>();
        if(num==null || num.length == 0 || size <= 0)
            return res;
        
        for(int i = 0; i < num.length; i++){ 
        	//队头存当前窗口的最大值
            if(!deque.isEmpty() && deque.peekFirst() <= i - size)
                deque.poll();
            while(!deque.isEmpty() && num[deque.peekLast()] < num[i])
                deque.removeLast();
            deque.offerLast(i);
            if(i + 1 >= size)
                res.add(num[deque.peekFirst()]);
        }
        return res;
    }
}
