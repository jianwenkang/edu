package com.crown.springboot;

import com.crown.springboot.job.HelloJob;
import com.crown.springboot.util.QuartzUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @ClassName QuartzTest
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-06-03
 * @Time 17:04
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={Application.class})// 指定启动类
public class QuartzTest {
    @Autowired
    private QuartzUtil quartzUtil;
    @Autowired
    @Qualifier("scheduler")
    private Scheduler scheduler;
    @Test
    public void test() throws IOException {
        JobDetail jobDetail = quartzUtil.createJobDetail(HelloJob.class, "hello", "hg");
        //JobDetail jobDetail1 = quartzUtil.createJobDetail(HelloJob.class, "hello1", "hg1");
        Trigger hello = quartzUtil.createTrigger("hello", "ht", "/2 * * * * ?");
        //Trigger hello1 = quartzUtil.createTrigger("hello1", "ht1", "/3 * * * * ?");
        quartzUtil.addJob(jobDetail,hello);
        //quartzUtil.addJob(jobDetail1,hello1);
        System.in.read();
    }
}
