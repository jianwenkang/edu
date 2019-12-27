package com.crown.test.quartz.demo1;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Calendar;
import java.util.Date;

public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Date date = new Date();
        long l = date.getTime() / 1000;
        System.out.println(l % (1 * 60));

        String type = jobExecutionContext.getJobDetail().getJobDataMap().getString("type");
        System.out.println("==="+ Calendar.getInstance().get(Calendar.SECOND));
    }
}