package com.crown.quartz.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

/**
 * @ClassName My
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/11/12
 * @Time 18:24
 * @Version 1.0
 */
public class MyJobListener implements JobListener {
    @Override
    public String getName() {
        String name = getClass().getSimpleName();
        System.out.println("Metnod AAA:" + "获取到监听器名称" + name);
        return name;
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {
        String name = jobExecutionContext.getJobDetail().getKey().getName();
        System.out.println("Metnod BBB:" + name + "----任务即将执行");
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {
        String name = jobExecutionContext.getJobDetail().getKey().getName();
        System.out.println("Metnod CCC:" + name + "----任务被否决");
    }

    @Override
    public void jobWasExecuted(JobExecutionContext jobExecutionContext, JobExecutionException e) {
        String name = jobExecutionContext.getJobDetail().getKey().getName();
        System.out.println("Metnod DDD:" + name + "----执行完毕");
    }
}
