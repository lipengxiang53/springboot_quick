package test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author lipengxiang
 * @Date 2020/7/31 11:48
 * @description
 */
public class SemaphoreDemo {
    private Semaphore semaphore = new Semaphore(3);
    private Lock lock = new ReentrantLock();

    public void testMethod() {
        try {
            semaphore.acquire();
            //synchronized (this)
            //{
            //lock.lock();
            System.out.println(Thread.currentThread().getName() + " 开始时间：" + System.currentTimeMillis());
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "打印" + (i + 1) + "次");
            }
            System.out.println(Thread.currentThread().getName() + " 结束时间： " + System.currentTimeMillis());
            //lock.unlock();
            //}

            semaphore.release();
        } catch (Exception e) {

        }
    }
}
