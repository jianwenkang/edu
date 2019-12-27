package com.crown.test.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName CyclicBarrierTest
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/11/25
 * @Time 18:20
 * @Version 1.0
 */
public class CyclicBarrierTest {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        for (int i = 0; i < 3; i++){
            new Thread( () -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(3000);
                    int await = cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + "--" +await);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        System.out.println("-------------");
        cyclicBarrier.await();
        System.out.println("===========");

    }
}
