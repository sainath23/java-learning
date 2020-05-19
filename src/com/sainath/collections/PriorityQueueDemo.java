package com.sainath.collections;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PriorityQueueDemo {

    public static void main(String[] args) {
        // default min heap == min priority
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2.compareTo(i1));
        pq.add(100);
        pq.add(800);
        pq.add(200);
        pq.add(400);
        pq.add(900);
        pq.add(300);
        pq.offer(4);
        System.out.println(pq);
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());

        long startTime = System.currentTimeMillis();
        String str = "";
        for(int i = 0; i < 100000; i++) {
            str += "Sainath";
        }
        System.out.println(System.currentTimeMillis() - startTime);

        startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10000000; i++) {
            sb.append("Sainath");
        }
        System.out.println(System.currentTimeMillis() - startTime);

        Integer.parseInt("10001", 2);
    }
}
