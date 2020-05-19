package com.sainath.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2.compareTo(o1)));
        for(int i : stones) {
            maxHeap.offer(i);
        }

        //System.out.println(maxHeap);

        while (maxHeap.size() > 1) {
            System.out.println(maxHeap);
            Integer y = maxHeap.poll();
            Integer x = maxHeap.poll();

            //System.out.println("x = " + x + ", y = " + y);

            if (x != null && y != null && !x.equals(y)) {
                maxHeap.offer(y - x);
            }
        }


        System.out.println(maxHeap);
    }
}
