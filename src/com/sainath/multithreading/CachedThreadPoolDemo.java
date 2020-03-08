package com.sainath.multithreading;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CachedThreadPoolDemo {
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

        //int totalProcessors = Runtime.getRuntime().availableProcessors();
        //System.out.println("Available Processors = " + totalProcessors);
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        List<Future<?>> futures = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            futures.add(cachedThreadPool.submit(r));
        }
        cachedThreadPool.shutdown();
        cachedThreadPool.awaitTermination(2, TimeUnit.MINUTES);
        System.out.println("FINAL QUEUE SIZE = " + queue.size());
        System.out.println(futures.size());

        // In case of Runnable future returns null
        futures.forEach(f -> {
            try {
                System.out.print(f.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }
}
