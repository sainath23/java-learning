package com.sainath.hackerrank;

import java.util.concurrent.atomic.AtomicInteger;

// {-2, -3, 4, -1, -2, 1, 5, -3}
// OP = 7 = {4, -1, -2, 1, 5}
public class LongestSumContiguousSubarray {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int maxSoFar = arr[0];
        int currMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
            System.out.println("currMax = " + currMax + ", maxSoFar = " + maxSoFar);
        }

        System.out.println(maxSoFar);
        AtomicInteger i = new AtomicInteger(1);
        i.incrementAndGet();
    }
}
