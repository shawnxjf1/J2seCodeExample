package com.person;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.person.job.EnableCustomerAccountJob;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-test/applicationContext.xml")
public class EnableCustomerAccountJobTest {
    static {
        System.setProperty("spring.profiles.active", "ceshi113");
    }

    @Test
    public void testCreateJob() {

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = null;

        try {
            scheduler = schedulerFactory.getScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

        String customerId = "eebe39d4fca743ed80802825279353f8";
        JobKey jobKey = new JobKey(customerId, "enableCustomerAccount");

        // JobDataMap jobDataMap = new JobDataMap();
        // jobDataMap.put(JobConstants.CUSTOMER_ID_KEY, customerId);
        // jobDataMap.put(JobConstants.SERVICE_CONTEXT_KEY, serviceContext);
        // JobDetail jobDetail =
        // JobBuilder.newJob(EnableCustomerAccountJob.class).usingJobData(jobDataMap).withIdentity(jobKey).build();
        //
        // try {
        // scheduler.getListenerManager().addJobListener(new EnableCustomerAccountJobListener(),
        // KeyMatcher.keyEquals(jobKey));
        //
        // scheduler.scheduleJob(jobDetail, JobManager.fireAfterEvery5SecondsRepeatThrice());
        // scheduler.start();
        // } catch (SchedulerException e) {
        // e.printStackTrace();
        // }

        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // JobDetail enableCustomerAccountJob = n
    }

    @Test
    public void testCronScheduler() {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = null;
        try {
            scheduler = schedulerFactory.getScheduler();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

        String customerId = "eebe39d4fca743ed80802825279353f8";

        String cronExpression = "30 0 0 * * ?";

        JobDataMap jobDataMap = new JobDataMap();
        // jobDataMap.put(JobConstants.CUSTOMER_ID_KEY, customerId);
        // jobDataMap.put(JobConstants.SERVICE_CONTEXT_KEY, serviceContext);
        JobDetail jobDetail = JobBuilder.newJob(EnableCustomerAccountJob.class).usingJobData(jobDataMap)
            .withIdentity(customerId, "enableCustmerAccount").build();

        Trigger cronTrigger = TriggerBuilder.newTrigger().forJob(jobDetail)
            .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression)).build();
        try {
            scheduler.scheduleJob(jobDetail, cronTrigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
