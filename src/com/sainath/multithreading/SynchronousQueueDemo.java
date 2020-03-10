package com.sainath.multithreading;

import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                for (;;)
                    synchronousQueue.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (;;)
                    System.out.println(synchronousQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
