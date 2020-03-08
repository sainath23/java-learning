package com.sainath.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class StopThreadByVolatileBoolean {
    private volatile static boolean keepRunning = true;

    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            while (keepRunning) {
                System.out.println(Thread.currentThread().getName() + " is running....");
            }
        };

        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 100; i++) {
            threadPool.execute(r);
        }
        threadPool.shutdown();
        System.out.println(Thread.currentThread().getName() + " is waiting for thread pool to complete...");
        threadPool.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println(Thread.currentThread().getName() + " is going to update keepRunning to false...");
        keepRunning = false;
    }
}
