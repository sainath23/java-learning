package com.sainath.multithreading;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

// Causes ConcurrentModificationException
public class ArrayListMultipleThreads {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        //List<Integer> list = new CopyOnWriteArrayList<>();
        list.add(100);
        list.add(200);
        list.add(300);
        list.add(null);

        Runnable r = () -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(4000);
        };
        new Thread(r).start();

        for(Integer i : list) {
            System.out.println(i);
            Thread.sleep(3000);
        }
    }
}
