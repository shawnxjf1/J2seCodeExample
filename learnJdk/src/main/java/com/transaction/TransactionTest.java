package com.transaction;

import org.junit.Test;

/**
 * @author 58pc
 * @date 2019/4/15
 */
public class TransactionTest {

    @Test
    @Transactional(propagation = Propagation.MANDATORY)
    public void insertPerformanceMapper() {
        this.insert();
    }

    // @Transactional
    public void insert() { 
        ..
        // throw new RuntimeException("ceshi");
    }
    // 执行结果
    // org.springframework.transaction.IllegalTransactionStateException: No existing transaction found for transaction
    // marked with propagation 'mandatory'
}
