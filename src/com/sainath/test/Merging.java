package com.sainath.test;

import java.util.Arrays;

public class Merging {

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {2, 4, 6, 8, 10};

        int[] result = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (k < result.length-1) {
            if (arr1[i] < arr2[j]) {
                result[k] = arr1[i];
                i++;
                k++;
            } else {
                result[k] = arr2[j];
                j++;
                k++;
            }
        }
        System.out.println(i);
        System.out.println(j);
        if (i < arr1.length) {
            for (int x=i; x<arr1.length; x++) {
                result[k] = arr1[x];
                k++;
            }
        }

        if (j < arr2.length) {
            for (int x=j; x<arr2.length; x++) {
                result[k] = arr2[x];
                k++;
            }
        }
        System.out.println(Arrays.toString(result));
    }
}
