package com.crown.quartz.demo2;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @ClassName GroupJob
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/10/25
 * @Time 16:31
 * @Version 1.0
 */
public class GroupJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        String group = (String) jobDataMap.get("group");
        String job = (String) jobDataMap.get("job");
        System.out.println(group + ":" + job);

    }
}
