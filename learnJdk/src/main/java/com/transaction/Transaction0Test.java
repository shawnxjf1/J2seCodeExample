package com.transaction;

import org.junit.Test;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 58pc
 * @date 2019/4/15
 */
public class Transaction0Test {

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
    // 意想结果
    // org.springframework.transaction.IllegalTransactionStateException: No existing transaction found for transaction
    // marked with propagation 'mandatory'

    // 实际执行结果：
    // 不报错，因为insert和 insertPerformanceMapper()都没有数据库操作语句，虽然写上了@transaction事务但是不触发事务。

    @Test
    @Transactional(propagation = Propagation.MANDATORY)
    public void insertPerformanceMapper1() {
        this.insert();
    }

    // @Transactional
    public void insert1() {
        // FIXME 添加select 语句确认是否报错，如果报错说明select语句也会触发事务
        // throw new RuntimeException("ceshi");
    }
}
