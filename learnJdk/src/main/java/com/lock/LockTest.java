package com.lock;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * *
 * @author 58pc
 * @date 2019/4/14
 */
public class LockTest {
    private int count = 100;
    private Lock lock = new ReentrantLock();

    @Test public void tickettest() {
        TicketRunnable tr = new TicketRunnable();
        Thread t1 = new Thread(tr, "窗口A");
        Thread t2 = new Thread(tr, "窗口B");
        Thread t3 = new Thread(tr, "窗口C");
        Thread t4 = new Thread(tr, "窗口D");
    }

    public class TicketRunnable implements Runnable {
        @Override public void run() {
            while (count > 0) {
                lock.lock();
                if (count > 0) {
                    System.out.println(Thread.currentThread().getName() + "售出第" + count-- + "张票");
                }
            }
        }
    }

}