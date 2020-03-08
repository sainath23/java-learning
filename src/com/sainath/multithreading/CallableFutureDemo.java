package com.sainath.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallableFutureDemo {

    public static void main(String[] args) {
        Callable<Integer> callable = () -> {
            Thread.sleep(2000);
            int randomNumber = new Random().nextInt(999);
            if (randomNumber >= 0 && randomNumber <= 100) throw new Exception("Number is less than 100");
            return randomNumber;
        };

        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            futures.add(threadPool.submit(callable));
        }
        threadPool.shutdown();

        futures.forEach(integerFuture -> {
            try {
                //System.out.println(integerFuture.get());
                System.out.println(integerFuture.get(1, TimeUnit.SECONDS)); // this type of get throws TimeoutException
            } catch (InterruptedException | TimeoutException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        System.out.println("Executed by main method...");
    }
}
