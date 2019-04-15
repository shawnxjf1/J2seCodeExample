package com.transaction;

import org.junit.Test;

/**
 * @author 58pc
 * @date 2019/4/15
 */
public class TransactionTest {

    /////////////// ************case 1**************//////////////////////////////
    @Test
    @Transactional(propagation = Propagation.MANDATORY)
    public void insertPerformanceMapper() {
        this.insert();
    }

    // @Transactional
    public void insert() {
        //
        // throw new RuntimeException("ceshi");
    }
    // 执行结果
    // org.springframework.transaction.IllegalTransactionStateException: No existing transaction found for transaction
    // marked with propagation 'mandatory'

    /////////////// ************case 2**************//////////////////////////////
    @Test
    @Transactional(propagation = Propagation.MANDATORY)
    public void insertPerformanceMapper() {
        this.insert();
    }

    @Transactional
    public void insert() {
        //
        // throw new RuntimeException("ceshi");
    }
    // 执行结果,同样会报错
    // org.springframework.transaction.IllegalTransactionStateException: No existing transaction found for transaction
    // marked with propagation 'mandatory'

    /////////////// ************case 1**************//////////////////////////////
    @Test
    @Transactional
    public void insertPerformanceMapper() {
        this.insert();
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void insert() {
        //
        // throw new RuntimeException("ceshi");
    }
    // 不会报错，Mandatory要求调用它的时候已经存在，比如A调用B，B的事务级别为Mandatory那么,A调用B的时候事务必须已经存在。
}
