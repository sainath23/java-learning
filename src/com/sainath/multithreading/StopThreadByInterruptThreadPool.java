package com.sainath.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class StopThreadByInterruptThreadPool {

    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + " is running...");
            }
            System.out.println(Thread.currentThread().getName() + " got interrupted...");
        };

        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 100; i++) {
            threadPool.execute(r);
        }
        threadPool.shutdown();
        System.out.println(Thread.currentThread().getName() + " is waiting for thread pool to complete...");
        threadPool.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println(Thread.currentThread().getName() + " is going to call shutdownNow()...");
        threadPool.shutdownNow();
    }
}
