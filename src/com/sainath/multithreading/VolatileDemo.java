package com.sainath.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VolatileDemo {
    private volatile boolean flag = true;

    public void test() {
        Runnable r1 = () -> {
            while (flag) {
                System.out.println(Thread.currentThread().getName() + ": I am running... " + flag);
            }
        };

        Runnable r2 = () -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": changing flag to false");
            flag = false;
        };

        Thread t1 = new Thread(r1);
        t1.setName("T1");

        Thread t2 = new Thread(r2);
        t2.setName("T2");

        t1.start();
        t2.start();

        /*ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(r1);
        executorService.submit(r2);
        executorService.shutdown();*/

    }

    public static void main(String[] args) {
        VolatileDemo demo = new VolatileDemo();
        demo.test();
    }
}
