package com.crown.test.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;

import java.util.Set;

/**
 * @ClassName QuartzManager
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/7/5
 * @Time 13:53
 * @Version 1.0
 */
public class QuartzManager {

    private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();

    //增加
    public void addJob(String jobName,String jobGroupName, Class jobClass , String cronExpression) {
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            // 创建jobDetail实例，绑定Job实现类
            // 指明job的名称，所在组的名称，以及绑定job类
            JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroupName)// 任务名称和组构成任务key
                    .build();
            // 定义调度触发规则
            // 使用cornTrigger规则
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName, jobGroupName)// 触发器key
                    .startAt(DateBuilder.futureDate(1, DateBuilder.IntervalUnit.SECOND))
                    .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression)).startNow().build();
            // 把作业和触发器注册到任务调度中
            scheduler.scheduleJob(jobDetail, trigger);
            // 启动
            if (!scheduler.isShutdown()) {
                scheduler.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //删除
    public void deleteJob(String jobName,String jobGroupName) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(jobName, jobGroupName);
        schedulerFactory.getScheduler().deleteJob(jobKey);

    }

    //修改
    public void updateJobCron(String jobName,String jobGroupName, String cronExpression) throws SchedulerException {

        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroupName);

        CronTrigger trigger = (CronTrigger) schedulerFactory.getScheduler().getTrigger(triggerKey);

        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

        trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

        schedulerFactory.getScheduler().rescheduleJob(triggerKey, trigger);
    }
    //查询
    public Set<JobKey> queryByjobGroupName(String jobGroupName) throws SchedulerException {
        GroupMatcher<JobKey> groupMatcher = GroupMatcher.groupEquals(jobGroupName);
        Set<JobKey> jobKeys = schedulerFactory.getScheduler().getJobKeys(groupMatcher);
        return  jobKeys;
    }
}
