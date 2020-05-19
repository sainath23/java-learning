package com.sainath.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/*

Implement a multithreaded version of FizzBuzz with four threads. The same instance of FizzBuzz will be passed to four different threads:

    Thread A will call fizz() to check for divisibility of 3 and outputs fizz.
    Thread B will call buzz() to check for divisibility of 5 and outputs buzz.
    Thread C will call fizzbuzz() to check for divisibility of 3 and 5 and outputs fizzbuzz.
    Thread D will call number() which should only output the numbers.

 */
public class FizzBuzzMultithreaded {
    private static class FizzBuzz {
        private final int n;
        private final AtomicBoolean atomicBoolean;
        private final Semaphore fizzSemaphore;
        private final Semaphore buzzSemaphore;
        private final Semaphore fizzBuzzSemaphore;
        private final Semaphore numberSemaphore;
        private final CountDownLatch latch;

        public FizzBuzz(int n)  {
            this.n = n;
            this.atomicBoolean = new AtomicBoolean(true);
            this.fizzSemaphore = new Semaphore(0);
            this.buzzSemaphore = new Semaphore(0);
            this.fizzBuzzSemaphore = new Semaphore(0);
            this.numberSemaphore = new Semaphore(1);
            this.latch = new CountDownLatch(n);
        }

        public void fizz() throws InterruptedException {
            while (atomicBoolean.get()) {
                if (fizzSemaphore.tryAcquire()) {
                    //fizzSemaphore.acquire();
                    System.out.println("fizz");
                    latch.countDown();
                    //System.out.println(String.format("latch count for i %d = %d", counter.intValue(), latch.getCount()));
                    numberSemaphore.release();
                }
            }
        }

        public void buzz() throws InterruptedException {
            while (atomicBoolean.get()) {
                if (buzzSemaphore.tryAcquire()) {
                    System.out.println("buzz");
                    latch.countDown();
                    //System.out.println(String.format("latch count for i %d = %d", counter.intValue(), latch.getCount()));
                    numberSemaphore.release();
                }
                //buzzSemaphore.acquire();

            }
        }

        public void fizzBuzz() throws InterruptedException {
            while (atomicBoolean.get()) {
                if (fizzBuzzSemaphore.tryAcquire()) {
                    System.out.println("fizzbuzz");
                    latch.countDown();
                    //System.out.println(String.format("latch count for i %d = %d", counter.intValue(), latch.getCount()));
                    numberSemaphore.release();
                }
                //fizzBuzzSemaphore.acquire();

            }
        }

        public void printNumber() throws InterruptedException {
            for(int i = 1; i <= n; i++) {
                numberSemaphore.acquire();

                if (i % 3 == 0 && i % 5 == 0) {
                    // give chance to fizzBuzz thread
                    fizzBuzzSemaphore.release();
                } else if (i % 3 == 0) {
                    // give chance to fizz thread
                    fizzSemaphore.release();
                } else if (i % 5 == 0) {
                    // give chance to buzz thread
                    buzzSemaphore.release();
                } else {
                    System.out.println(i);
                    latch.countDown();
                    //System.out.println(String.format("latch count for i %d = %d", counter.intValue(), latch.getCount()));
                    numberSemaphore.release();
                }
            }
            //System.out.println("increasing count for stop!");

            latch.await();
            System.out.println("count of latch = " + latch.getCount());
            atomicBoolean.set(false);
            //System.out.println("count increased");
        }
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);

        Runnable fizzR = () -> {
            try {
                fizzBuzz.fizz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable buzzR = () -> {
            try {
                fizzBuzz.buzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable fizzBuzzR = () -> {
            try {
                fizzBuzz.fizzBuzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable printNumberR = () -> {
            try {
                fizzBuzz.printNumber();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        threadPool.execute(fizzR);
        threadPool.execute(buzzR);
        threadPool.execute(printNumberR);
        threadPool.execute(fizzBuzzR);
        threadPool.shutdown();
    }
}
