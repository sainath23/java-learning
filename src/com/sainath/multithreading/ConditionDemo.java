package com.sainath.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConditionDemo {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private final Queue<Integer> queue = new LinkedList<>();
    //private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void test() {
        Runnable producerRunnable = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}

            lock.lock();
            try {
                for (int i = 1; i <= 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " producing " + i);
                    queue.offer(i);
                }
                System.out.println(Thread.currentThread().getName() + " giving signal...");
                condition.signal();
            } finally {
                System.out.println(Thread.currentThread().getName() + " is releasing a lock...");
                lock.unlock();
            }
        };

        Runnable consumerRunnable = () -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting...");
                condition.await(); // automatically releases the lock
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " consuming " + queue.poll());
                }
            } catch (InterruptedException e) {
            } finally {
                System.out.println(Thread.currentThread().getName() + " is releasing a lock...");
                lock.unlock();
            }
        };

        Thread producer = new Thread(producerRunnable);
        producer.setName("PRODUCER");
        Thread consumer = new Thread(consumerRunnable);
        consumer.setName("CONSUMER");

        producer.start();
        consumer.start();
    }

    public static void main(String[] args) {
        ConditionDemo cd = new ConditionDemo();
        cd.test();
    }
}
