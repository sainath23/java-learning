package com.sainath.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class CountDownLatchDemo {
    static class Task implements Runnable {
        CountDownLatch countDownLatch;
        long millis;

        public Task(CountDownLatch countDownLatch, long millis) {
            this.countDownLatch = countDownLatch;
            this.millis = millis;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " started its execution and sleeping for " + (millis/1000) + " seconds");
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " wakes up and calling phaser.arrive()");
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        threadPool.execute(new Task(countDownLatch, 8000));
        threadPool.execute(new Task(countDownLatch, 1000));
        threadPool.execute(new Task(countDownLatch, 2000));
        threadPool.shutdown();

        countDownLatch.await();
        System.out.println("CountDown has completed...");
    }
}
