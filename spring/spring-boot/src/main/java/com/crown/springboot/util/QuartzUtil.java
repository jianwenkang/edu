package com.crown.springboot.util;

import com.crown.springboot.entity.AppQuartz;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName QuartzUtil
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-06-03
 * @Time 16:22
 * @Version 1.0
 */
@Service
public class QuartzUtil {

    @Autowired
    @Qualifier("scheduler")
    private Scheduler scheduler;

    //新建一个JOB
    public JobDetail createJobDetail(Class<? extends Job> jobClass,String jobName, String jobGroup){
        return JobBuilder.newJob(jobClass)
                .withIdentity(jobName, jobGroup)//设置任务名，和组名
                .storeDurably()
                .build();
    }

    //新建一个Trigger
    public Trigger createTrigger(String triggerName, String triggerGroup, String cronExpression){
        Trigger build = TriggerBuilder.newTrigger().withIdentity(triggerName, triggerGroup)
                .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
                .build();
        return build;
    }

    public void addJob(JobDetail jobDetail, Trigger trigger) {
        try {
            scheduler.scheduleJob(jobDetail, trigger);
            String o = (String) new ObjectInputStream(new FileInputStream(new File(""))).readObject();
            //scheduler.resumeTrigger(trigger.getKey());
            //            //scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 1 新建一个
     */
    /**
     * Trigger
     * 新建
     * 修改
     * 删除
     * JobDetail
     *  新建
     *  修改
     *  删除
     */
    public String addJob(AppQuartz appQuartz) throws Exception  {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=df.parse(appQuartz.getStartTime());

        if (!CronExpression.isValidExpression(appQuartz.getCronExpression())) {
            return "Illegal cron expression";   //表达式格式不正确
        }
        JobDetail jobDetail=null;
        //构建job信息
        if("JobOne".equals(appQuartz.getJobGroup())) {
            jobDetail = JobBuilder.newJob(Job.class).withIdentity(appQuartz.getJobName(), appQuartz.getJobGroup()).build();
        }
        if("JobTwo".equals(appQuartz.getJobGroup())) {
            jobDetail = JobBuilder.newJob(Job.class).withIdentity(appQuartz.getJobName(), appQuartz.getJobGroup()).build();
        }

        //表达式调度构建器(即任务执行的时间,不立即执行)
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(appQuartz.getCronExpression()).withMisfireHandlingInstructionDoNothing();

        //按新的cronExpression表达式构建一个新的trigger
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(appQuartz.getJobName(), appQuartz.getJobGroup()).startAt(date)
                .withSchedule(scheduleBuilder).build();

        //传递参数
        if(appQuartz.getInvokeParam()!=null && !"".equals(appQuartz.getInvokeParam())) {
            trigger.getJobDataMap().put("invokeParam",appQuartz.getInvokeParam());
        }
        scheduler.scheduleJob(jobDetail, trigger);
        // pauseJob(appQuartz.getJobName(),appQuartz.getJobGroup());
        return "success";
    }

}
