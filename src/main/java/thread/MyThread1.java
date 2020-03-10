package thread;

/**
 * @ Author: Mr.Li
 * @ Date: 2020-02-14 23:28
 * @ Description: TODO
 **/
public class MyThread1 extends Thread {

    public void run() {
        System.out.println("这是多线程的第二个例子");
    }

    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
    }
}
