package com.sainath.multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

    public static void main(String[] args) {
        Display d = new Display();
        Runnable r1 = () -> {
            d.wish("Sainath");
        };

        Runnable r2 = () -> {
            d.wish("Parkar");
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

    }
}

class Display {
    ReentrantLock lock = new ReentrantLock();
    public void wish(String name) {
        if (lock.tryLock()) {
            for (int i = 0; i < 5; i++) {
                System.out.print("Good morning: ");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name);
            }
            lock.unlock();
        } else {
            System.out.println(Thread.currentThread().getName() + " did not get lock...");
        }


    }
}