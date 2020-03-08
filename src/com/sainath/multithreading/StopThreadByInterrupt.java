package com.sainath.multithreading;

public class StopThreadByInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + " has started...");
            while (!Thread.currentThread().isInterrupted()) {
                // Task to do...
                System.out.println(Thread.currentThread().getName() + " is executing....");
            }

            /*for (long i = 0; i < Long.MAX_VALUE; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + " is interrupted...");
                    return;
                }
            }*/
        };

        Thread t = new Thread(r, "MY-THREAD");
        t.start();
        System.out.println("Main thread is going to sleep for 4 seconds...");
        Thread.sleep(4000);
        System.out.println("Main thread wakeup from the sleep...");
        System.out.println("Main thread going to interrupt " + t.getName());
        t.interrupt();
    }
}
