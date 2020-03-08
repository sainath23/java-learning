package com.sainath.multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class ConcurrencyDemo {
    private int availableTickets = 1;
    private ReentrantLock lock = new ReentrantLock();

    public void execute() {
        Thread t1 = new Thread(() -> {
            lock.lock();
            if (availableTickets > 0) {
                bookTicket();
                availableTickets--;
            }
            lock.unlock();
        });

        Thread t2 = new Thread(() -> {
            lock.lock();
            if (availableTickets > 0) {
                bookTicket();
                availableTickets--;
            }
            lock.unlock();
        });

        t1.start();
        t2.start();
    }

    public static void main(String[] args) throws InterruptedException {

        ConcurrencyDemo cd = new ConcurrencyDemo();
        cd.execute();
        Thread.sleep(5000);

    }

    public void bookTicket() {
        System.out.println("Ticket is successfully booked by - " + Thread.currentThread().getName());
    }
}
