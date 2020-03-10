package Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @ Author: Mr.Li
 * @ Date: 2020-02-17 01:30
 * @ Description: 自己实现一个锁的机制
 **/
public class NeteaseLook implements Lock {

    @Override
    public void lock() {

    }


    @Override
    public void lockInterruptibly() throws InterruptedException {

    }


    @Override
    public boolean tryLock() {
        return false;
    }


    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }


    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
