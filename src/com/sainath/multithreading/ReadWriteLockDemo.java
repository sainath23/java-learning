package com.sainath.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

public class ReadWriteLockDemo {
    private List<Integer> list = new ArrayList<>();
    private final ReadWriteLock rwl = new ReentrantReadWriteLock();

    public void addToList(Integer i) {
        System.out.println(Thread.currentThread().getName() + " got a chance to addToList...");
        rwl.writeLock().lock();
        System.out.println(Thread.currentThread().getName() + " holding a write lock...");
        try {
            list.add(i);
        } finally {
            System.out.println(Thread.currentThread().getName() + " releasing write lock...");
            rwl.writeLock().unlock();
        }
    }

    public int findMaxFromList() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}

        System.out.println(Thread.currentThread().getName() + " got a chance to findMax...");
        rwl.readLock().lock();
        System.out.println(Thread.currentThread().getName() + " holding a read lock...");
        try {
            return list.stream().max((o1, o2) -> o1.compareTo(o2)).orElse(0);
        } finally {
            System.out.println(Thread.currentThread().getName() + " releasing read lock...");
            rwl.readLock().unlock();
        }
    }

    public void test() {
        Runnable r1 = () -> {
            System.out.println(Thread.currentThread().getName() + " found max = " + findMaxFromList());
        };

        Runnable r2 = () -> {
            Random random = new Random();
            for (int i = 0; i < 20; i++) {
                //list.add(random.nextInt(9999));
                addToList(random.nextInt(9999));
            }
            System.out.println("list: " + list);
            System.out.println("sorted list: " + list.stream().sorted().collect(Collectors.toList()));
        };

        Thread readerT1 = new Thread(r1);
        readerT1.setName("READER T1");

        Thread readerT2 = new Thread(r1);
        readerT2.setName("READER T2");

        Thread writerT = new Thread(r2);
        writerT.setName("WRITER T");

        readerT1.start();
        readerT2.start();
        writerT.start();

        ThreadPoolExecutor tpe = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        tpe.setCorePoolSize(6);
    }

    public static void main(String[] args) {
        ReadWriteLockDemo demo = new ReadWriteLockDemo();
        demo.test();
    }
}
