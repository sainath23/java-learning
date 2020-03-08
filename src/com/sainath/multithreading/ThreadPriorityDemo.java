package com.sainath.multithreading;

public class ThreadPriorityDemo {

    private boolean exit = false;

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public static void main(String[] args) {
        Runnable r = () -> {
            long startTime = System.currentTimeMillis();
            long sum = 0;
            for (long i = 0; i < 5000000000L; i++) {
                sum += i;
            }
            long totalTime = System.currentTimeMillis() - startTime;
            System.out.println("Time taken: " + totalTime + " by thread: " + Thread.currentThread().getName());
        };

        Thread t1 = new Thread(r);
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.setName("MIN PRIORITY");

        Thread t2 = new Thread(r);
        t2.setPriority(Thread.NORM_PRIORITY);
        t2.setName("NORMAL PRIORITY");

        Thread t3 = new Thread(r);
        t3.setPriority(Thread.MAX_PRIORITY);
        t3.setName("MAX PRIORITY");

        t1.start();
        t2.start();
        t3.start();
    }
}
