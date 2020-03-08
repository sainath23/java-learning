package com.sainath.multithreading;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ThreadPoolDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<Integer> callable = () -> {
            Random random = new Random();
            Integer i = random.nextInt();
            Thread.sleep(5000);
            return i;
        };
        /*System.out.println("Before submitting task");
        Future<Integer> future = executorService.submit(callable);
        executorService.shutdown();
        System.out.println("Task submitted. Fetching task");
        System.out.println("Task end");
        System.out.println(future.get());*/

        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        executorService.submit(futureTask);
        System.out.println(futureTask.get());
        executorService.shutdown();
    }
}
