package com.sainath.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExceptionCheck {

    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is executing...");
            if ("pool-1-thread-1".equals(Thread.currentThread().getName())) {
                System.out.println("Inside if");
                try {
                    throw new RuntimeException("Dummy exception");
                } catch (Exception e) {
                    System.out.println(e.getMessage() + " is thrown...");
                }
            }
        };

        ThreadPoolExecutor threadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
        System.out.println("Core Count Before submitting = " + threadPool.getCorePoolSize());
        for (int i = 0; i < 20; i++) {
            threadPool.execute(r);
        }
        System.out.println("Core count before shutdown = " + threadPool.getCorePoolSize());
        //threadPool.shutdown();
        //threadPool.execute(r);
        threadPool.awaitTermination(2, TimeUnit.MINUTES);
        System.out.println("Core count after termination = " + threadPool.getCorePoolSize());
        threadPool.shutdownNow();
    }
}
