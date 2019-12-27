package com.crown.quartz.demo3;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @ClassName MoreJob
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/10/25
 * @Time 17:55
 * @Version 1.0
 */
public class MoreJob  implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(new Date());
    }
}
