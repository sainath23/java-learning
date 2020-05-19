package com.sainath.streams;

import java.util.PriorityQueue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapReduceDemo {
    public static void main(String[] args) {
        String[] words = {"one", "two", "three"};

        Stream<String> stream = Stream.of(words);

        int sum = stream.mapToInt(str -> str.length()).reduce(0, (len1, len2) -> len1 + len2);
        System.out.println(sum);
        System.out.println(IntStream.of(1, 2, 3, 4).reduce(1, (num1, num2) -> num1 * num2));
        System.out.println(Stream.of(words).reduce("", (s1, s2) -> s1 + " " + s2 ).trim());

        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n2.compareTo(n1));
        pq.offer(100);
        pq.offer(10);
        pq.offer(20);
        pq.offer(50);
        pq.offer(110);
        System.out.println(pq);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
