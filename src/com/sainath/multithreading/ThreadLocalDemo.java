package com.sainath.multithreading;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo {

    public static void main(String[] args) {
        Runnable r = () -> {
            new ThreadLocalDemo().doSomething();
        };

        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool(5);
        Executors.newSingleThreadExecutor();

        for (int i = 0; i < 1000; i++) {
            threadPool.submit(r);
        }

        threadPool.shutdown();
    }

    private void doSomething() {
        ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("dd-MM-yyyy"));
        threadLocal.get();
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        System.out.println(list.hashCode());
    }
}
