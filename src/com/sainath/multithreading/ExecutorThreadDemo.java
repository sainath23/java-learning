package com.sainath.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class ExecutorThreadDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Runnable r1 = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " performing some operation: " + i);
            }
        };

        Callable<List<Integer>> callable = () -> {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= 5; i++)
                list.add(i);
            return list;
        };

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        /*for (int i = 0; i < 10; i++) {
            executorService.submit(r1);
        }*/

        List<Future<List<Integer>>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(executorService.submit(callable));
        }

        executorService.shutdown();
        executorService.awaitTermination(100, TimeUnit.SECONDS);

        for (Future<List<Integer>> future : futures) {
            System.out.println(future.get());
        }


        /*List<Future<List<Integer>>> myList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<List<Integer>> myFuture = new FutureTask<>(callable);
            myList.add(myFuture);
        }

        for (Future<List<Integer>> future : myList) {
            System.out.println(future.get());
        }*/
    }
}
