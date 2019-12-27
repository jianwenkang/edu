package com.crown.quartz.grid;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName Bootstrap
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/10/25
 * @Time 11:30
 * @Version 1.0
 */
public class Bootstrap {
    public static void main(String[] args) throws Exception {
        //countDownLatch();
        cyclicBarrier();
    }

    private static void cyclicBarrier() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("G1");
        list.add("G2");
        list.add("G3");
        CyclicBarrier cyclicBarrier = new CyclicBarrier(list.size() + 1);
        new CyclicBarrier(1);
        //创建JobDetail
        JobDetail jobDetail = JobBuilder.newJob(GridJob.class)
                .withIdentity("job", "group1")//设置任务名，和组名
                .build();
        jobDetail.getJobDataMap().put("devices",list);
        jobDetail.getJobDataMap().put("cyclicBarrier",cyclicBarrier);

        //创建触发器
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger2", "group2")
                .withSchedule(CronScheduleBuilder.cronSchedule("*/10 * * * * ?"))
                .build();

        //创建调度器
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        scheduler.scheduleJob(jobDetail, cronTrigger);

        scheduler.start();
    }

    private static void countDownLatch() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("G1");
        list.add("G2");
        list.add("G3");
        CountDownLatch countDownLatch = new CountDownLatch(list.size());
        //创建JobDetail
        JobDetail jobDetail = JobBuilder.newJob(GridJob.class)
                .withIdentity("job", "group1")//设置任务名，和组名
                .build();
        jobDetail.getJobDataMap().put("devices",list);
        jobDetail.getJobDataMap().put("countDownLatch",countDownLatch);

        //创建触发器
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger2", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("*/10 * * * * ?"))
                .build();

        //创建调度器
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        scheduler.scheduleJob(jobDetail, cronTrigger);

        scheduler.start();
    }
}
