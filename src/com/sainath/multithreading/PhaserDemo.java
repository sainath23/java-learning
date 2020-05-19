package com.sainath.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserDemo {

    static class Task implements Runnable {
        Phaser phaser;
        long millis;

        public Task(Phaser phaser, long millis) {
            this.phaser = phaser;
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
            phaser.arrive(); // act as countDown in CountDownLatch
            //phaser.arriveAndAwaitAdvance(); // act as cyclicBarrier.await()
        }
    }

    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        threadPool.execute(new Task(phaser, 8000));
        threadPool.execute(new Task(phaser, 1000));
        threadPool.execute(new Task(phaser, 2000));
        threadPool.shutdown();

        phaser.awaitAdvance(0);
        System.out.println("Phaser phase completed...");
    }
}
