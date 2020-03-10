package thread;

import java.util.concurrent.*;

/**
 * @ Author: Mr.Li
 * @ Date: 2020-02-14 23:51
 * @ Description: TODO
 **/
public class MyThread2 implements Callable<String> {


    @Override
    public String call() throws Exception {
        return "这是多线程第三个例子";
    }

    public static void main(String[] args) {
        ExecutorService executorPool = Executors.newSingleThreadExecutor();
        Future<String> future = executorPool.submit(new MyThread2());
        System.out.println("等待线程的结束");
        try {
            System.out.println(future.get()); // 等待线程结束，并获取返回结果
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
