package com.person.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EnableCustomerAccountJob<T, V> implements Job {

    T customerAccountManager;

    T customerAccountConfigDao;

    /**
     * 1.这里描述具体的任务如何执行<br>
     * @param context
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // 查询 customer_account_enable 为开启中 配置企业信息
        //dosomething()......
    }

}
