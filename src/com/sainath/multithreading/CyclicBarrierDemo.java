package com.sainath.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {

    static class MyTask implements Runnable {
        private CyclicBarrier cyclicBarrier;

        public MyTask(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is started and sleeping for 500 ms");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " Hello Sainath... number of waiting threads = " + cyclicBarrier.getNumberWaiting() + ", " +
                    "parties = " + cyclicBarrier.getParties());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        MyTask task = new MyTask(cyclicBarrier);
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100; i++) {
            threadPool.execute(task);
        }
    }
}
