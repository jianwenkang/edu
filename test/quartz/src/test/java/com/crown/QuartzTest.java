package com.crown;

import org.junit.Test;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @ClassName QuartzTest
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-06-03
 * @Time 16:36
 * @Version 1.0
 */
public class QuartzTest {
    @Test
    public void test1() throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

    }
}
