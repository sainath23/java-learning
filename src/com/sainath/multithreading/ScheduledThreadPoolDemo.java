package com.sainath.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolDemo {
    private volatile int count = 0;
    private static final ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

    public static void main(String[] args) throws InterruptedException {
        ScheduledThreadPoolDemo demo = new ScheduledThreadPoolDemo();
        //demo.testSchedule();
        //demo.testScheduleAtFixedRate();
        //demo.testScheduleWithFixedDelay();

        Runnable r = () -> {
            long startTime = System.currentTimeMillis();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is executing...");
            long endTime = System.currentTimeMillis();
            long takenTime = (endTime - startTime) / 1000;
            System.out.println(Thread.currentThread().getName() + " took " + takenTime + " seconds to complete a task...");
        };
        //scheduledThreadPool.scheduleAtFixedRate(r, 3, 2, TimeUnit.SECONDS);
        scheduledThreadPool.scheduleWithFixedDelay(r, 3, 2, TimeUnit.SECONDS);
    }

    public void testSchedule() throws InterruptedException {
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + " is executing...");
            count++;
        };

        // task to run after 2 seconds delay
        scheduledThreadPool.schedule(r, 2, TimeUnit.SECONDS);

        scheduledThreadPool.shutdown();
        scheduledThreadPool.awaitTermination(2, TimeUnit.MINUTES);
    }

    public void testScheduleAtFixedRate() throws InterruptedException {
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + " is executing...");
            count++;
        };

        // task to run repeatedly every 2 seconds after initial delay of 3 seconds
        scheduledThreadPool.scheduleAtFixedRate(r, 3, 2, TimeUnit.SECONDS);

        while (true) {
            System.out.println("Count = " + count);
            Thread.sleep(1000);
            if (count == 5) {
                System.out.println("Count is 5... breaking the loop...");
                scheduledThreadPool.shutdown();
                break;
            }
        }
    }

    public void testScheduleWithFixedDelay() throws InterruptedException {
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + " is executing...");
            count++;
        };

        // task to run repeatedly 2 seconds after previous task completes
        scheduledThreadPool.scheduleWithFixedDelay(r, 3, 2, TimeUnit.SECONDS);

        while (true) {
            System.out.println("Count = " + count);
            Thread.sleep(1000);
            if (count == 5) {
                System.out.println("Count is 5... breaking the loop...");
                scheduledThreadPool.shutdown();
                break;
            }
        }
        scheduledThreadPool.awaitTermination(2, TimeUnit.MINUTES);
    }
}
