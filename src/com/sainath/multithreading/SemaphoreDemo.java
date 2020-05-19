package com.sainath.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SemaphoreDemo {

    private final Semaphore semaphore = new Semaphore(3);

    public void test() {
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + " got a chance...");
            try {
                System.out.println(Thread.currentThread().getName() + " trying to acquire semaphore... permit count = " + semaphore.availablePermits());
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " acquired semaphore... and stared doing work... permit count = " + semaphore.availablePermits());
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + " done with its work. It is now releasing the semaphore...");
                semaphore.release(0);
                System.out.println(Thread.currentThread().getName() + " has released semaphore permit. permit count = " + semaphore.availablePermits());
            }
        };
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        //IntStream.of(100).forEach(i -> threadPool.execute(r));
        for (int i = 0; i < 100; i++) {
            threadPool.execute(r);
        }
        threadPool.shutdown();
    }

    public static void main(String[] args) {
        SemaphoreDemo demo = new SemaphoreDemo();
        demo.test();
    }
}
