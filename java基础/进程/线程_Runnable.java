package 进程;


/**
 * @author ZOE
 * @date 2019/8/26 19:26
 */
////通过实现 Runnable 接口来创建线程
class RunnableDemo implements Runnable {
    private Thread t;
    private String threadName;
    RunnableDemo(String name){
        threadName=name;
        System.out.println("Creating "+threadName);
    }

    @Override
    public void run() {//一个类只需要执行一个方法调用 run()
        System.out.println("Running " +  threadName );
        try {
            for (int i = 4; i >0 ; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                Thread.sleep(50);// 让线程睡眠一会
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
            e.printStackTrace();
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }
    public  void start(){
        System.out.println("Starting " +  threadName);
        if (t==null){
            t=new Thread(this,threadName);
            t.start();
        }
    }
}

public class 线程_Runnable {
    public static void main(String[] args) {
        RunnableDemo r1=new RunnableDemo( "Thread-1");
        r1.start();
        RunnableDemo r2=new RunnableDemo( "Thread-2");
        r2.start();

    }
}
