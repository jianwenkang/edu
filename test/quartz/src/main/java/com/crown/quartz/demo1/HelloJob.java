package com.crown.quartz.demo1;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @ClassName HelloJob
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/10/17
 * @Time 17:53
 * @Version 1.0
 */
@DisallowConcurrentExecution
public class HelloJob implements Job {
    private Integer data1;

    public void setData1(Integer data1) {
        this.data1 = data1;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("-->"+data1);
    }
}
