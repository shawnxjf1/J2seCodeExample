package com.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author 58pc
 * @date 2019/4/14
 */
public class MySqlLock implements Lock {

    @Override public boolean tryLock() {
        return false;
    }

    @Override public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override public void unlock() {

    }

    @Override public void lock() {

    }

    @Override public void lockInterruptibly() throws InterruptedException {

    }

    @Override public Condition newCondition() {
        return null;
    }
}