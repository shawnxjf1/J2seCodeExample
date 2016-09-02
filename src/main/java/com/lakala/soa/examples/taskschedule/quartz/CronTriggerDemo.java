/**
 * Project Name:soa-test
 * File Name:CronTriggerDemo.java
 * Package Name:com.lakala.soa.examples.taskschedule.quartz
 * Date:2015年11月26日下午4:55:25
 * Copyright (c) 2015, www.lakala.com All Rights Reserved.
 *
*/

package com.lakala.soa.examples.taskschedule.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SchedulerMetaData;
import org.quartz.impl.StdSchedulerFactory;

import com.lakala.soa.examples.taskschedule.CustomJob;

import static org.quartz.JobBuilder.newJob;  
import static org.quartz.TriggerBuilder.newTrigger;  
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.CronScheduleBuilder.cronSchedule;;

/**
 * ClassName:CronTriggerDemo <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015年11月26日 下午4:55:25 <br/>
 * @author   tent
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class CronTriggerDemo {

	//	CronTrigger配置格式:
	//	格式: [秒] [分] [小时] [日] [月] [周] [年]
	//
	//	序号 	说明 	是否必填 	允许填写的值 	允许的通配符
	//	1 	秒 	是 	0-59  	  , - * /
	//	2 	分 	是 	0-59 	  , - * /
	//	3 	小时 	是 	0-23 	  , - * /
	//	4 	日 	是 	1-31 	  , - * ? / L W
	//	5 	月 	是 	1-12 or JAN-DEC 	  , - * /
	//	6 	周 	是 	1-7 or SUN-SAT 	  , - * ? / L #
	//	7 	年 	否 	empty 或 1970-2099 	, - * /
			
	public static void main(String[] args) throws Exception {
		
		// 日期格式化  
        SimpleDateFormat dateFormat = new SimpleDateFormat(  
                "yyyy 年 MM 月 dd 日  HH 时 mm 分 ss 秒");  
  
        SchedulerFactory sf = new StdSchedulerFactory();  
        Scheduler sched = sf.getScheduler();  
        System.out.println("--------------- 初始化 -------------------");  
  
        // job1 每20s运行一次  
        JobDetail job = newJob(CustomJob.class)
        		.withIdentity("job1", "group1")  
                .build();  
  
        CronTrigger trigger = newTrigger()
        		.withIdentity("trigger1", "group1")  
                .withSchedule(cronSchedule("0/20 * * * * ?"))
                .build();  
  
        Date ft = sched.scheduleJob(job, trigger);  
        System.out.println(job.getKey().getName() + " 将在: "  
                + dateFormat.format(ft) + " 运行 . 并且基于Cron表达式 : "  
                + trigger.getCronExpression() + "  (含义:每20s运行一次)");  
  
        // job2 偶数分钟的第15秒运行  
        job = newJob(CustomJob.class)
        		.withIdentity("job2", "group1")
        		.build();  
        trigger = newTrigger()
        		.withIdentity("trigger2", "group1")  
                .withSchedule(cronSchedule("15 0/2 * * * ?"))
                .build();  
  
        ft = sched.scheduleJob(job, trigger);  
        System.out.println(job.getKey().getName() + " 将在: "  
                + dateFormat.format(ft) + " 运行 . 并且基于Cron表达式 : "  
                + trigger.getCronExpression() + "  (含义:偶数分钟的第15秒运行)");  
  
        // job3 从8时到17时 ,每个 偶数分钟执行一次  
        job = newJob(CustomJob.class)
        		.withIdentity("job3", "group1")
        		.build();  
        trigger = newTrigger()
        		.withIdentity("trigger3", "group1")  
                .withSchedule(cronSchedule("0 0/2 8-17 * * ?"))
                .build();  
  
        ft = sched.scheduleJob(job, trigger);  
        System.out.println(job.getKey().getName() + " 将在: "  
                + dateFormat.format(ft) + " 运行 . 并且基于Cron表达式 : "  
                + trigger.getCronExpression() + "  (含义:从8时到17时 ,每个 偶数分钟执行一次)");  
  
        // job4 从17时到23时,每3分钟运行一次  
        job = newJob(CustomJob.class).withIdentity("job4", "group1").build();  
  
        trigger = newTrigger().withIdentity("trigger4", "group1")  
                .withSchedule(cronSchedule("0 0/3 17-23 * * ?")).build();  
  
        ft = sched.scheduleJob(job, trigger);  
        System.out.println(job.getKey().getName() + " 将在: "  
                + dateFormat.format(ft) + " 运行 . 并且基于Cron表达式 : "  
                + trigger.getCronExpression() + "  (含义: 从17时到23时,每3分钟运行一次)");  
  
        // job5 每个月的1号和15号的上午10点 运行  
        job = newJob(CustomJob.class).withIdentity("job5", "group1").build();  
  
        trigger = newTrigger().withIdentity("trigger5", "group1")  
                .withSchedule(cronSchedule("0 0 10am 1,15 * ?")).build();  
  
        ft = sched.scheduleJob(job, trigger);  
        System.out.println(job.getKey().getName() + " 将在: "  
                + dateFormat.format(ft) + " 运行 . 并且基于Cron表达式 : "  
                + trigger.getCronExpression() + "  (含义:每个月的1号和15号的上午10点 运行)");  
  
        // job6 周一至周五,每30秒运行一次  
        job = newJob(CustomJob.class).withIdentity("job6", "group1").build();  
  
        trigger = newTrigger().withIdentity("trigger6", "group1")  
                .withSchedule(cronSchedule("0,30 * * ? * MON-FRI")).build();  
  
        ft = sched.scheduleJob(job, trigger);  
        System.out.println(job.getKey().getName() + " 将在: "  
                + dateFormat.format(ft) + " 运行 . 并且基于Cron表达式 : "  
                + trigger.getCronExpression() + "  (含义:周一至周五,每30秒运行一次 )");  
  
        // job7 周六,周日 每30秒运行  
        job = newJob(CustomJob.class).withIdentity("job7", "group1").build();  
  
        trigger = newTrigger().withIdentity("trigger7", "group1")  
                .withSchedule(cronSchedule("0,30 * * ? * SAT,SUN")).build();  
  
        ft = sched.scheduleJob(job, trigger);  
        System.out.println(job.getKey().getName() + " 将在: "  
                + dateFormat.format(ft) + " 运行 . 并且基于Cron表达式 : "  
                + trigger.getCronExpression() + "  (含义:周六,周日  每30秒运行 )");  
  
        sched.start();  
  
        System.out.println("------- 开始调度 (调用.start()方法) ----------------");  
        System.out.println("------- 等待5分钟,给任务的调度留出时间  ... ------------");  
        try {  
            Thread.sleep(300L * 1000L);  
        } catch (Exception e) {  
        }  
  
        sched.shutdown(true);  
        System.out.println("------- 调度已关闭 ---------------------");  
  
        // 显示一下 已经执行的任务信息  
        SchedulerMetaData metaData = sched.getMetaData();  
        System.out.println("~~~~~~~~~~  执行了 "  
                + metaData.getNumberOfJobsExecuted() + " 个 jobs."); 
		
		
		
		
		
		// --------------------------print current time------------------------------------------------
		while (true) {
			Date now = new Date();
			String currentTime = " "  + now.getHours() + now.getMinutes() + now.getSeconds();
			System.out.println(currentTime);
			Thread.currentThread().sleep(1000);
		}
	}
}
