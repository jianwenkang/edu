package com.crown.quartz.demo3;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @ClassName More
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/10/25
 * @Time 17:53
 * @Version 1.0
 */
public class More {
    //每个任务JobDetail可以绑定多个Trigger，但一个Trigger只能绑定一个任务
    public static void main(String[] args) throws Exception {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        JobDetail jobDetail = JobBuilder.newJob(MoreJob.class)
                .withIdentity("jobName","jobGroup")//默认组名：DEFAULT
                .storeDurably()
                .build();
        Trigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .forJob(jobDetail)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().repeatForever().withIntervalInSeconds(2))
                .build();

        Trigger trigger1 = newTrigger()
                .withIdentity("trigger2", "group2")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().repeatForever().withIntervalInSeconds(5))
                .forJob(jobDetail)
                .build();

        Trigger trigger2 = TriggerBuilder.newTrigger()
                .withIdentity("triggerName:gg1","triggerGroup:gg")//默认组名：DEFAULT
                .startNow()//立即生效
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(3)//每隔1s执行一次
                        .repeatForever())
                .forJob(jobDetail)
                .build();//一直执行

        scheduler.addJob(jobDetail,true);
        scheduler.scheduleJob(trigger);
        scheduler.scheduleJob(trigger1);
        scheduler.scheduleJob(trigger2);
        scheduler.start();
    }
}
