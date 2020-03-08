package com.sainath.ds;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {40, 10, 20, 90, 30, 50, 80, 70, 100, 60};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high) {

        if (low < high) {
            int k = partition(arr, low, high);
            quickSort(arr, low, k-1);
            quickSort(arr, k+1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
