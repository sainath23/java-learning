package com.sainath.test;

import java.util.Arrays;

public class NumberCloseToZero {
    public static void main(String[] args) {
        int[] arr = {2, 3, -3, -1, 1};

        int closeToZero = arr[0];
        int distance = Math.abs(arr[0]);
        for(int i=0; i<arr.length; i++) {

            if(distance > Math.abs(arr[i])) {
                distance = Math.abs(arr[i]);
                closeToZero = arr[i];
            } else if(distance == Math.abs(arr[i]) && arr[i] > 0 && closeToZero < 0) {
                closeToZero = arr[i];
            }
        }
        System.out.println(closeToZero);
    }
}
