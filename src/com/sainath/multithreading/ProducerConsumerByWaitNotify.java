package com.sainath.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumerByWaitNotify {

    private static class MyBlockingQueue<E> {
        private int maxSize;
        private final Queue<E> queue;

        public MyBlockingQueue(int maxSize) {
            this.queue = new LinkedList<>();
            this.maxSize = maxSize;
        }

        public void put(E e) throws InterruptedException {
            synchronized (queue) {
                while (queue.size() == maxSize) {
                    System.out.println("put operation queue is full...");
                    queue.wait();
                }
                queue.offer(e);
                queue.notifyAll();
            }
        }

        public E take() throws InterruptedException {
            synchronized (queue) {
                while (queue.size() == 0) {
                    System.out.println("take operation queue is empty...");
                    queue.wait();
                }
                E e = queue.poll();
                queue.notifyAll();
                return e;
            }
        }
    }

    public static void main(String[] args) {
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
}
