package com.crown.quartz.grid;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName GridJob
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/10/25
 * @Time 9:26
 * @Version 1.0
 */
public class GridJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //countDownLatch(jobExecutionContext);
        cyclicBarrier(jobExecutionContext);
    }

    public void cyclicBarrier(JobExecutionContext jobExecutionContext){
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        CyclicBarrier cyclicBarrier = (CyclicBarrier) jobDataMap.get("cyclicBarrier");
        List<String> devices = (List<String>) jobDataMap.get("devices");
        System.out.println("拿到所有Galaxy采集线程");
        System.out.println("进行采集分发");
        long start = System.currentTimeMillis();
        for (String str: devices
        ) {
            new CyclicBarrierGalaxy(cyclicBarrier).start();
        }
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("采集间隔："+ (end - start));
        System.out.println("采集结束");
        //执行Grid逻辑
        System.out.println("执行Grid逻辑");
        cyclicBarrier.reset();
        System.out.println("============");
    }

    public void countDownLatch(JobExecutionContext jobExecutionContext){
        //拿到所有Galaxy采集线程
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        CountDownLatch countDownLatch = (CountDownLatch) jobDataMap.get("countDownLatch");
        List<String> devices = (List<String>) jobDataMap.get("devices");
        System.out.println("拿到所有Galaxy采集线程");
        //进行采集分发
        System.out.println("进行采集分发.");
        long start = System.currentTimeMillis();
        for (String str: devices
        ) {
            new CountDownLatchGalaxy(countDownLatch).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("采集间隔："+ (end - start));
        //等待采集结束
        System.out.println("等待采集结束");
        //执行Grid逻辑
        System.out.println("执行Grid逻辑");
    }
}

class CyclicBarrierGalaxy extends Thread{
    CyclicBarrier cyclicBarrier;

    public CyclicBarrierGalaxy(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

class CountDownLatchGalaxy extends Thread {
    CountDownLatch countDownLatch;

    public CountDownLatchGalaxy(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
    }
}