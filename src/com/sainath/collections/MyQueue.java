package com.sainath.collections;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {

    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        queue.add(100);
        queue.add(200);
        queue.add(300);
        queue.add(400);
        queue.add(500);

        System.out.println("Initial queue:");
        System.out.println(queue);

        System.out.println("Removing element");
        queue.remove();
        System.out.println(queue);
    }
}
