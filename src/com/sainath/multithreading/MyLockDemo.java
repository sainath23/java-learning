package com.sainath.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyLockDemo {

    Lock lock = new ReentrantLock();

    public void test() {
        Runnable r1 = () -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}
            boolean locked = lock.tryLock();
            if (locked) {
                try {
                    System.out.println("I got lock now...");
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("I don't have lock but I am continue to execute...");
            }
        };

        Runnable r2 = () -> {
            lock.lock();
            try {
                Thread.sleep(2000);
                System.out.println("I am runnable 2 and got the lock...");
            } catch (InterruptedException e) {
            } finally {
                lock.unlock();
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        MyLockDemo demo = new MyLockDemo();
        demo.test();
    }
}
