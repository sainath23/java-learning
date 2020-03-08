package com.sainath.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerUsingOwnBQ {
    private class MyBlockingQueue<E> {
        private final Queue<E> queue;
        private int maxSize;
        private final ReentrantLock lock = new ReentrantLock(true);
        private final Condition notEmpty = lock.newCondition();
        private final Condition notFull = lock.newCondition();

        public MyBlockingQueue(int maxSize) {
            this.queue = new LinkedList<>();
            this.maxSize = maxSize;
        }

        public void put(E e) throws InterruptedException {
            lock.lock();
            try {
                while (queue.size() == maxSize) {
                    notFull.await(); // means queue is full and i am going to wait
                }
                queue.offer(e);
                notEmpty.signalAll(); // means queue is not more empty
            } finally {
                lock.unlock();
            }
        }

        public E take() throws InterruptedException {
            lock.lock();
            try {
                while (queue.size() == 0) {
                    notEmpty.await();
                }
                E e = queue.poll();
                notFull.signalAll();
                return e;
            } finally {
                lock.unlock();
            }
        }
    }

    public void test() {
        MyBlockingQueue<Integer> blockingQueue = new MyBlockingQueue<>(10);
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

    public static void main(String[] args) {
        ProducerConsumerUsingOwnBQ demo = new ProducerConsumerUsingOwnBQ();
        demo.test();
    }
}
