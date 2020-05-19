package com.sainath.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintFooBarAlternativelyLeetCode {

    private static class FooBar {
        private int n;
        private Semaphore fooSem, barSem;

        public FooBar(int n) {
            this.n = n;
            fooSem = new Semaphore(1);
            barSem = new Semaphore(0);
        }

        public void foo() throws InterruptedException {
            for (int i = 0; i < n; i++) {
                fooSem.acquire();
                System.out.println("foo");
                barSem.release();
            }
        }

        public void bar() throws InterruptedException {
            for (int i = 0; i < n; i++) {
                barSem.acquire();
                System.out.println("bar");
                fooSem.release();
            }
        }
    }

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(1);
        Runnable r1 = () -> {
            try {
                fooBar.foo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable r2 = () -> {
            try {
                fooBar.bar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        threadPool.execute(r2);
        threadPool.execute(r1);
        threadPool.shutdown();
    }
}
