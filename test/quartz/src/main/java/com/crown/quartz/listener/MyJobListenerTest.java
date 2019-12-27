package com.crown.quartz.listener;

import com.crown.quartz.demo1.HelloJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.EverythingMatcher;

/**
 * @ClassName MyJobListenerTest
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/11/12
 * @Time 18:31
 * @Version 1.0
 */
public class MyJobListenerTest {
    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("job1", "jobG1")
                .build();
        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("t1", "rg1")
                .withSchedule(SimpleScheduleBuilder
                        .simpleSchedule()
                        .withIntervalInSeconds(5)
                        .repeatForever())
                .build();

        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = stdSchedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail,trigger);

        //创建注册一个全局的Job 监听器
        scheduler.getListenerManager().addJobListener(new MyJobListener(), EverythingMatcher.allJobs());
        scheduler.start();
    }
}
