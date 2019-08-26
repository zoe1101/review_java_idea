package 进程;

/**
 * @author ZOE
 * @date 2019/8/26 20:23
 */
class ThreadDemo extends Thread{
    private Thread t;
    private String  threadName;
    ThreadDemo(String name){
        threadName=name;
        System.out.println("Creating " +  threadName );
    }

    @Override
    public void run() {
        System.out.println("Running " +  threadName );
        try {
            for (int i = 4; i >0 ; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
            e.printStackTrace();
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}
public class 线程_Thread {
    public static void main(String[] args) {
        ThreadDemo t1=new ThreadDemo("Thread-1");
        t1.start();
        ThreadDemo t2=new ThreadDemo("Thread-2");
        t2.start();
    }
}
