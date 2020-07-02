package com.crown.springboot.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

/**
 * @ClassName HelloJob
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-06-04
 * @Time 13:54
 * @Version 1.0
 */
public class HelloJob implements Job {
    private static Logger logger = LoggerFactory.getLogger(HelloJob.class);
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        logger.error("{}", LocalDateTime.now());
    }
}
