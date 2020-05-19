package com.sainath.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FixedThreadPoolDemo {
    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is executing...");
            queue.offer(new Random().nextInt(999));
        };

        int totalProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("Available Processors = " + totalProcessors);
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(totalProcessors);

        for(int i = 0; i < 100; i++) {
            fixedThreadPool.execute(r);
        }
        fixedThreadPool.shutdown();
        fixedThreadPool.awaitTermination(2, TimeUnit.MINUTES);
        System.out.println("FINAL QUEUE SIZE = " + queue.size());
        ((ThreadPoolExecutor)fixedThreadPool).setCorePoolSize(3);
    }
}
