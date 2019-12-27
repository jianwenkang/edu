package com.crown.test.quartz.demo1;


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;

import java.util.Set;


/**
 * @ClassName QuartzTest
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/7/5
 * @Time 14:52
 * @Version 1.0
 */
public class QuartzTest {

    private static String JOB_GROUP_NAME = "EXTJWEB_JOBGROUP_NAME";

    private static String TRIGGER_GROUP_NAME = "EXTJWEB_TRIGGERGROUP_NAME";

    public static void main(String[] args) throws Exception {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("type","aaa");
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("j1", "g1")
               // .usingJobData("type","aa")
                .build();
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("j1", "g1")// 触发器key
                .startAt(DateBuilder.futureDate(1, DateBuilder.IntervalUnit.SECOND))
                .withSchedule(CronScheduleBuilder.cronSchedule("*/10 * * * * ?"))
                .startNow()
                .usingJobData("type","ccc")
                .build();
        // 把作业和触发器注册到任务调度中
        SchedulerFactory schedFact = new StdSchedulerFactory();

        Scheduler scheduler = schedFact.getScheduler();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();




        //获得所有的任务
        GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();
        Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);
        for (JobKey jobkey:jobKeys
             ) {
            System.out.println(jobkey);
        }

        //获得运行的任务

    }

}

