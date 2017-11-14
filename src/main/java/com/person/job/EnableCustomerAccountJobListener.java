package com.facishare.crm.customeraccount.predefine.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EnableCustomerAccountJobListener implements JobListener {

    public static final String LISTENER_NAME = "EnableCustomerAccountJobListener";

    @Override
    public String getName() {
        return LISTENER_NAME;
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {
        String jobName = jobExecutionContext.getJobDetail().getKey().toString();
        log.info("jobName:{} is executed...");

    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {
        String jobName = jobExecutionContext.getJobDetail().getKey().toString();
        log.info("jobName:{} is jobExecutionVetoed...");

    }

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        System.out.println("jobWasExecuted");

        String jobName = context.getJobDetail().getKey().toString();
        System.out.println("Job : " + jobName + " is finished...");

        if (!jobException.getMessage().equals("")) {
            System.out.println("Exception thrown by: " + jobName + " Exception: " + jobException.getMessage());
        }

    }
}
