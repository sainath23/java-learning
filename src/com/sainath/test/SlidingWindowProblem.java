package com.sainath.test;

/*
   A = [1, 9, -1, -2, 7, 3, -1, 2]
    Window size k = 4
    Find max window sum
    Max = 13 with window [9, -1, -2, 7]
 */
public class SlidingWindowProblem {

    public static void main(String[] args) {
        int[] numbers = {1, 9, -1, -2, 7, 3, -1, 2, 10, 20};
        System.out.println(maxWindowBruteForce(numbers, 4));
        System.out.println(maxWindowOptimized(numbers, 4));
    }

    // TC: O(n * k)
    private static int maxWindowBruteForce(int[] numbers, int k) {
        int maxSum = 0;

        for (int i = 0; i <= numbers.length - k; i++) {
            int windowSum = 0;
            for (int j = i; j < i+k; j++) {
                windowSum += numbers[j];
            }

            maxSum = Math.max(windowSum, maxSum);
        }

        return maxSum;
    }

    // A = [1, 9, -1, -2, 7, 3, -1, 2]
    // TC = O(k + n)
    private static int maxWindowOptimized(int[] numbers, int k) {
        int maxSum = 0;
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += numbers[i];
        }

        if (k == numbers.length) {
            return windowSum;
        }

        for (int end = k; end < numbers.length; end++) {
            windowSum += numbers[end] - numbers[end - k];
            maxSum = Math.max(windowSum, maxSum);
        }

        return maxSum;
    }
}
