package com.sainath.test;

import java.util.HashMap;
import java.util.Map;

/*
* Given array and number find total subset that can make sum equal to given number
* Eg. [2, 4, 6, 10] number = 16
* {2, 4, 10} and {6, 10}
* return 2
*           {}
*         /    \
*       {10}    {}
*      /           \
*     {10, 6}      {6}
*/
public class SubSetProblem {

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 10};
        Map<String, Integer> map = new HashMap<>();
        //int count = mFindSubset(arr, 16, arr.length-1, map);
        int count = rFindSubset(arr, 16, 0);
        System.out.println(count);

    }

    // Recursive naive solution
    public static int rFindSubset(int[] arr, int total, int index) {
        if (total == 0) {
            return 1;
        } else if (total < 0) {
            return 0;
        } else if (index > arr.length-1) {
            return 0;
        } else if (total < arr[index]){
            return rFindSubset(arr, total, index+1);
        } else {
            return rFindSubset(arr, total - arr[index], index+1) + rFindSubset(arr, total, index+1);
        }
    }

    // DP memoize solution
    public static int mFindSubset(int[] arr, int total, int index, Map<String, Integer> map) {
        String key = total + ":" + index;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int result;
        if (total == 0) {
            return 1;
        } else if (total < 0) {
            return 0;
        } else if (index < 0) {
            return 0;
        } else if (total < arr[index]){
            result = mFindSubset(arr, total, index-1, map);
        } else {
            result = mFindSubset(arr, total - arr[index], index-1, map) + mFindSubset(arr, total, index-1, map);
        }
        map.put(key, result);
        System.out.println(map);
        return result;
    }

    // DP bottom up solution
}
