package com.sainath.multithreading;

import java.util.Timer;
import java.util.TimerTask;

public class Worker extends Thread {

    private Object lock = new Object();
    private volatile boolean quittingTime = false;

    @Override
    public void run() {
        while (!quittingTime) {
            working();
            System.out.println("Still working... " + Thread.currentThread().getName());
        }

        System.out.println("Coffee is good!");
    }

    private void working() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {}
    }

    synchronized void quit() throws InterruptedException {
        synchronized (lock) {
            quittingTime = true;
            System.out.println("Calling join " + Thread.currentThread().getName());
            join();
            System.out.println("Back from join");
        }
    }

    synchronized void keepWorking() {
       /* try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
       synchronized (lock) {
           quittingTime = false;
           System.out.println("Keep working... " + Thread.currentThread().getName());
       }
    }

    public static void main(String[] args) throws InterruptedException {
        final Worker worker = new Worker();
        worker.start();

        Timer timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                worker.keepWorking();
            }
        }, 500);
        Thread.sleep(400);
        worker.quit();
        System.out.println("finished....");
    }
}
