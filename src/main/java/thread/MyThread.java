package thread;

/**
 * @ Author: Mr.Li
 * @ Date: 2020-02-14 23:24
 * @ Description: TODO
 **/
public class MyThread  implements Runnable{

    @Override
    public void run() {
        System.out.println("这是一个多线程的例子案例");
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
        thread.start();

    }
}
