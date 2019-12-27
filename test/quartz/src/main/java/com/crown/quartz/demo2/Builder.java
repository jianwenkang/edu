package com.crown.quartz.demo2;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;

import java.util.List;
import java.util.Set;

/**
 * @ClassName Builder
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/10/25
 * @Time 16:34
 * @Version 1.0
 */
public class Builder {
    public static void main(String[] args) throws Exception {
        JobDetail jobDetail = JobBuilder.newJob(GroupJob.class)
                .withIdentity("jobName:aa","jobGroup:aa")//默认组名：DEFAULT
                .usingJobData("group","group")
                .usingJobData("job","job")
                .storeDurably()
                .build();

        JobDetail jobDetail1 = JobBuilder.newJob(GroupJob.class)
                .withIdentity("jobName:aa1","jobGroup:aa")//默认组名：DEFAULT
                .usingJobData("group","group")
                .usingJobData("job","job")
                .storeDurably()
                .build();

        JobDetail jobDetail2 = JobBuilder.newJob(GroupJob.class)
                .withIdentity("jobName:aa","jobGroup:aa1")//默认组名：DEFAULT
                .usingJobData("group","group")
                .usingJobData("job","job")
                .storeDurably()
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("triggerName:gg","triggerGroup:gg")//默认组名：DEFAULT
                .startNow()//立即生效
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(5)//每隔1s执行一次
                        .repeatForever())
                .forJob(jobDetail)
                .build();//一直执行

        Trigger trigger1 = TriggerBuilder.newTrigger()
                .withIdentity("triggerName:gg1","triggerGroup:gg1")//默认组名：DEFAULT
                .startNow()//立即生效
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(3)//每隔1s执行一次
                        .repeatForever())
                .forJob(jobDetail)
                .build();//一直执行

        Trigger trigger2 = TriggerBuilder.newTrigger()
                .withIdentity("triggerName:gg2","triggerGroup:gg1")//默认组名：DEFAULT
                .startNow()//立即生效
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(3)//每隔1s执行一次
                        .repeatForever())
                .forJob(jobDetail)
                .build();//一直执行

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.addJob(jobDetail,true);
        scheduler.addJob(jobDetail1,true);
        scheduler.addJob(jobDetail2,true);
        scheduler.scheduleJob(trigger);
        scheduler.scheduleJob(trigger1);
        scheduler.scheduleJob(trigger2);
        //scheduler.start();
        //==================================================================================================================
        System.out.println("-----获得所有Job组-----");
        List<String> jobGroupNames = scheduler.getJobGroupNames();
        for (String jobGroup: jobGroupNames
        ) {
            System.out.println("job组：" + jobGroup);

            //根据组名获得组下的Job
            GroupMatcher<JobKey> groupMatcher = GroupMatcher.groupEquals(jobGroup);
            Set<JobKey> jobKeys = scheduler.getJobKeys(groupMatcher);
            for (JobKey jobKey:jobKeys
                 ) {
                System.out.println("job组名:" + jobKey);
                //JobKey jobKey = JobKey.jobKey()   根据任务组和任务名获得指定Job
            }
            System.out.println("============");
        }

        System.out.println("-----获得所有Job-----");
        Set<JobKey> jobKeySet = scheduler.getJobKeys(GroupMatcher.anyGroup());
        for (JobKey jobKey:jobKeySet
             ) {
            System.out.println("job名:" + jobKey);
        }

        System.out.println("-----获得所有Trigger组-----");
        List<String> triggerGroupNames = scheduler.getTriggerGroupNames();
        for (String triggerGroup: triggerGroupNames
             ) {
            System.out.println("trigger组:" + triggerGroup);
            GroupMatcher<TriggerKey> groupMatcher = GroupMatcher.groupEquals(triggerGroup);
            Set<TriggerKey> triggerKeys = scheduler.getTriggerKeys(groupMatcher);
            for (TriggerKey triggerKey: triggerKeys
            ) {
                System.out.println("trigger名:" + triggerKey);
            }
            System.out.println("=========");
        }

        TriggerKey.triggerKey("","");
        System.out.println("-----获得所有Trigger-----");
        Set<TriggerKey> triggerKeys = scheduler.getTriggerKeys(GroupMatcher.anyTriggerGroup());
        for (TriggerKey triggerKey: triggerKeys
        ) {
            System.out.println("trigger名:" + triggerKey);
        }

        CronTrigger build = TriggerBuilder.newTrigger()
                .withIdentity("triggerName:gg", "triggerGroup:gg")//默认组名：DEFAULT
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("").withMisfireHandlingInstructionDoNothing())
                .build();
    }
}
