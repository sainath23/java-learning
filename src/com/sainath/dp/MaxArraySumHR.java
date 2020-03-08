package com.sainath.dp;

/*
{-2, 1, 3, -4, 5}
Sub array with non-adjacent elements with max sum = {3, 5} = 8
 */

import java.util.HashMap;
import java.util.Map;

public class MaxArraySumHR {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        //int[] arr = {-2, 1, 3, -4, 5}; // 8
        //int[] arr = {2, 1, 5, 8, 4}; // 11  => {2, 5, 4}
        //int[] arr = {3, 5, -7, 8, 10}; // 15 => {5, 10}
        int[] arr = {-5, 2, -5, -5, -5}; // -3 => {2, -5}
        //System.out.println(maxSubsetSum(arr, arr.length - 1, map));
        System.out.println(maxSubsetSumDP(arr));
    }

    static int maxSubsetSumDP(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        arr[0] = Math.max(0, arr[0]);
        arr[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            arr[i] = Math.max(arr[i - 1], arr[i] + arr[i - 2]);
        }
        return arr[arr.length - 1];
    }

    static int maxSubsetSumRecursion(int[] arr, int index) {

        if (index > arr.length - 1) {
            return 0;
        }

        return Math.max(arr[index] + maxSubsetSumRecursion(arr, index + 2), maxSubsetSumRecursion(arr, index + 1));

    }

    public static int maxSubsetSum(int[] arr, int index, Map<String, Integer> map) {
        if (index < 0) {
            return 0;
        }

        String key = index + " - " + (index - 2);
        String key2 = index + " - " + (index - 1);
        if (map.containsKey(key)) {
            return map.get(key);
        } else if (map.containsKey(key2)) {
            return map.get(key2);
        } else {
            int sum1 = arr[index] + maxSubsetSum(arr, index - 2, map);
            map.put(key, sum1);
            int sum2 = maxSubsetSum(arr, index - 1, map);
            map.put(key2, sum2);
            System.out.println(map);
            return Math.max(sum1, sum2);
        }
    }


}
