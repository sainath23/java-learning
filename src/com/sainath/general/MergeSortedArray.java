package com.sainath.general;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 5, 8};
        int[] arr2 = {3, 4, 7, 9, 10};

        //int[] sortedArr1 = mergeSortedArrBruteForce(arr1, arr2);
        int[] sortedArr1 = mergeSortedArr(arr1, arr2);
        System.out.println(Arrays.toString(sortedArr1));
    }

    private static int[] mergeSortedArr(int[] arr1, int[] arr2) {
        int n = arr1.length + arr2.length;
        int[] sortedArr = new int[n];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length) {
            int num1 = arr1[i];
            int num2 = arr2[j];

            if (num1 < num2) {
                sortedArr[k] = num1;
                i++;
            } else {
                sortedArr[k] = num2;
                j++;
            }

            k++;
        }

        System.out.println("i = " + i + ", j = " + j + ", k = " + k);

        while (i < arr1.length) {
            sortedArr[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2.length) {
            sortedArr[k] = arr2[j];
            j++;
            k++;
        }

        return sortedArr;
    }

    private static int[] mergeSortedArrBruteForce(int[] arr1, int[] arr2) {
        int[] sortedArr = new int[arr1.length + arr2.length];

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr1.length; i++) {
            pq.offer(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            pq.offer(arr2[i]);
        }
        int count = 0;
        while (!pq.isEmpty() && count < sortedArr.length) {
            Integer num = pq.poll();
            if (num != null)
                sortedArr[count] = num;
            count++;
        }

        return sortedArr;
    }
}
