package com.sainath.collections;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

    public static void main(String[] args) {
        // default min heap == min priority
        PriorityQueue<Integer> pq = new PriorityQueue<>();
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


    }
}
