package com.sainath.ds;

public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int key = 60;
        System.out.println(key + " found at index = " + binarySearch(arr, key, 0, arr.length-1));
    }

    public static int binarySearch(int[] arr, int key, int low, int high) {

        if (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (key < arr[mid]){
                return binarySearch(arr, key, low, mid-1);
            } else {
                return binarySearch(arr, key, mid+1, high);
            }
        }

        return -1;
    }
}
