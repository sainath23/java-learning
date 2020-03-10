package com.sainath.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);

        for(int i = 0;;i++) {
            System.out.println(i);
            blockingQueue.put(i);
        }
    }
}
