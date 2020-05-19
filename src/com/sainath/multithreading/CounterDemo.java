package com.sainath.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterDemo {

    class Counter {
        private AtomicInteger count = new AtomicInteger();

        public void increment() {
            count.getAndIncrement();
        }

        public int getCount() {
            return count.intValue();
        }
    }

    class IncrementerThread extends Thread {
        private Counter counter;

        public IncrementerThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CounterDemo cd = new CounterDemo();
        Counter counter = cd.new Counter(); // shared object

        IncrementerThread t1 = cd.new IncrementerThread(counter);
        IncrementerThread t2 = cd.new IncrementerThread(counter);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.getCount());

        AtomicInteger atomicInteger = new AtomicInteger();
        Runnable r = () -> {
            int i = 0;
            while (i < 100) {
                atomicInteger.incrementAndGet();
                i++;
            }
        };
        new Thread(r).start();
        new Thread(r).start();
        Thread.sleep(1000);
        System.out.println(atomicInteger.get());
    }
}
