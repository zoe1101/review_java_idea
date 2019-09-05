package 进程;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author ZOE
 * @date 2019/8/28 10:13
 */

//不用lambda表达式，就是这样，先创建一个callable的实现类。
class CallableTest implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int i=0;
        for (; i<4 ; i++) {
            //当前线程
            System.out.println("当前线程是：：："+Thread.currentThread() +":"+i);
        }
        return i;
    }
}

public class 线程_Callable {
    public static void main(String[] args) {
        CallableTest call=new CallableTest();
        FutureTask<Integer> futureTask=new FutureTask<Integer>(call);
        Thread th=new Thread(futureTask,"我是futureTask线程");
        for (int i = 0; i < 3; i++) {
            //当前线程
            System.out.println(Thread.currentThread().getName()+"当前线程");
            if(i==0){
                th.start();

            }
        }
        try{
            System.out.println("返回值是:" + futureTask.get());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
