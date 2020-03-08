package com.sainath.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SingleThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + " is executing...");
        };

        // By using newSingleThreadExecutor factory method
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            singleThreadPool.execute(r);
        }
        singleThreadPool.shutdown();
        singleThreadPool.awaitTermination(2, TimeUnit.MINUTES);

        System.out.println("\n---------------\n");

        // By using newFixedThreadPool of size 1
        // We can change the size of this thread pool later on
        ThreadPoolExecutor singleFixedThreadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
        singleFixedThreadPool.setMaximumPoolSize(4);
        for (int i = 0; i < 10; i++) {
            singleFixedThreadPool.execute(r);
        }
        singleFixedThreadPool.shutdown();

        singleFixedThreadPool.awaitTermination(2, TimeUnit.MINUTES);

    }
}
