package com.sainath.multithreading;

import java.util.concurrent.Callable;

public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + " -> " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //Thread.yield();
                //Thread.currentThread().interrupt();
            }
        };

        Thread t = new Thread(runnable);
        t.setPriority(10);
        t.start();
        t.join();
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " -> " + i);
        }
    }
}
