package 锁;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author ZOE
 * @date 2019/9/8 11:03
 */
public class 自旋锁 {
    private AtomicReference<Thread> cas=new AtomicReference<Thread>();
    //加锁
    public void lock(){
        Thread current=Thread.currentThread();
        // 利用CAS
        while (!cas.compareAndSet(null,current)){
            // DO nothing
        }
    }

    //解锁
    public void unlock(){
        Thread current=Thread.currentThread();
        cas.compareAndSet(current,null);
    }
}
