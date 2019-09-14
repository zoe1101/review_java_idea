package 锁;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ZOE
 * @date 2019/9/8 13:56
 */
public class TicketLockV2 {
    private AtomicInteger serviceNum=new AtomicInteger(); //服务号
    private AtomicInteger ticketNum=new AtomicInteger(); //排队号
//    新增一个ThreadLocal，用于存储每个线程的排队号,,防止排队号被修改
    private ThreadLocal<Integer>  ticketNumHolder=new ThreadLocal<>();
    public void lock(){
        int currentTicketNum=ticketNum.incrementAndGet();
        ticketNumHolder.set(currentTicketNum);// 获取锁的时候，将当前线程的排队号保存起来
        while (currentTicketNum!=serviceNum.get()){
            // Do nothing
        }
    }
    public void unlock(){
        // 释放锁，从ThreadLocal中获取当前线程的排队号
        Integer currentTickNum=ticketNumHolder.get();
        serviceNum.compareAndSet(currentTickNum,currentTickNum+1);
    }

}
