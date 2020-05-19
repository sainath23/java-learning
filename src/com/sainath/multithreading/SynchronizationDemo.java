package com.sainath.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizationDemo {

    private static class Counter {
        private volatile int count;

        public synchronized void increment() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Lock lock = new ReentrantLock();
        Runnable r = () -> {
            //lock.lock();
            for (int i = 0; i < 1000; i++)
                counter.increment();
            //lock.unlock();
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Count = " + counter.getCount());
    }
}
