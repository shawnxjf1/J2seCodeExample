package com.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;
/**
 * @author 58pc
 * @date 2019/4/9
 */
public class TryFinallyExample {

    protected Logger logger = LoggerFactory.getLogger(getClass());


    private void tryReturnFinally() {
        final int ONE_MINUTE = 60 * 1000; // 单位毫秒
        String lockName = "testTryReleaseLock";
        String threadName = Thread.currentThread().getName();

        try {
            logger.info("try return......");
            return;
            // Thread.sleep(ONE_MINUTE);
        } catch (Exception e) {
            System.out.println("exception occur" + threadName);
        } finally {
            logger.info("return then finally......");
        }
        logger.info("after return......");
    }

    @Test
    public void testReturn() {
        tryReturnFinally();
//        执行结果<br>
//        已经获取到锁了main
//        13:04:51.891 [ INFO] IFlowServiceTest.tryReturnFinally(502) - try return......
//        13:04:51.891 [ INFO] IFlowServiceTest.tryReturnFinally(509) - return then finally......
    }
}
