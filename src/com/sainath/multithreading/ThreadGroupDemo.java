package com.sainath.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadGroupDemo {

    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("my-tg");
        System.out.println(tg.getParent().getName());
        System.out.println(tg.getMaxPriority());

        Thread t1 = new Thread(tg, "t1");
        Thread t2 = new Thread(tg, "t1");
        tg.setMaxPriority(3);
        Thread t3 = new Thread(tg, "t1");
        t3.setPriority(2);
        System.out.println(tg.getMaxPriority());
        System.out.println(t1.getPriority());
        System.out.println(t3.getPriority());
        tg.list();
        System.out.println(tg.activeCount());

        Runnable r1 = () -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread t4 = new Thread(tg, r1);
        t4.start();

        ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
        System.out.println("system => " + system.getName());
        system.list();
        Thread[] arr = new Thread[system.activeCount()];
        system.enumerate(arr);
        for (Thread t : arr) {
            System.out.println(t.getName() + "  => " + t.isDaemon());
        }

        Lock lock = new ReentrantLock();
    }
}
