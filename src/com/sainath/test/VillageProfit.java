package com.sainath.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
You have to travel to different villages to make some profit.
In each village, you gain some profit. But the catch is, from a particular village i,
you can only move to a village j if and only if i < j and the profit gain from village j is a multiple
of the profit gain from village i.
6
1 2 3 4 9 8
op = 15 for (1, 2, 4, 8)
10
4 7 21 26 28 29 32 34 36 42
70

50
35 219 218 405 494 437 26 30 308 321 72 231 155 383 147 5 60 217 91 475 36 236 34 180 376 33 411 438 82 142 68 182 189 287 256 293 452 156 200 199 87 474 274 312 320 366 459 441 372 230
657
https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/avatar-and-his-quest-d939b13f/
 */
public class VillageProfit {

    public static void main(String[] args) {
        //int[] arr = {1, 1, 2, 3, 4, 9, 8};
        int[] arr = {4, 7, 21, 26, 28, 29, 32, 34, 36, 42};
        //int[] arr = {35, 219, 218, 405, 494, 437, 26, 30, 308, 321, 72, 231, 155, 383, 147, 5, 60, 217, 91, 475, 36, 236, 34, 180, 376, 33, 411, 438, 82, 142, 68, 182, 189, 287, 256, 293, 452, 156, 200, 199, 87, 474, 274, 312, 320, 366, 459, 441, 372, 230};
        Map<String, Integer> map = new HashMap<>();
        //System.out.println(maxProfitBruteForce(arr, 0, 1));
        System.out.println(solve2(arr));
    }

    public static int maxProfitBruteForce(int[] arr, int i, int j) {
        if (i >= arr.length - 1) {
            return arr[i];
        } else if (j > arr.length - 1) {
            return 0;
        } else if ((arr[j] > arr[i]) && (arr[j] % arr[i] == 0)) {
            return Math.max(arr[i] + maxProfitBruteForce(arr, j, j + 1), maxProfitBruteForce(arr, j, j + 1));
        }

        return Math.max(maxProfitBruteForce(arr, i, j + 1), maxProfitBruteForce(arr, j, j + 1));
    }

    public static int solve2(int[] p) {

        int returningProfit = 0;

        for (int x = p.length - 1; x >= 0; x--) {
            int currentVillage = 0;
            int currentProfitGain = 0;
            int runningProfit = 0;

            for (int i = x; i >= 0; i--) {
                if (i == x) {
                    currentVillage = i;
                    runningProfit += p[i];
                    currentProfitGain = p[i];
                }
                if (currentVillage > i && currentProfitGain % p[i] == 0) {
                    runningProfit += p[i];
                    currentProfitGain = p[i];
                    currentVillage = i;
                }
            }
            if (returningProfit < runningProfit)
            returningProfit = returningProfit < runningProfit ? runningProfit : returningProfit;
        }

        return returningProfit;
    }
}
