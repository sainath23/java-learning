package com.sainath.multithreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBlockingQueue {
    private static final BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {
        Runnable producerRunnable = () -> {
            System.out.println(Thread.currentThread().getName() + " started...");
            while (true) {
                try {
                    blockingQueue.put(new Random().nextInt(999));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(producerRunnable, "P1").start();
        new Thread(producerRunnable, "P2").start();

        Runnable consumerRunnable = () -> {
            System.out.println(Thread.currentThread().getName() + " started...");
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getName() + " consuming " + blockingQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(consumerRunnable, "C1").start();
        new Thread(consumerRunnable, "C2").start();
    }
}
