package 锁;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author ZOE
 * @date 2019/9/8 13:45
 */
/*
CLH锁是一种基于链表的可扩展、高性能、公平的自旋锁，申请线程只在本地变量上自旋，
它不断轮询前驱的状态，如果发现前驱释放了锁就结束自旋，获得锁。
 */
public class CLHLock {
    public static class  CLHNode{//定义一个节点，默认的lock状态为true
        private volatile boolean isLocked=true;
    }
    private volatile CLHNode tail;//尾部节点,只用一个节点即可
    private static final ThreadLocal<CLHNode> local= new ThreadLocal<>();

    private static final AtomicReferenceFieldUpdater<CLHLock,CLHNode> updater= AtomicReferenceFieldUpdater.newUpdater(CLHLock.class,CLHNode.class,"tail");
    public void lock(){
        // 新建节点并将节点与当前线程保存起来
        CLHNode node=new CLHNode();
        local.set(node);
        // 将新建的节点设置为尾部节点，并返回旧的节点（原子操作），这里旧的节点实际上就是当前节
        CLHNode prenode=updater.getAndSet(this,node);
        if (prenode!=null){
            // 前驱节点不为null表示当锁被其他线程占用，通过不断轮询判断前驱节点的锁标志位等待前驱节点释放锁
            while (prenode.isLocked){
            }
            prenode=null;
            local.set(node);
        }
        // 如果不存在前驱节点，表示该锁没有被其他线程占用，则当前线程获得锁
    }
    public void unlock(){
        // 获取当前线程对应的节点
        CLHNode node=local.get();
        // 如果tail节点等于node，则将tail节点更新为null，同时将node的lock状态职位false，表示当前线程释放了锁
        if (updater.compareAndSet(this,node,null)){
            node.isLocked=false;
        }
        node=null;
    }


}
