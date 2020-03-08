package com.sainath.multithreading;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class InterThreadCommunication {
    {
       // System.out.println("hhiii");
    }

    private final LinkedList<Integer> queue = new LinkedList<>();
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    private class MyProducerThread implements Runnable {
        @Override
        public void run() {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void produce() throws InterruptedException {
            Thread.sleep(2000);
            //synchronized (queue) {
            lock.lock();
                System.out.println(Thread.currentThread().getName() + " - Started... " + queue.size());
                for (int i = 1; i <= 10; i++) {
                    System.out.println("Producing: " + i);
                    queue.offer(i);
                }
                //queue.notify();
                condition.signal();
                lock.unlock();
            //}
        }
    }

    private class MyConsumerThread implements Runnable {
        @Override
        public void run() {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void consume() throws InterruptedException {
            //synchronized (queue) {
            lock.lock();
                System.out.println(Thread.currentThread().getName() + " - Started... " + queue.size());
                if (queue.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + " is waiting...");
                    //queue.wait();
                    condition.await();
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName() + " wait completed...");
                }
                for (int i = 1; i <= 10; i++) {
                    System.out.println("Consuming: " + queue.remove());
                }
            //}

        }
    }

    public static void main(String[] args) throws InterruptedException {
        InterThreadCommunication itc = new InterThreadCommunication();
        Thread producer = new Thread(itc.new MyProducerThread());
        producer.setName("PRODUCER");
        Thread consumer = new Thread(itc.new MyConsumerThread());
        consumer.setName("CONSUMER");

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        System.out.println("Final size = " + itc.queue.size());

        MyThrad t = itc.new MyThrad();
        Thread x = new Thread(t);
        //x.start();
    }

    class MyThrad extends Thread {
        @Override
        public void run() {
            for (int i=0; i<3; ++i) {
                System.out.println(i + "...");
            }
        }
    }
}
