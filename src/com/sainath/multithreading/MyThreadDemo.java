package com.sainath.multithreading;

public class MyThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            System.out.println("2. " + Thread.currentThread().getState().name());
            System.out.println("Executing a job");
            System.out.println("3. " + Thread.currentThread().getState().name());
        };

        Thread t = new Thread(r);
        System.out.println("1. " + t.getState().name());
        t.start();
        t.join();
        System.out.println("4. " + t.getState().name());
    }
}
