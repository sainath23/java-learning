package com.sainath.multithreading;

public class AccessingSharedResource {
    private int x = 10;
    private long y = 20;
    private int count = 0;

    public void m1() throws InterruptedException {
        Runnable r1 = () -> {
            x = 1000;
            y = 2000;
            count++;
        };

        Runnable r2 = () -> {
            x = 3000;
            y = 4000;
            count++;
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        t1.join(1000);
        t2.join();
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("count = " + count);
    }

    public static void main(String[] args) throws InterruptedException {
        AccessingSharedResource obj = new AccessingSharedResource();
        obj.m1();
    }
}
