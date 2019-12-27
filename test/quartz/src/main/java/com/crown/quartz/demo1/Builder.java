package com.crown.quartz.demo1;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;

import java.util.GregorianCalendar;

/**
 * @ClassName Builder
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/10/17
 * @Time 17:55
 * @Version 1.0
 */
public class Builder {
    public static void main(String[] args) throws Exception {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        //创建JobDetail
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("job", "group1")//设置任务名，和组名
                .usingJobData("data1",1)//传递参数
                .storeDurably()
                .build();
        JobDataMap jobDataMap1 = jobDetail.getJobDataMap();
        jobDataMap1.put("data",2);
        //排除规则
        AnnualCalendar annualCalendar = new AnnualCalendar();
        annualCalendar.setDayExcluded(new GregorianCalendar(2019, 8, 8),true);
        annualCalendar.setDayExcluded(new GregorianCalendar(2019, 8, 9),true);
        scheduler.addCalendar("annualCalendar",annualCalendar,false,false);
        //创建触发器
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "triggerGroup1")
                //.usingJobData("data1",2)
                .startNow()//立即生效
                .modifiedByCalendar("annualCalendar")//排除日期
                .withSchedule(SimpleScheduleBuilder
                        .simpleSchedule()
                        .withIntervalInSeconds(3)//每隔1s执行一次
                        .repeatForever())
                .build();//一直执行
        System.out.println(trigger.getJobDataMap());
        //创建调度器


        scheduler.scheduleJob(jobDetail, trigger);

        scheduler.start();
        Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity("trigger1", "triggerGroup1")
                //.usingJobData("data1",2)
                .startNow()//立即生效
                .modifiedByCalendar("annualCalendar")//排除日期
                .withSchedule(CronScheduleBuilder.cronSchedule("").withMisfireHandlingInstructionFireAndProceed())
                .build();//一直执行
    }
}
