package com.sainath.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class DequeDemo {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            deque.offer(num);
            set.add(num);

            if(deque.size() == m) {
                Integer polledElement = deque.poll();

                if(set.size() > max) {
                    max = set.size();
                }
                if (!deque.contains(polledElement)) {
                    set.remove(polledElement);
                }
            }
        }
        System.out.println(max);
    }
}
