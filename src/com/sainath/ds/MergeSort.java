package com.sainath.ds;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {40, 10, 20, 90, 30, 50, 80, 70, 100, 60};
        int low = 0;
        int high = arr.length - 1;
        mergeSort(arr, low, high);
        System.out.println(Arrays.toString(arr));
        StringBuilder sb = new StringBuilder("SAINATH");
        System.out.println(sb.reverse());
        String s = Integer.toString(1234);
        System.out.println(s);
    }

    public static int[] mergeSort(int[] arr, int low, int high) {

        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }

        return arr;
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int i = 0, j = 0, k = low;

        // temp arrays
        int[] arr1 = new int[mid - low + 1];
        int[] arr2 = new int[high - mid];

        // copy to temp arrays
        for (int x = 0; x < arr1.length; x++) {
            arr1[x] = arr[low + x];
        }

        for (int x = 0; x < arr2.length; x++) {
            arr2[x] = arr[mid + x + 1];
        }

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                arr[k] = arr1[i];
                i++;
            } else {
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }

        if(i < arr1.length) {
            for (int x=i; x<arr1.length; x++) {
                arr[k] = arr1[x];
                k++;
            }
        }

        if(j < arr2.length) {
            for (int x=j; x<arr2.length; x++) {
                arr[k] = arr2[x];
                k++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
