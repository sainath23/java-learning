package com.sainath.multithreading;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorTestDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        Callable<Integer> callable = ExecutorTestDemo::task;
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        Future<Integer> future = threadPool.submit(callable);

        //threadPool.awaitTermination(10, TimeUnit.SECONDS);
        threadPool.shutdown();
        //threadPool.shutdownNow();
        threadPool.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(future.get(5500, TimeUnit.MILLISECONDS));
    }

    public static int task() throws Exception {
        Thread.sleep(2000);
        return new Random().nextInt(999);
    }
}
